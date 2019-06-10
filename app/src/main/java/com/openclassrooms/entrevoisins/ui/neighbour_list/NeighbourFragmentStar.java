package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.ActualiseEvent;
import com.openclassrooms.entrevoisins.events.AddNeighbourStarEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourStarEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;


public class NeighbourFragmentStar extends Fragment {

    private NeighbourApiService mApiService;
    private List<Neighbour> mNeighbours;
    private RecyclerView mRecyclerView;


    /**
     * Create and return a new instance
     * @return @{@link NeighbourFragmentStar}
     */
    public static NeighbourFragmentStar newInstance() {
        NeighbourFragmentStar fragment = new NeighbourFragmentStar();
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiService = DI.getNeighbourApiService();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_neighbour_list_star, container, false);
        Context context = view.getContext();
        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        initList();
        EventBus.getDefault().register(this);
        return view;
    }

    /**
     * Init the List of neighbours
     */
    private void initList() {
        mNeighbours = mApiService.getNeighboursStar();
        mRecyclerView.setAdapter(new MyNeighbourRecyclerViewAdapter(mNeighbours, mNeighbours, false));
    }


    @Override
    public void onDestroy() { // changer onStop par onDestroy
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    /**
     * Fired if the user clicks on a delete button
     * @param event
     */


    @Subscribe
    public void onDeleteNeighbour(DeleteNeighbourStarEvent event) {
        mApiService.deleteNeighbourStar(event.neighbour);
        initList();

    }


    @Subscribe
    public void onAddNeighbourStarEvent(AddNeighbourStarEvent event) {
        mApiService.addNeighbourStar(event.neighbour);
        initList();
    }

    @Subscribe
    public void onActualise(ActualiseEvent event) {
        initList();
    }


}
