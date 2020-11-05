package com.example.soccerspainleague.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soccerspainleague.service.DataController;
import com.example.soccerspainleague.R;
import com.example.soccerspainleague.adapter.LeaguesAdapter;
import com.example.soccerspainleague.models.LeaguesModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeaguesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeaguesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerView;
    CardView cardView;
    TextView textView;
    DataController controller;

    public LeaguesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeaguesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeaguesFragment newInstance(String param1, String param2) {
        LeaguesFragment fragment = new LeaguesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_leagues, container, false);
        controller = new DataController(getContext());

        recyclerView = view.findViewById(R.id.fragment_leagues);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(llm);

        List<LeaguesModel.Leagues> gamesModel = controller.retrieveLeagues();
        LeaguesAdapter adapter = new LeaguesAdapter( getContext(),gamesModel);
        recyclerView.setAdapter(adapter);
//        getGamesSpain();
        return view;
    }

//    public void getGamesSpain(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(Api.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        Api api = retrofit.create(Api.class);
//
//        Call<LeaguesModel> call = api.getLeague();
//        call.enqueue(new Callback<LeaguesModel>() {
//            @Override
//            public void onResponse(Call<LeaguesModel> call, Response<LeaguesModel> response) {
//                List<LeaguesModel.Leagues> gamesModel = response.body().getLeagues();
//                if(gamesModel == null || gamesModel.size() == 0 ){
//                }else{
//                    LeaguesAdapter adapter = new LeaguesAdapter( getContext(),gamesModel);
//                    recyclerView.setAdapter(adapter);
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<LeaguesModel> call, Throwable t) {
//                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}