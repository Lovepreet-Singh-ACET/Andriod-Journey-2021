package com.example.pickerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    DatePicker picker;
    Button btnGet;
    TextView tvw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvw =  findViewById(R.id.textView1);
        picker =  findViewById(R.id.datePicker1);
        btnGet =  findViewById(R.id.button1);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvw.setText("Selected Date: " + picker.getDayOfMonth() + "/" + (picker.getMonth() + 1) + "/" + picker.getYear());
            }
        });
    }
}