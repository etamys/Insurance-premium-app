package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class main_menu extends AppCompatActivity {
    private Button one_year_btn;
    private Button main_menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        one_year_btn = findViewById(R.id.one_year);
        one_year_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });

        main_menu = findViewById(R.id.main_menu);
        main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Updateui();
            }
        });
    }

    private void Updateui() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void updateUI() {
        Intent intent = new Intent(main_menu.this,one_year.class);
        startActivity(intent);
        finish();
    }

}
