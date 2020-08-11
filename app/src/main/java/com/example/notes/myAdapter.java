package com.example.notes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.MyViewHolder> {

    Context cont;
     ArrayList<Notes> values;

    public myAdapter( Context c,ArrayList<Notes> values) {
        this.values = values;
        this.cont = c;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView text1, text2, text3;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            text1 = (TextView) itemView.findViewById(R.id.firstname);
            text2 = (TextView) itemView.findViewById(R.id.lastname);
            text3 = (TextView) itemView.findViewById(R.id.textid);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent  intent = new Intent(cont,EditNotes.class);
                    String Ts = text1.getText().toString();
                    String ps = text2.getText().toString();
                    String id = text3.getText().toString();
                    intent.putExtra("Title",Ts);
                    intent.putExtra("Preacher",ps);
                    intent.putExtra("id",id);
                    cont.startActivity(intent);
                }
            });



        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(cont);
        View view = inflater.inflate(R.layout.sample_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text1.setText(values.get(position).getTitle());
        holder.text2.setText(values.get(position).getPreacher());
        holder.text3.setText(values.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return values.size();
    }
}



