package com.example.abhinav.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> items;
    private CustomRecyclerAdapter customRecyclerAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items=new ArrayList<>();
        for(int i=0;i<20;i++) {
            items.add(Integer.toString(i));
        }
        customRecyclerAdapter=new CustomRecyclerAdapter(items);
        recyclerView.setAdapter(customRecyclerAdapter);
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        return false;
                    }
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        if(viewHolder.getAdapterPosition()==0  )
                        {
                            customRecyclerAdapter.notifyItemChanged(0);
                        }
                        else if(viewHolder.getAdapterPosition()==items.size()+1)
                        {
                            customRecyclerAdapter.notifyItemChanged(items.size()+1);
                        }
                        else {
                            items.remove(viewHolder.getAdapterPosition() - 1);
                            customRecyclerAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
                        }
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


}
