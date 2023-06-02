package com.example.testdb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.adapter.EventAdapter;
import com.example.testdb.model.Event;
import com.example.testdb.retrofit.EventApi;
import com.example.testdb.retrofit.RetrofitService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("EventListActivity:onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = findViewById(R.id.eventList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.employeeList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, EventForm.class);
            startActivity(intent);
        });
    }

    private void loadEvent() {
        System.out.println("EventListActivity:loadEvent");
        RetrofitService retrofitService = new RetrofitService();
        EventApi eventApi = retrofitService.getRetrofit().create(EventApi.class);

        System.out.println("EventListActivity:loadEvent: " + eventApi.getAllEvent().toString());
        eventApi.getAllEvent()
                .enqueue(new Callback<List<Event>>() {
                    @Override
                    public void onResponse(Response<List<Event>> response, Retrofit retrofit) {
                        for (Event events: response.body()) {
                            System.out.println("============EventListActivity:onResponse============" + events);
                        }
                        populateListView(response.body());
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        System.out.println("EventListActivity:" + t.getMessage());
                        Toast.makeText(com.example.testdb.EventListActivity.this, "Failed to load employees", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void populateListView(List<Event> eventList) {
        System.out.println("EventListActivity:populateListView");
        EventAdapter eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);
    }

    @Override
    protected void onResume() {
        System.out.println("EventListActivity:onResume");
        super.onResume();
        loadEvent();
    }
}