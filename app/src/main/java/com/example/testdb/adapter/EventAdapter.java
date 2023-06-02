package com.example.testdb.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.R;
import com.example.testdb.model.Event;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventHolder>{
    private List<Event> eventList;

    public EventAdapter(List<Event> eventList) {
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_event_item, parent, false);
        return new EventHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventHolder holder, int position) {
        Event event = eventList.get(position);
        holder.getType().setText(event.getType());
        holder.getReason().setText(event.getReason());
        holder.getDateFrom().setText((CharSequence) event.getDateFrom().toString());
        holder.getDateTo().setText((CharSequence) event.getDateTo().toString());
        holder.getGroupsNum().setText(event.getGrpupsNum());
        holder.getPredmet().setText(event.getPredmet());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }
}
