package io.prolabs.pro.api.github;

import com.google.gson.JsonElement;

import java.util.List;

import io.prolabs.pro.models.github.CodeWeek;
import io.prolabs.pro.models.github.CommitActivity;
import io.prolabs.pro.models.github.Gist;
import io.prolabs.pro.models.github.Repo;
import io.prolabs.pro.models.github.GitHubUser;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface GitHubService {

    @GET("/user")
    void getAuthUser(Callback<GitHubUser> callback);

    @GET("/user/repos")
    void getRepos(@Query("per_page") int reposPerPage, Callback<List<Repo>> callback);

    @GET("/repos/{user}/{repo}/languages")
    void getLanguages(@Path("user") String user, @Path("repo") String repo, Callback<JsonElement> callback);

    @GET("/repos/{user}/{repo}/stats/commit_activity")
    void getCommitActivity(@Path("user") String user, @Path("repo") String repo, Callback<CommitActivity> callback);

    @GET("/repos/{user}/{repo}/stats/code_frequency")
    void getCodeFrequency(@Path("user") String user, @Path("repo") String repo, Callback<JsonElement> callback);

    // Doesn't take a user; assumes the authenticated user.
    @GET("/gists/public")
    void getGists(Callback<List<Gist>> callback);

}