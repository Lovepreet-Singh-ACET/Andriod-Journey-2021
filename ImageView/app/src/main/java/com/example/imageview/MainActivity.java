package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView f1 = findViewById(R.id.flower1);//get the id of first image view
        ImageView f2 = findViewById(R.id.flower2);//get the id of second image view
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Flower1", Toast.LENGTH_SHORT).show();//display the text on image click event
            }
        });
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Flower2", Toast.LENGTH_SHORT).show();//display the text on image click event
            }
        });
    }
}