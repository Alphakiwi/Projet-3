package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.Toast;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.ActualiseEvent;
import com.openclassrooms.entrevoisins.events.AddNeighbourEvent;
import com.openclassrooms.entrevoisins.events.AddNeighbourStarEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListNeighbourActivity extends AppCompatActivity {

    // UI Components
    @BindView(R.id.tabs)
    TabLayout mTabLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.container)
    ViewPager mViewPager;

    ListNeighbourPagerAdapter mPagerAdapter;
    FloatingActionButton fab;
    String avatar ;
    int id ;
    String login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_neighbour);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        mPagerAdapter = new ListNeighbourPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        id = 13;
        configureFab();
    }


    private void configureFab() {

        fab = findViewById(R.id.fab);


        fab.setOnClickListener(view -> {
            login = "Denis";
            id += 1;
            //avatar = "https://api.adorable.io/AVATARS/512/" + id + ".png";
            avatar = "http://i.pravatar.cc/150?u=a042581f4e290267"+ id +"e";
            String numero  = "+33 7 50 25 51 " + id;



            new AlertDialog.Builder(view.getContext())
                    .setView(R.layout.dialog_choix_sujet)
                    .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            EditText etSujet = (EditText) ((AlertDialog) dialog).findViewById(R.id.sujet);
                            if (etSujet.getText().toString().length()>0) {
                                login = etSujet.getText().toString();
                            }
                            String description  = "Bonjour je suis " + login + ". Venez parler !";
                            EventBus.getDefault().post(new AddNeighbourEvent(new Neighbour(id,login,avatar,"Localisation indisponible",numero, description)));




                        }
                    })
                    .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .show();



        });
    }



    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().post(new ActualiseEvent());

    }
}
