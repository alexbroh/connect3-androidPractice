package com.digitalidllc.alex_roh.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    //one:yellow; two:red
     enum Player {
        ONE(0), TWO(1);
        private final int m_tag;
        Player(int tag){
            m_tag=tag;
        }

        int getTag() {return m_tag;}
    }

    enum State {
         EMPTY(2), ONE(0), TWO(1);
        private final int m_tag;
        State(int tag){
           m_tag=tag;
        }
        int getTag() {return m_tag;}
     }

    Player activePlayer = Player.ONE;

    State[] gameState = {
            State.EMPTY,State.EMPTY,State.EMPTY,
            State.EMPTY,State.EMPTY,State.EMPTY,
            State.EMPTY,State.EMPTY,State.EMPTY
    };

    int[][] winningPositions={
            {0,1,2} , {3,4,5} , {6,7,8}, //horizontal
            {0,3,6} , {1,4,7} , {2,5,8}, //vertical
            {0,4,8} , {2,4,6}            //diagonal
    };

    public void dropIn(View view){
        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(activePlayer==Player.ONE)
        gameState[tappedCounter]=State.ONE;
        else gameState[tappedCounter]=State.TWO;


        counter.setTranslationY(-1500);

        if(activePlayer==Player.ONE) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer=Player.TWO;
        } else{
            counter.setImageResource(R.drawable.red);
            activePlayer=Player.ONE;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

        //check for winner
        for(int[] winningPosition : winningPositions){
            boolean playerWon = gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]]==gameState[winningPosition[2]] && gameState[winningPosition[0]].getTag()!=2;
            if(playerWon){
                String winner="";
                if(activePlayer==Player.ONE) winner="RED"; else winner="YELLOW"; //already switched players
                Toast.makeText(this, winner + " has won!",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
