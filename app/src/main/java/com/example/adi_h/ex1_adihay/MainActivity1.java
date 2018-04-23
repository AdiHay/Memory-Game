package com.example.adi_h.ex1_adihay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        Button button = findViewById(R.id.startButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = ((EditText)findViewById(R.id.nameText)).getText().toString();
                int userAge = Integer.valueOf(((EditText)findViewById(R.id.ageText)).getText().toString());
                Intent myIntent = new Intent(getBaseContext(), MainActivity2.class);
                myIntent.putExtra("userName",userName);
                myIntent.putExtra("userAge",userAge);
                startActivity(myIntent);
            }
        });
    }
}
