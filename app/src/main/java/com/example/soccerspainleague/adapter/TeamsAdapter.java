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
import com.example.soccerspainleague.models.TeamsModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    Context context;
    List<TeamsModel.Team> teamList;
    TeamsModel.Team team;

    @NonNull
    @Override
    public TeamsAdapter.TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_info,parent,false);
        return new TeamsAdapter.TeamsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final TeamsViewHolder holder, int position) {
        team = teamList.get(position);
        Picasso.get().load(team.getStrTeamBadge()).into(holder.strTeamBadge, new Callback(){

            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(Exception e) {
                holder.strTeamBadge.setImageResource(R.drawable.brokes);

            }
        });
        holder.strTeam.setText(team.getStrTeam() == null ? "N/A" : team.getStrTeam());
        holder.strLeague.setText(team.getStrLeague() == null ? "N/A" : team.getStrLeague());
        holder.intFormedYear.setText(team.getIntFormedYear() == null ? "N/A" : team.getIntFormedYear());
        holder.strStadiumLocation.setText(team.getStrStadiumLocation() == null ? "N/A" : team.getStrStadiumLocation());
        holder.intStadiumCapacity.setText(team.getIntStadiumCapacity() == null ? "N/A" : team.getIntStadiumCapacity());


    }



    @Override
    public int getItemCount() {
        return teamList.size();
    }


    public class TeamsViewHolder extends RecyclerView.ViewHolder {
            ImageView strTeamBadge;
            TextView strTeam;
            TextView strLeague;
            TextView intFormedYear;
            TextView strStadiumLocation;
            TextView intStadiumCapacity;
        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            strTeamBadge =  itemView.findViewById(R.id.strTeamBadge);
            strTeam =  itemView.findViewById(R.id.strTeam);
            strLeague =  itemView.findViewById(R.id.strLeague);
            intFormedYear =  itemView.findViewById(R.id.intFormedYear);
            strStadiumLocation =  itemView.findViewById(R.id.strStadiumLocation);
            intStadiumCapacity =  itemView.findViewById(R.id.intStadiumCapacity);

        }
    }
    public TeamsAdapter(Context context, List<TeamsModel.Team>teamList){
        this.context = context;
        this.teamList = teamList;

    }
}
