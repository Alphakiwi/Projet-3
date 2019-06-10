package com.openclassrooms.entrevoisins.NewFunctionality;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.events.AddNeighbourStarEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourStarEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class PresentationActivity extends AppCompatActivity {

    private TextView text = null;
    private TextView lieuTel = null;
    private TextView presentation = null;
    private TextView loca = null;
    private TextView telephone = null;
    private TextView facebook = null;
    private ImageView image = null;
    private List<Neighbour> mNeighboursStar;
    private FloatingActionButton fab;
    private Button back;
    private Neighbour neighbour = null;
    private NeighbourApiService mApiService;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentation);

        mApiService = DI.getNeighbourApiService();
        mNeighboursStar = mApiService.getNeighboursStar();




        text = (TextView) findViewById(R.id.text);
        lieuTel = (TextView) findViewById(R.id.lieuTel);
        presentation = (TextView) findViewById(R.id.description);
        loca = (TextView) findViewById(R.id.loca);
        telephone = (TextView) findViewById(R.id.tel);
        facebook = (TextView) findViewById(R.id.facebook);
        image = (ImageView) findViewById(R.id.imageAvatar);

        Intent i = getIntent();
        String nom = i.getStringExtra("nom");
        int id = i.getIntExtra("id", 0);
        String avatar = i.getStringExtra("avatar");
        String localisation = i.getStringExtra("localisation");
        String tel = i.getStringExtra("tel");
        String description = i.getStringExtra("description");




        neighbour = new Neighbour(id,nom,avatar,localisation,tel,description);



        configureFab();
        configureBack();


        Glide.with(this)
                .load(avatar)
                .override(420, 350) // resizes the image to these dimensions (in pixel)
                .centerCrop()
                .into(image);



        text.setText(nom );
        lieuTel.setText(nom );
        presentation.setText(description);
        loca.setText(localisation);
        telephone.setText(tel );
        facebook.setText("www.facebook.fr/" + nom.toLowerCase());
        presentation.setMovementMethod(new ScrollingMovementMethod());

    }


    private void configureFab() {
        fab = findViewById(R.id.fab);

        if (mNeighboursStar.contains(neighbour)){
            fab.setImageResource(R.drawable.ic_star_yellow_24dp);
        }else{
            fab.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNeighboursStar.contains(neighbour)){
                    EventBus.getDefault().post(new DeleteNeighbourStarEvent(neighbour));
                    fab.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                }else{
                    EventBus.getDefault().post(new AddNeighbourStarEvent(neighbour));
                    fab.setImageResource(R.drawable.ic_star_yellow_24dp);
                }
            }
        });
    }

    private void configureBack() {
        back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });

    }



}
