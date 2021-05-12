package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView text;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bundle extra = getIntent().getExtras();
        text = findViewById(R.id.textView);
        btn = findViewById(R.id.button);

        if(extra != null){
            text.setText(extra.getString("guess"));
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                intent.putExtra("msg", "Ack from second activity");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}