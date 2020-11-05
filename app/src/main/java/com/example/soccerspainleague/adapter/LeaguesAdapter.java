package com.example.soccerspainleague.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccerspainleague.R;
import com.example.soccerspainleague.models.LeaguesModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LeaguesAdapter extends RecyclerView.Adapter<LeaguesAdapter.LeaguesViewHolder> {
    Context context;
    List<LeaguesModel.Leagues> leaguesList;
    LeaguesModel.Leagues leagues;
    @NonNull
    @Override
    public LeaguesAdapter.LeaguesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leagues_info,parent,false);
        return new LeaguesAdapter.LeaguesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final LeaguesAdapter.LeaguesViewHolder holder, int position) {
        leagues = leaguesList.get(position);
        Picasso.get().load(leagues.getStrBadge()).into(holder.strBadge, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                holder.strBadge.setImageResource(R.drawable.brokes);
            }
        });
        holder.strLeague.setText(leagues.getStrLeague() == null ? "N/A" : leagues.getStrLeague());
        holder.dateFirstEvent.setText(leagues.getDateFirstEvent() == null ? "N/A" : leagues.getDateFirstEvent());
        holder.strCurrentSeason.setText(leagues.getStrCurrentSeason() == null ? "N/A" : leagues.getStrCurrentSeason());


    }

    @Override
    public int getItemCount() {
        return leaguesList.size();
    }

    public class LeaguesViewHolder extends  RecyclerView.ViewHolder {
        ImageView strBadge;
        TextView strLeague;
        TextView dateFirstEvent;
        TextView strCurrentSeason;
        public LeaguesViewHolder(@NonNull View itemView) {
            super(itemView);
            strBadge = itemView.findViewById(R.id.strBadge);
            strLeague = itemView.findViewById(R.id.strLeague);
            dateFirstEvent = itemView.findViewById(R.id.dateFirstEvent);
            strCurrentSeason = itemView.findViewById(R.id.strCurrentSeason);

        }
    }
    public LeaguesAdapter(Context context, List<LeaguesModel.Leagues>leaguesList){
        this.context = context;
        this.leaguesList = leaguesList;

    }
}
