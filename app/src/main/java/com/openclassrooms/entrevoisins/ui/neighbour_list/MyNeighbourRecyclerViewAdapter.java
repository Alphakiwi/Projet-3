package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.NewFunctionality.PresentationActivity;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.events.ActualiseEvent;
import com.openclassrooms.entrevoisins.events.AddNeighbourStarEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourEvent;
import com.openclassrooms.entrevoisins.events.DeleteNeighbourStarEvent;
import com.openclassrooms.entrevoisins.model.Neighbour;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;


public class MyNeighbourRecyclerViewAdapter extends RecyclerView.Adapter<MyNeighbourRecyclerViewAdapter.ViewHolder> {

    private final List<Neighbour> mNeighbours;
    private final List<Neighbour> mNeighboursStar;
    private final Boolean mStar;


    public MyNeighbourRecyclerViewAdapter(List<Neighbour> items, List<Neighbour> itemsStar, Boolean star) {
        mNeighbours = items;
        mNeighboursStar = itemsStar;
        mStar =  star;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_neighbour, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position ) {
        Neighbour neighbour = mNeighbours.get(position);

        holder.mNeighbourName.setText(neighbour.getName());
        Glide.with(holder.mNeighbourAvatar.getContext())
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mNeighbourAvatar);

        holder.mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStar == true) {
                    EventBus.getDefault().post(new DeleteNeighbourEvent(neighbour));
                }else{
                    EventBus.getDefault().post(new DeleteNeighbourStarEvent(neighbour));
                }
                EventBus.getDefault().post(new ActualiseEvent());

            }
        });
        holder.mStarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mNeighboursStar.contains(neighbour)){
                    EventBus.getDefault().post(new DeleteNeighbourStarEvent(neighbour));
                    holder.mStarButton.setImageResource(R.drawable.ic_star_border_yellow_24dp);
                    EventBus.getDefault().post(new ActualiseEvent());
                }else{
                    EventBus.getDefault().post(new AddNeighbourStarEvent(neighbour));
                    holder.mStarButton.setImageResource(R.drawable.ic_star_yellow_24dp);
                    EventBus.getDefault().post(new ActualiseEvent());
                }
            }
        });


        holder.mNeighbourName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent newPage = new Intent(holder.mNeighbourAvatar.getContext(), PresentationActivity.class);
                newPage.putExtra("nom",neighbour.getName());
                newPage.putExtra("avatar",neighbour.getAvatarUrl());
                newPage.putExtra("id",neighbour.getId());
                newPage.putExtra("localisation",neighbour.getLocalisation());
                newPage.putExtra("tel",neighbour.getTel());
                newPage.putExtra("description",neighbour.getDescription());
                holder.mNeighbourAvatar.getContext().startActivity(newPage);


            }
        });


        if (mStar == false){
            holder.mStarButton.setVisibility(GONE);
        }

        if (mNeighboursStar.contains(neighbour)){
            holder.mStarButton.setImageResource(R.drawable.ic_star_yellow_24dp);
        }else{
            holder.mStarButton.setImageResource(R.drawable.ic_star_border_yellow_24dp);
        }

    }

    @Override
    public int getItemCount() {
        return mNeighbours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_list_avatar)
        public ImageView mNeighbourAvatar;
        @BindView(R.id.item_list_name)
        public TextView mNeighbourName;
        @BindView(R.id.item_list_delete_button)
        public ImageButton mDeleteButton;
        @BindView(R.id.item_list_star_button)
        public ImageButton mStarButton;


        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
