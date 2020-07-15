package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mai_menu_prcar extends AppCompatActivity {
    private TextView one_yer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mai_menu_prcar);

        one_yer = findViewById(R.id.one_year);
        one_yer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mai_menu_prcar.this,one_yer_prcar.class);
                startActivity(intent);
            }
        });
    }
}
