package com.example.makeitrain;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.text.NumberFormat;
import android.icu.util.ULocale;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button makeItRain;
    private Button showInfo;
    private TextView moneyValue;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeItRain = findViewById(R.id.MakeItRain);
        showInfo = findViewById(R.id.ShowInfo);
        moneyValue = findViewById(R.id.MoneyValue);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void makeItRain(View view) {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        counter += 1000;
        moneyValue.setText(String.valueOf(numberFormat.format(counter)));
        switch (counter) {
            case 20000:
                moneyValue.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.purple_200));
                break;
            case 30000:
                moneyValue.setTextColor(Color.MAGENTA);
            case 40000:
                moneyValue.setTextColor(Color.LTGRAY);
        }
    }

    public void showInfo(View view) {
//        Toast.makeText(MainActivity.this, R.string.app_info, Toast.LENGTH_LONG).show();
        Snackbar.make(moneyValue, R.string.app_info, Snackbar.LENGTH_LONG)
                .setAction("More", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("more invoked");
                    }
                })
                .show();
    }
}