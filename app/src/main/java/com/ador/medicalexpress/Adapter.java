package com.ador.medicalexpress;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

/**
 * Created by ADOR'S Lappy on 12-May-17.
 */

public class Adapter extends RecyclerView.Adapter <Adapter.ViewHolder>{

    private List<BloodRequest> bloodRequests;
    private Context context;

    public Adapter(List<BloodRequest> bloodRequests, Context context) {
        this.bloodRequests = bloodRequests;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BloodRequest bloodRequest = bloodRequests.get(position);
        holder.name.setText(bloodRequest.getName());
        holder.blood_group.setText(bloodRequest.getBlood_group());
        holder.place.setText(bloodRequest.getPlace());
        holder.contact.setText(bloodRequest.getContact());
        holder.date.setText(bloodRequest.getDate());

    }

    @Override
    public int getItemCount() {
        return bloodRequests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView name,blood_group,place,contact,date;

        public ViewHolder(View itemView) {
            super(itemView);

            name= (TextView)itemView.findViewById(R.id.tvName);
            blood_group = (TextView)itemView.findViewById(R.id.tvBloodGrp);
            place = (TextView)itemView.findViewById(R.id.tvPlace);
            contact = (TextView)itemView.findViewById(R.id.tvContact);
            date = (TextView)itemView.findViewById(R.id.tvDate);

        }
    }
}
