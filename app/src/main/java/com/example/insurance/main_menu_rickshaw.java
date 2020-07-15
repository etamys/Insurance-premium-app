package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_menu_rickshaw extends AppCompatActivity {

    private Button one_year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_rickshaw);

        one_year = findViewById(R.id.one_year);
        one_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_menu_rickshaw.this,auto_ricksaw.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
