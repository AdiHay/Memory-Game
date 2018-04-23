package com.example.adi_h.ex1_adihay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {

    Intent myIntent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bundle = getIntent().getExtras();
        ((TextView) findViewById(R.id.userNameText)).setText(bundle.getString("userName"));
        ((TextView) findViewById(R.id.userAgeText)).setText(String.valueOf(bundle.getInt("userAge")));
    }

    public void onClick(View view) {
        myIntent = new Intent(getBaseContext(), MainActivity3_game.class);
        myIntent.putExtra("level", view.getId());
        myIntent.putExtra("userName",bundle.getString("userName"));
        myIntent.putExtra("userAge",bundle.getInt("userAge"));

        startActivity(myIntent);
    }
}