package com.example.testdb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testdb.adapter.EventAdapter;
import com.example.testdb.model.Event;
import com.example.testdb.model.User;
import com.example.testdb.retrofit.EventApi;
import com.example.testdb.retrofit.RetrofitService;
import com.example.testdb.retrofit.UserApi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class EventListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        recyclerView = findViewById(R.id.eventList_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton floatingActionButton = findViewById(R.id.eventList_fab);
        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, EventForm.class);
            startActivity(intent);
        });
    }

    private void loadEvent() {
        RetrofitService retrofitService = new RetrofitService();

        try {
            //
            //Получение Events
            //
            EventApi eventApi = retrofitService.getRetrofit().create(EventApi.class);
            eventApi.getAllEvent()
                    .enqueue(new Callback<List<Event>>() {
                        @Override
                        public void onResponse(Response<List<Event>> response, Retrofit retrofit) {
                            populateListView(response.body());
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(com.example.testdb.EventListActivity.this, "Failed to load events", Toast.LENGTH_SHORT).show();
                        }
                    });
        }catch (Exception e) {
            System.out.println("=======ERROR======" + e.getMessage()  + "=======ERROR======");
        }

        try {
            //
            //Получение User
            //
            UserApi userApi = retrofitService.getRetrofit().create(UserApi.class);
            Call<User> userCall = userApi.authentication("user1", "user1");
            userCall.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Response<User> response, Retrofit retrofit) {
                    // response.body() тут находятся данные пользоватля если вход успешный
                    try {
                        User userFromBD = response.body();
                        Toast.makeText(com.example.testdb.EventListActivity.this, userFromBD.getFio(), Toast.LENGTH_LONG).show();
                    }catch (Exception e) {
                        System.out.println("=======Exception======" + e.getMessage()  + "=======Exception======");
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Toast.makeText(com.example.testdb.EventListActivity.this, "Failed to Sign In", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            System.out.println("=======Exception======" + e.getMessage()  + "=======Exception======");
        }
    }

    private void populateListView(List<Event> eventList) {
        EventAdapter eventAdapter = new EventAdapter(eventList);
        recyclerView.setAdapter(eventAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadEvent();
    }
}