package com.example.adi_h.ex1_adihay;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3_game extends AppCompatActivity {

    int clickCount = 0, scoreCount = 0, maxScore, timer;
    final int easyMaxScore = 2;
    final int normalMaxScore = 8;
    final int hardMaxScore = 12;
    ImageButton first;
    Bundle bundle;
    CountDownTimer cdt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getIntent().getExtras();
        int level = bundle.getInt("level");
        switch (level) {
            case R.id.buttonEasy: {
                setContentView(R.layout.activity_main3_easy);
                level = 1;
                break;
            }
            case R.id.buttonNormal: {
                setContentView(R.layout.activity_main3_normal);
                level = 2;
                break;
            }
            case R.id.buttonHard: {
                setContentView(R.layout.activity_main3_hard);
                level = 3;
                break;
            }
        }
        ((TextView) findViewById(R.id.userNameText)).setText(bundle.getString("userName"));

        setMaxScore(level);
        setTimer(level);

        cdt = new CountDownTimer(timer * 1000, 1000) {
            TextView timerText = findViewById(R.id.timerText);

            public void onTick(long remainTime) {
                timerText.setText("Remain time: " + remainTime / 1000);
            }

            public void onFinish() {
                Toast.makeText(getBaseContext(), "Time is up! Game Over!",
                        Toast.LENGTH_SHORT).show();
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long l) {
                    }

                    @Override
                    public void onFinish() {
                        finish();
                    }
                }.start();
            }
        }.start();
    }

    public void gameLogic(final View view) {
        if (((ImageButton) findViewById(view.getId())).getTag() != "correct") {
            if (clickCount == 0) {
                pictureChange(maxScore, view);
                first = (ImageButton) findViewById(view.getId());
                clickCount++;
            } else if (clickCount == 1 && first != findViewById(view.getId())) {
                pictureChange(maxScore, view);
                if (first.getTag() == ((ImageButton) findViewById(view.getId())).getTag()) {
                    first.setTag("correct");
                    ((ImageButton) findViewById(view.getId())).setTag("correct");
                    scoreCount++;
                    if (scoreCount == maxScore) {
                        Toast.makeText(getBaseContext(), "Well done! you won!",
                                Toast.LENGTH_SHORT).show();
                        new CountDownTimer(1000, 1000) {
                            @Override
                            public void onTick(long l) {
                            }
                            @Override
                            public void onFinish() {
                                finish();
                            }
                        }.start();
                    }
                } else {
                    new CountDownTimer(1000, 1000) {
                        @Override
                        public void onTick(long l) {
                        }
                        @Override
                        public void onFinish() {
                            first.setImageResource(R.drawable.star);
                            ((ImageButton) findViewById(view.getId())).setImageResource(R.drawable.star);
                        }
                    }.start();
                }
                clickCount = 0;
            }
        }
    }

    public void setMaxScore(int level) {
        switch (level) {
            case 1: {
                maxScore = easyMaxScore;
                break;
            }
            case 2: {
                maxScore = normalMaxScore;
                break;
            }
            case 3: {
                maxScore = hardMaxScore;
                break;
            }
        }
    }

    public void setTimer(int level) {
        switch (level) {
            case 1: {
                timer = 30;
                break;
            }
            case 2: {
                timer = 45;
                break;
            }
            case 3: {
                timer = 60;
                break;
            }
        }
    }

    public void pictureChange(int maxScore, View view) {
        switch (maxScore) {
            case easyMaxScore: {
                changePicturesEasy(view);
                break;
            }
            case normalMaxScore: {
                changePicturesNormal(view);
                break;
            }
            case hardMaxScore: {
                changePictureHard(view);
                break;
            }
        }
    }

    public void changePicturesEasy(View view) {
        switch (view.getId()) {
            case R.id.imageButton1_1: {
                ((ImageButton) findViewById(R.id.imageButton1_1)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton1_2: {
                ((ImageButton) findViewById(R.id.imageButton1_2)).setImageResource(R.drawable.cat);
                break;
            }
            case R.id.imageButton1_3: {
                ((ImageButton) findViewById(R.id.imageButton1_3)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton1_4: {
                ((ImageButton) findViewById(R.id.imageButton1_4)).setImageResource(R.drawable.cat);
                break;
            }
        }
    }

    public void changePicturesNormal(View view) {
        switch (view.getId()) {
            case R.id.imageButton2_1: {
                ((ImageButton) findViewById(R.id.imageButton2_1)).setImageResource(R.drawable.koala);
                break;
            }
            case R.id.imageButton2_2: {
                ((ImageButton) findViewById(R.id.imageButton2_2)).setImageResource(R.drawable.elephant);
                break;
            }
            case R.id.imageButton2_3: {
                ((ImageButton) findViewById(R.id.imageButton2_3)).setImageResource(R.drawable.monkey);
                break;
            }
            case R.id.imageButton2_4: {
                ((ImageButton) findViewById(R.id.imageButton2_4)).setImageResource(R.drawable.koala);
                break;
            }
            case R.id.imageButton2_5: {
                ((ImageButton) findViewById(R.id.imageButton2_5)).setImageResource(R.drawable.fish);
                break;
            }
            case R.id.imageButton2_6: {
                ((ImageButton) findViewById(R.id.imageButton2_6)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton2_7: {
                ((ImageButton) findViewById(R.id.imageButton2_7)).setImageResource(R.drawable.rabbit);
                break;
            }
            case R.id.imageButton2_8: {
                ((ImageButton) findViewById(R.id.imageButton2_8)).setImageResource(R.drawable.elephant);
                break;
            }
            case R.id.imageButton2_9: {
                ((ImageButton) findViewById(R.id.imageButton2_9)).setImageResource(R.drawable.cat);
                break;
            }
            case R.id.imageButton2_10: {
                ((ImageButton) findViewById(R.id.imageButton2_10)).setImageResource(R.drawable.monkey);
                break;
            }
            case R.id.imageButton2_11: {
                ((ImageButton) findViewById(R.id.imageButton2_11)).setImageResource(R.drawable.whale);
                break;
            }
            case R.id.imageButton2_12: {
                ((ImageButton) findViewById(R.id.imageButton2_12)).setImageResource(R.drawable.rabbit);
                break;
            }
            case R.id.imageButton2_13: {
                ((ImageButton) findViewById(R.id.imageButton2_13)).setImageResource(R.drawable.fish);
                break;
            }
            case R.id.imageButton2_14: {
                ((ImageButton) findViewById(R.id.imageButton2_14)).setImageResource(R.drawable.whale);
                break;
            }
            case R.id.imageButton2_15: {
                ((ImageButton) findViewById(R.id.imageButton2_15)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton2_16: {
                ((ImageButton) findViewById(R.id.imageButton2_16)).setImageResource(R.drawable.cat);
                break;
            }
        }
    }

    public void changePictureHard(View view) {
        switch (view.getId()) {
            case R.id.imageButton3_1: {
                ((ImageButton) findViewById(R.id.imageButton3_1)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton3_2: {
                ((ImageButton) findViewById(R.id.imageButton3_2)).setImageResource(R.drawable.monkey);
                break;
            }
            case R.id.imageButton3_3: {
                ((ImageButton) findViewById(R.id.imageButton3_3)).setImageResource(R.drawable.koala);
                break;
            }
            case R.id.imageButton3_4: {
                ((ImageButton) findViewById(R.id.imageButton3_4)).setImageResource(R.drawable.hedgehog);
                break;
            }
            case R.id.imageButton3_5: {
                ((ImageButton) findViewById(R.id.imageButton3_5)).setImageResource(R.drawable.snake);
                break;
            }
            case R.id.imageButton3_6: {
                ((ImageButton) findViewById(R.id.imageButton3_6)).setImageResource(R.drawable.bird);
                break;
            }
            case R.id.imageButton3_7: {
                ((ImageButton) findViewById(R.id.imageButton3_7)).setImageResource(R.drawable.tiger);
                break;
            }
            case R.id.imageButton3_8: {
                ((ImageButton) findViewById(R.id.imageButton3_8)).setImageResource(R.drawable.cat);
                break;
            }
            case R.id.imageButton3_9: {
                ((ImageButton) findViewById(R.id.imageButton3_9)).setImageResource(R.drawable.tiger);
                break;
            }
            case R.id.imageButton3_10: {
                ((ImageButton) findViewById(R.id.imageButton3_10)).setImageResource(R.drawable.bird);
                break;
            }
            case R.id.imageButton3_11: {
                ((ImageButton) findViewById(R.id.imageButton3_11)).setImageResource(R.drawable.snake);
                break;
            }
            case R.id.imageButton3_12: {
                ((ImageButton) findViewById(R.id.imageButton3_12)).setImageResource(R.drawable.fish);
                break;
            }
            case R.id.imageButton3_14: {
                ((ImageButton) findViewById(R.id.imageButton3_14)).setImageResource(R.drawable.hedgehog);
                break;
            }
            case R.id.imageButton3_15: {
                ((ImageButton) findViewById(R.id.imageButton3_15)).setImageResource(R.drawable.whale);
                break;
            }
            case R.id.imageButton3_16: {
                ((ImageButton) findViewById(R.id.imageButton3_16)).setImageResource(R.drawable.cat);
                break;
            }
            case R.id.imageButton3_17: {
                ((ImageButton) findViewById(R.id.imageButton3_17)).setImageResource(R.drawable.whale);
                break;
            }
            case R.id.imageButton3_18: {
                ((ImageButton) findViewById(R.id.imageButton3_18)).setImageResource(R.drawable.dog);
                break;
            }
            case R.id.imageButton3_19: {
                ((ImageButton) findViewById(R.id.imageButton3_19)).setImageResource(R.drawable.rabbit);
                break;
            }
            case R.id.imageButton3_20: {
                ((ImageButton) findViewById(R.id.imageButton3_20)).setImageResource(R.drawable.elephant);
                break;
            }
            case R.id.imageButton3_21: {
                ((ImageButton) findViewById(R.id.imageButton3_21)).setImageResource(R.drawable.elephant);
                break;
            }
            case R.id.imageButton3_22: {
                ((ImageButton) findViewById(R.id.imageButton3_22)).setImageResource(R.drawable.koala);
                break;
            }
            case R.id.imageButton3_23: {
                ((ImageButton) findViewById(R.id.imageButton3_23)).setImageResource(R.drawable.fish);
                break;
            }
            case R.id.imageButton3_24: {
                ((ImageButton) findViewById(R.id.imageButton3_24)).setImageResource(R.drawable.monkey);
                break;
            }
            case R.id.imageButton3_25: {
                ((ImageButton) findViewById(R.id.imageButton3_25)).setImageResource(R.drawable.rabbit);
                break;
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cdt.cancel();

    }
}