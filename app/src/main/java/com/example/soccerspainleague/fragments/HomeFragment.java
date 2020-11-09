package com.example.soccerspainleague.fragments;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.soccerspainleague.R;
import com.example.soccerspainleague.adapter.LeaguesAdapter;
import com.example.soccerspainleague.adapter.LeaguesCardAdapter;
import com.example.soccerspainleague.adapter.NewsAdapter;
import com.example.soccerspainleague.models.LeaguesModel;
import com.example.soccerspainleague.models.NewsModel;
import com.example.soccerspainleague.service.DataController;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters

    RecyclerView recyclerView, newsRecyclerView;
    CardView cardView;
    TextView textView;
    DataController controller;


    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        controller = new DataController(getContext());

        recyclerView = view.findViewById(R.id.homeSliderTeam);
        newsRecyclerView = view.findViewById(R.id.homeNews);
        LinearLayoutManager llm1 = new LinearLayoutManager(getContext());
        newsRecyclerView.setLayoutManager(llm1);
        LinearLayoutManager llm = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(llm);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        List<LeaguesModel.Leagues> gamesModel = controller.retrieveLeagues();
        LeaguesCardAdapter adapter = new LeaguesCardAdapter( getContext(),gamesModel);
        recyclerView.setAdapter(adapter);

        List<NewsModel.Channel.Item> newsList = controller.retrieveNews();
        NewsAdapter newsAdapter = new NewsAdapter(getContext(), newsList);
        newsRecyclerView.setAdapter(newsAdapter);

//        getGamesSpain();
        return view;
    }
}