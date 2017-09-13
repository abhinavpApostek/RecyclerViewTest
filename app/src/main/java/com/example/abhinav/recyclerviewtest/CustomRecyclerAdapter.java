package com.example.abhinav.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Abhinav on 8/30/2017.
 */

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private List<String> dataSet;
    public CustomRecyclerAdapter(List<String> dataSet)
    {
        this.dataSet=dataSet;
    }

    @Override
    public CustomRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        if(viewType==0)
        {
             v = inflater.inflate(R.layout.header, parent, false);
        }
        else if(viewType==dataSet.size()+1){
             v = inflater.inflate(R.layout.header, parent, false);
        }
        else
        v = inflater.inflate(R.layout.list_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if(position==dataSet.size()+1)
        {
            holder.textView.setText("FOOTER");
        }
        else if(position>0 && position<=dataSet.size()){
            holder.textView.setText(dataSet.get(position-1));
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(holder.v.getContext(),dataSet.get(position-1),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
    @Override
    public int getItemCount(){
        return dataSet.size()+2;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        View v;
        public ViewHolder(View itemView) {
            super(itemView);
            v=itemView;
            textView=(TextView)itemView.findViewById(R.id.textView);
        }
    }
}
