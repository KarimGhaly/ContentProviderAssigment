package com.example.contentproviderreceoverassigment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Admin on 9/26/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {
    Context context;
    List<Celebritie> celebritieList;

    public RVAdapter(Context context, List<Celebritie> celebritieList) {
        this.context = context;
        this.celebritieList = celebritieList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Celebritie C = celebritieList.get(position);
        holder.txtName.setText(C.getName());
        holder.imgView.setImageResource(C.getImageID());
        holder.txtAge.setText("Age: "+String.valueOf(C.getAge()));
        holder.txtDesc.setText("Bio: "+C.getDescription());
    }

    @Override
    public int getItemCount() {
        return celebritieList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName;
        ImageView imgView;
        TextView txtAge;
        TextView txtDesc;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtAge = (TextView) itemView.findViewById(R.id.txtAge);
            txtDesc = (TextView) itemView.findViewById(R.id.txtDesc);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
        }
    }
}
