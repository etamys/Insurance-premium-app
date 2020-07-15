package com.example.insurance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button two_wheeler;
    private Button private_car;
    private Button rickshaw;
    private Button taxi;
    private Button goods;
    private Button passenger;
    private Button misc;
    private Button sfsp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        two_wheeler = findViewById(R.id.two_wheeler);
        two_wheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });

        private_car = findViewById(R.id.private_car);
        private_car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,mai_menu_prcar.class);
                startActivity(intent);

            }
        });

        rickshaw = findViewById(R.id.auto_ricksaw);
        rickshaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,main_menu_rickshaw.class);
                startActivity(intent);
            }
        });

        taxi  = findViewById(R.id.taxi_up);
        taxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,one_year_taxi.class);
                startActivity(intent);
            }
        });

        goods = findViewById(R.id.goods_carry);
        goods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,one_year_goods.class);
                startActivity(intent);
            }
        });

        passenger = findViewById(R.id.passenger);
        passenger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,pasenger.class);
                startActivity(intent);
            }
        });

        misc = findViewById(R.id.misc);
        misc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,misc.class);
                startActivity(intent);
            }
        });

        sfsp = findViewById(R.id.sfsp);
        sfsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,sfsp.class);
                startActivity(intent);
            }
        });
    }

    private void updateUI() {
        Intent intent = new Intent(MainActivity.this,main_menu.class);
        startActivity(intent);
        finish();
    }
}
