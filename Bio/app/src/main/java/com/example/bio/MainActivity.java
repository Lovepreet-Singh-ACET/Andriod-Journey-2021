package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.data.Bio;
import com.example.bio.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private EditText enterHobbies;
    private TextView hobbies;
    private final Bio bio = new Bio();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        enterHobbies = findViewById(R.id.enter_hobbies);
//        hobbies = findViewById(R.id.hobbies_text);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bio.setName("Lovepreet Singh");
        binding.setBio(bio);

        binding.doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHobbies(v);
            }
        });
    }

    public void addHobbies(View view) {
        bio.setHobbies("Hobbies: " + binding.enterHobbies.getText().toString().trim());

        //        binding.hobbiesText.setText("Hobbies: " + binding.enterHobbies.getText().toString().trim());
        binding.invalidateAll();
        binding.hobbiesText.setVisibility(View.VISIBLE);

//        hobbies.setText("Hobbies: " + enterHobbies.getText().toString().trim());
//        hobbies.setVisibility(View.VISIBLE);

        //hide Keybord
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}