package ru.avdeev.android.a7_1_1_data_synchronization;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.LocalTime;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btnSinc);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                LocalTime now = LocalTime.now();
                LocalTime six = LocalTime.parse( "06:00" );
                LocalTime fourteen = LocalTime.parse( "14:00" );
                LocalTime fifteen = LocalTime.parse( "15:00" );
                Intent intent = new Intent(Intent.ACTION_SYNC);
                if (now.isAfter(six) && now.isBefore(fifteen)) {
                    intent.setData(Uri.parse("http://morning"));

                } else {
                    if (now.isAfter(fourteen) && now.isBefore(fifteen)) {
                        intent.setData(Uri.parse("http://afternoon"));

                    } else {
                        intent.setData(Uri.parse("http://evening"));

                    }
                }
                startActivity(intent);
            }
        });
    }
}