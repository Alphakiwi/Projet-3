package com.openclassrooms.entrevoisins.service;

import android.content.Context;

import com.openclassrooms.entrevoisins.NewFunctionality.PresentationActivity;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

/**
 * Unit test on Neighbour service
 */
@RunWith(JUnit4.class)
public class NeighbourServiceTest {

    private NeighbourApiService service;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test
    public void getNeighboursWithSuccess() {
        List<Neighbour> neighbours = service.getNeighbours();
        List<Neighbour> expectedNeighbours = DummyNeighbourGenerator.DUMMY_NEIGHBOURS;
        assertThat(neighbours, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighbours.toArray()));
    }

    @Test
    public void deleteNeighbourWithSuccess() {
        Neighbour neighbourToDelete = service.getNeighbours().get(0);
        service.deleteNeighbour(neighbourToDelete);
        assertFalse(service.getNeighbours().contains(neighbourToDelete));
    }

    // Mes tests que j'ai créé



    @Test
    public void getStarUser() {
        List<Neighbour> neighboursStar = service.getNeighboursStar();
        List<Neighbour> expectedNeighboursStar = DummyNeighbourGenerator.DUMMY_NEIGHBOURS_STAR;
        assertThat(neighboursStar, IsIterableContainingInAnyOrder.containsInAnyOrder(expectedNeighboursStar.toArray()));
    }

    @Test
    public void deleteStarUser() {
        Neighbour neighbourToDeleteStar = service.getNeighboursStar().get(0);
        service.deleteNeighbourStar(neighbourToDeleteStar);
        assertFalse(service.getNeighboursStar().contains(neighbourToDeleteStar));

    }

    @Test
    public void addStarUser() {
        Neighbour neighbourToAddStar = service.getNeighbours().get(0);
        service.addNeighbourStar(neighbourToAddStar);
        assertTrue(service.getNeighboursStar().contains(neighbourToAddStar));

    }

    @Test
    public void addUser() {

        Neighbour neighbourToAdd = service.getNeighbours().get(0);
        service.addNeighbour(neighbourToAdd);
        assertTrue(service.getNeighbours().contains(neighbourToAdd));

    }



}
