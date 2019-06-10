package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;


/**
 * Neighbour API client
 */
public interface NeighbourApiService {

    /**
     * Get all my Neighbours
     * @return {@link List}
     */
    List<Neighbour> getNeighbours();

    /**
     * Deletes a neighbour
     * @param neighbour
     */
    void deleteNeighbour(Neighbour neighbour);

    List<Neighbour> getNeighboursStar();

    void deleteNeighbourStar(Neighbour neighbour);

    void addNeighbourStar(Neighbour neighbour);
    void addNeighbour(Neighbour neighbour);
}
