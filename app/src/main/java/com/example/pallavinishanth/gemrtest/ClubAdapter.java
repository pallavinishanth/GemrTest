package com.example.pallavinishanth.gemrtest;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by pallavinishanth on 1/19/18.
 */

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Club> clubnames;

    public ClubAdapter(Context context, ArrayList<Club> club_data){

        this.mContext = context;
        this.clubnames = club_data;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String name = clubnames.get(position).getName();
        holder.clubnameView.setText(name);
    }

    @Override
    public int getItemCount() {
        return clubnames.size();
    }

    @Override
    public ClubAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View mview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.club_list, parent, false);

        return new ViewHolder(mview);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView clubnameView;

        public ViewHolder(final View view) {
            super(view);
            clubnameView = (TextView) view.findViewById(R.id.club_name);
        }
    }
}
