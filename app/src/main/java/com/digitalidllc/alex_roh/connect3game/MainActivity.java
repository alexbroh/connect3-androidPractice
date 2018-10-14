package com.digitalidllc.alex_roh.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {

    enum Player {ONE, TWO;}

    //one:yellow; two:red
    Player activePlayer = Player.ONE;

    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1500);

        if(activePlayer==Player.ONE) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer=Player.TWO;
        } else{
            counter.setImageResource(R.drawable.red);
            activePlayer=Player.ONE;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
