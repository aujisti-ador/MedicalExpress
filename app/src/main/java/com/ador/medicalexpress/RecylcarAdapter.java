package com.ador.medicalexpress;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ADOR'S Lappy on 11-May-17.
 */

public class RecylcarAdapter extends RecyclerView.Adapter <RecylcarAdapter.RecyclerViewHolder> {

    private static final int TYPE_HEAD = 0;
    private static final int TYPE_LIST = 1;


    ArrayList<BloodRequest> arrayList = new ArrayList<>();

    public RecylcarAdapter (ArrayList<BloodRequest> arrayList)
    {
        this.arrayList=arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType==TYPE_HEAD)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout,parent,false);
            RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,viewType);
            return recyclerViewHolder;
        }

        else if (viewType==TYPE_LIST)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
            RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view,viewType);
            return recyclerViewHolder;
        }
        return null;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        if (holder.viewType==TYPE_LIST)
        {
            BloodRequest bloodRequest = arrayList.get(position-1);
            holder.name.setText(bloodRequest.getName());
            holder.blood_group.setText(bloodRequest.getBlood_group());
            holder.place.setText(bloodRequest.getPlace());
            holder.contact.setText(bloodRequest.getContact());
            holder.date.setText(bloodRequest.getDate());
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size()+1;
    }


    public static class RecyclerViewHolder extends RecyclerView.ViewHolder
    {

        TextView name,blood_group,place,contact,date;
        int viewType;

        public RecyclerViewHolder(View view,int viewType) {
            super(view);

            if (viewType==TYPE_LIST)
            {
                name= (TextView)view.findViewById(R.id.tvName);
                blood_group = (TextView)view.findViewById(R.id.tvBloodGrp);
                place = (TextView)view.findViewById(R.id.tvPlace);
                contact = (TextView)view.findViewById(R.id.tvContact);
                date = (TextView)view.findViewById(R.id.tvDate);
                this.viewType = TYPE_LIST;
            }
            else if (viewType==TYPE_HEAD)
            {
                this.viewType = TYPE_HEAD;

            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0)
            return TYPE_HEAD;
            return TYPE_LIST;

    }
}
