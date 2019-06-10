package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class AddNeighbourStarEvent {


    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public AddNeighbourStarEvent(Neighbour neighbour) {

        this.neighbour = neighbour;
    }

}
