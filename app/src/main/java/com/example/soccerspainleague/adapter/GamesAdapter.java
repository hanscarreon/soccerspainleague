package com.example.soccerspainleague.adapter;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerspainleague.R;
import com.example.soccerspainleague.models.GamesModel;
import com.example.soccerspainleague.models.TeamsModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {
    Context context;
    List<GamesModel.Games> gamesList;
    GamesModel.Games games;
    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_info,parent,false);
        return new GamesAdapter.GamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GamesViewHolder holder, int position) {
        games = gamesList.get(position);

        if(games.getStrThumb() == null){
            holder.strThumb.setImageResource(R.drawable.brokes);
        }else {
            Picasso.get().load(games.getStrThumb()).into(holder.strThumb, new Callback() {

                @Override
                public void onSuccess() {

                }

                @Override
                public void onError(Exception e) {
                    holder.strThumb.setImageResource(R.drawable.brokes);
                }
            });
        }

        holder.strHomeTeam.setText(games.getStrHomeTeam() == null ? "N/A" : games.getStrHomeTeam());
        holder.intHomeScore.setText(games.getIntHomeScore() == null ? "N/A" : games.getIntHomeScore());
        holder.strAwayTeam.setText(games.getStrAwayTeam() == null ? "N/A" : games.getStrAwayTeam());
        holder.intAwayScore.setText(games.getIntAwayScore() == null ? "N/A" : games.getIntAwayScore());

    }

    @Override
    public int getItemCount() {
        return gamesList.size();
    }

    public class GamesViewHolder extends RecyclerView.ViewHolder {
        ImageView strThumb;
        TextView strHomeTeam;
        TextView intHomeScore;
        TextView strAwayTeam;
        TextView intAwayScore;
        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
            strThumb = itemView.findViewById(R.id.strThumb);
            strHomeTeam = itemView.findViewById(R.id.strHomeTeam);
            intHomeScore = itemView.findViewById(R.id.intHomeScore);
            strAwayTeam = itemView.findViewById(R.id.strAwayTeam);
            intAwayScore = itemView.findViewById(R.id.intAwayScore);
        }
    }
    public GamesAdapter(Context context , List<GamesModel.Games> gamesList){
        this.context = context;
        this.gamesList = gamesList;

    }

}
