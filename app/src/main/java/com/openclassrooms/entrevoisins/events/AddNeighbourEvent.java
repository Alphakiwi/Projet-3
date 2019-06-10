package com.openclassrooms.entrevoisins.events;

import com.openclassrooms.entrevoisins.model.Neighbour;

public class AddNeighbourEvent {


    public Neighbour neighbour;

    /**
     * Constructor.
     * @param neighbour
     */
    public AddNeighbourEvent(Neighbour neighbour) {

        this.neighbour = neighbour;
    }

}
