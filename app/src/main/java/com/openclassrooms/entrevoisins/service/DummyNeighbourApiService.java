package com.openclassrooms.entrevoisins.service;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.openclassrooms.entrevoisins.NewFunctionality.PresentationActivity;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.ui.neighbour_list.ListNeighbourActivity;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements  NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();

    private List<Neighbour> neighboursStar = DummyNeighbourGenerator.generateNeighboursStar();




    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighboursStar() {
        return neighboursStar;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbourStar(Neighbour neighbour) {
        neighboursStar.remove(neighbour);
    }

    @Override
    public void addNeighbourStar(Neighbour neighbour) {
        neighboursStar.add(neighbour);
    }

    @Override
    public void addNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }

}
