package com.example.soccerspainleague.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.soccerspainleague.Api;
import com.example.soccerspainleague.models.GamesModel;
import com.example.soccerspainleague.models.LeaguesModel;
import com.example.soccerspainleague.models.LiveModel;
import com.example.soccerspainleague.models.NewsModel;
import com.example.soccerspainleague.models.TeamsModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import static android.content.Context.MODE_PRIVATE;

public class DataController {
    private final String SHARED_PREFS = "shared_prefs";
    private final String LEAGUES = "leagues";
    private final String TEAMS = "teams";
    private final String GAMES = "games";
    private final String LIVE = "live";
    private final String NEWS = "news";
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public DataController(Context context) {
        this.context = context;
        this.sharedPreferences = this.context.getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        this.editor = sharedPreferences.edit();
    }

    public <T> void saveData(String calling, List<T> object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        editor.putString(calling ,json);
        editor.commit();
    }

//    public <T> void saveDataXML(String calling, List<T> object){
//        Gson gson = new Gson();
//        String json = gson.toJson(object);
//        editor.putString(calling ,json);
//        editor.commit();
//    }

    public List<LeaguesModel.Leagues> retrieveLeagues(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(LEAGUES,"");
        Type type = new TypeToken<List<LeaguesModel.Leagues>>(){}.getType();
        List<LeaguesModel.Leagues> objects = gson.fromJson(json, type);
        return objects;
    }

    public void getLeagueSpain(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<LeaguesModel> call = api.getLeague();

        call.enqueue(new Callback<LeaguesModel>(){
            @Override
            public void onResponse(Call<LeaguesModel> call, Response<LeaguesModel> response) {
                List<LeaguesModel.Leagues> leagues = response.body().getLeagues();
                saveData(LEAGUES,leagues);
                System.out.println("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa League Save");
            }

            @Override
            public void onFailure(Call<LeaguesModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void clearContents(){
        editor.clear();
        editor.commit();
    }
    public List<TeamsModel.Team> retrieveTeams(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(TEAMS,"");
        Type type = new TypeToken<List<TeamsModel.Team>>(){}.getType();
        List<TeamsModel.Team> objects = gson.fromJson(json, type);
        return objects;
    }
    public List<NewsModel.Channel.Item> retrieveNews(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(NEWS,"");
        Type type = new TypeToken<List<NewsModel.Channel.Item>>(){}.getType();
        List<NewsModel.Channel.Item> objects = gson.fromJson(json, type);
        return objects;
    }

    public void getTeamsSpain(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<TeamsModel> call = api.getTeams();

        call.enqueue(new Callback<TeamsModel>(){
            @Override
            public void onResponse(Call<TeamsModel> call, Response<TeamsModel> response) {
                List<TeamsModel.Team> teams = response.body().getTeams();
                saveData(TEAMS,teams);
                System.out.println("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa League Save");
            }

            @Override
            public void onFailure(Call<TeamsModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public List<GamesModel.Games> retrieveGames(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(GAMES,"");
        Type type = new TypeToken<List<GamesModel.Games>>(){}.getType();
        List<GamesModel.Games> objects = gson.fromJson(json, type);
        return objects;
    }

    public void getGamesSpain(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<GamesModel> call = api.getGames();

        call.enqueue(new Callback<GamesModel>(){
            @Override
            public void onResponse(Call<GamesModel> call, Response<GamesModel> response) {
                List<GamesModel.Games> games = response.body().getEvents();
                saveData(GAMES,games);
                System.out.println("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa League Save");
            }

            @Override
            public void onFailure(Call<GamesModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    public List<LiveModel> retrieveLive(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(LIVE,"");
        Type type = new TypeToken<List<LiveModel>>(){}.getType();
        List<LiveModel> objects = gson.fromJson(json, type);
        return objects;
    }

    public void getLiveSpain(){



    }

    public void getNewsData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.RSS_URL)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<NewsModel> call = api.getNewsDetails();

        call.enqueue(new Callback<NewsModel>(){
            @Override
            public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                List<NewsModel.Channel.Item> news = response.body().getChannel().getItem();
                saveData(NEWS,news);
                System.out.println("Aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa League Save");
            }

            @Override
            public void onFailure(Call<NewsModel> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
