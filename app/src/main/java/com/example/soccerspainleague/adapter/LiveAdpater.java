package com.example.soccerspainleague.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerspainleague.R;
import com.example.soccerspainleague.models.LiveModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LiveAdpater extends RecyclerView.Adapter<LiveAdpater.LiveViewHolder> {
    Context context;
    List<LiveModel> liveList;
    LiveModel live;
    @NonNull
    @Override
    public LiveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_info,parent,false);
        return new LiveAdpater.LiveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LiveViewHolder holder, int position) {
        live = liveList.get(position);

        holder.embedLive.loadData(live.getEmbed(),"text/html","utf-8");
//        holder.embedLive.loadUrl(live.getUrl());
//        Picasso.get().load(live.getThumbnail()).into(holder.thumbs, new Callback(){
//
//            @Override
//            public void onSuccess() {
//
//            }
//
//            @Override
//            public void onError(Exception e) {
//                holder.thumbs.setImageResource(R.drawable.brokes);
//
//            }
//        });
        holder.titleLive.setText(live.getTitle() == null ? "N/A" : live.getTitle());
        holder.dateMatch.setText(live.getDate() == null ? "N/A" : live.getDate());

    }

    @Override
    public int getItemCount() {
        return liveList.size();
    }

    public class LiveViewHolder extends RecyclerView.ViewHolder {
        TextView titleLive;
//        ImageView thumbs;
        WebView embedLive;
        TextView dateMatch;
        @SuppressLint("SetJavaScriptEnabled")
        public LiveViewHolder(@NonNull View itemView) {
            super(itemView);
            titleLive = itemView.findViewById(R.id.titleLive);
            embedLive = itemView.findViewById(R.id.embedLive);
            embedLive.getSettings().setJavaScriptEnabled(true);
            dateMatch = itemView.findViewById(R.id.dateMatch);
//            thumbs = itemView.findViewById(R.id.thumbs);
        }
    }
    public  LiveAdpater (Context context,List<LiveModel>liveList){
        this.context = context;
        this.liveList = liveList;
    }

}
