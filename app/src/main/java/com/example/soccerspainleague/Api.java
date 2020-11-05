package com.example.soccerspainleague;

import com.example.soccerspainleague.models.GamesModel;
import com.example.soccerspainleague.models.LeaguesModel;
import com.example.soccerspainleague.models.LiveModel;
import com.example.soccerspainleague.models.TeamsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";
    String BASE_URL2 = "https://www.scorebat.com/video-api/";

    @GET("search_all_leagues.php?c=Spain&s=Soccer")
    Call<LeaguesModel> getLeague();

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamsModel> getTeams();

    @GET("eventspastleague.php?id=4483")
    Call<GamesModel> getGames();

    @GET("v1")
    Call<List<LiveModel>> getLive();
}
