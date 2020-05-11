package com.example.android.calci.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.calci.R;
import com.example.android.calci.activity.RecyclerViewCallBacks;
import com.example.android.calci.model.Key;

import java.util.List;

/**
 * @author Abhishek Saxena
 * @since 18/8/19 12:32 PM
 */

public class KeyAdapter extends RecyclerView.Adapter<KeyAdapter.ViewHolder> {

    private Context context;
    private List<Key> keys;

    private RecyclerViewCallBacks listener;

    private ViewHolder viewHolder;

    /*public KeyAdapter(){

    }*/

    public KeyAdapter(Context context, List<Key> keys, RecyclerViewCallBacks listener) {
        this.context = context;
        this.keys = keys;
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Button keyItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            keyItem = itemView.findViewById(R.id.key_item);
            //view.setOnClickListener(this);
            keyItem.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(getAdapterPosition(), keys.get(getAdapterPosition()).getValue());
        }

        public Button getKeyItem(){
            return keyItem;
        }
    }

    @NonNull
    @Override
    public KeyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.button, parent, false);
        viewHolder =  new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KeyAdapter.ViewHolder holder, int position) {
        String key = keys.get(position).getValue();

        holder.keyItem.setText(key);

        applyClickEvents(holder,key, position);

    }

    @Override
    public int getItemCount() {
        return (keys != null && !keys.isEmpty()) ? keys.size() : 0;
    }

    private void applyClickEvents(ViewHolder holder, final String key, final int position) {

        holder.keyItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Key Pressed: " + key, Toast.LENGTH_SHORT).show();
                listener.onClick(position, key);
            }
        });
    }

    public ViewHolder getViewHolder() {
        return viewHolder;
    }
}
