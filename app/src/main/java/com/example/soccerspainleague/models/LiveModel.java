package com.example.soccerspainleague.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LiveModel {
    @SerializedName("title")
    private String title;
    @SerializedName("embed")
    private String embed;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("date")
    private String date;
    @SerializedName("side1")
    private Side side1;
    @SerializedName("side2")
    private Side side2;
    @SerializedName("competition")
    private Competition competition;
    @SerializedName("videos")
    private List<Video> videos = null;

    public String getTitle() {
        return title;
    }

    public String getEmbed() {
        return embed;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getDate() {
        return date;
    }

    public Side getSide1() {
        return side1;
    }

    public Side getSide2() {
        return side2;
    }

    public Competition getCompetition() {
        return competition;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public static class Side{
        @SerializedName("name")
        private String name;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class Competition{
        @SerializedName("name")
        private String name;
        @SerializedName("id")
        private Integer id;
        @SerializedName("url")
        private String url;

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class Video{
        @SerializedName("title")
        private String title;
        @SerializedName("embed")
        private String embed;


        public String getTitle() {
            return title;
        }

        public String getEmbed() {
            return embed;
        }
    }
}
