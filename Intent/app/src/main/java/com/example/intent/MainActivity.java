package com.example.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 2;
    private Button guessBtn;
    private EditText guessTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guessTxt = findViewById(R.id.guess_text);
        guessBtn = findViewById(R.id.guess_btn);


        guessBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String guess =  guessTxt.getText().toString().trim();

                if (!guess.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("guess", guess);
                    startActivityForResult(intent, REQUEST_CODE);
                    //startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this,"Enter guess",
                            Toast.LENGTH_SHORT)
                            .show();
                }

                // startActivity(new Intent(MainActivity.this, ShowGuess.class));
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE){
            assert data !=null;
            String msg = data.getStringExtra("msg");

            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}