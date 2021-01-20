package ru.avdeev.android.a7_1_1_data_synchronization;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import java.time.LocalTime;

public class MorningActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning);
        TextView textViewTime = findViewById(R.id.morningSyncTime);
        textViewTime.setText(LocalTime.now().toString());
    }
}