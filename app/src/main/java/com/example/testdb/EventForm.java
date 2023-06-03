package com.example.testdb;

import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testdb.model.Event;
import com.example.testdb.retrofit.EventApi;
import com.example.testdb.retrofit.RetrofitService;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeComponents();
    }

    private void initializeComponents() {
        TextInputEditText inputEditTextReason = findViewById(R.id.reason);
        TextInputEditText inputEditTextType = findViewById(R.id.type);
        TextInputEditText inputEditTextDateFrom = findViewById(R.id.dateFrom);
        TextInputEditText inputEditTextDateTo = findViewById(R.id.dateTo);
        TextInputEditText inputEditTextGroupNum = findViewById(R.id.groupNum);
        TextInputEditText inputEditTextPredmet = findViewById(R.id.predmet);
        MaterialButton buttonSave = findViewById(R.id.form_buttonSave);

        RetrofitService retrofitService = new RetrofitService();
        EventApi eventApi = retrofitService.getRetrofit().create(EventApi.class);

        buttonSave.setOnClickListener(view -> {

            Event event = new Event();
            event.setReason(String.valueOf(inputEditTextReason.getText()));
            event.setType(String.valueOf(inputEditTextType.getText()));
            event.setDateFrom(String.valueOf(inputEditTextDateFrom.getText()));
            event.setDateTo(String.valueOf(inputEditTextDateTo.getText()));
            event.setGrpupsNum(String.valueOf(inputEditTextGroupNum.getText()));
            event.setPredmet(String.valueOf(inputEditTextPredmet.getText()));


            eventApi.save(event)
                    .enqueue(new Callback<Event>() {
                        @Override
                        public void onResponse(Response<Event> response, Retrofit retrofit) {
                            Toast.makeText(EventForm.this, "Save successful!", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Toast.makeText(EventForm.this, "Save failed!!!", Toast.LENGTH_SHORT).show();
                            Logger.getLogger(EventForm.class.getName()).log(Level.SEVERE, "Error occurred", t);
                        }
                    });
        });
    }
}