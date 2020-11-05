package com.example.soccerspainleague.service;

import com.example.soccerspainleague.models.LeaguesModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api {
    String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("search_all_leagues.php?c=Spain&s=Soccer")
    Call<LeaguesModel> getLeague();
}
