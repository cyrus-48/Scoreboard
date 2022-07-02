package com.example.scoreboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView  shareText,playerA1 , foulA1, playerA2 ,foulA2 ,playerA3,foulA3,playerA4,foulA4,playerA5,foulA5,playerB1,foulB1,playerB2,foulB2,playerB3,foulB3,playerB4,foulB4,playerB5,foulB5, teamAScores , teamBscores;
    LinearLayout player1,btns;
    Button pointA1,pointA2,pointA3,pointB1,pointB2,pointB3,endGame, whatsapp,gmail,facebook;
    int  scoreA = 0, scoreB =0 , foulsA1 = 0 ,foulsA2,foulsA3,foulsA4,foulsA5,foulsB1,foulsB2,foulsB3,foulsB4,foulsB5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shareText = findViewById(R.id.shareText);
          btns = (LinearLayout) findViewById(R.id.btns);
        endGame = findViewById(R.id.endGame);
        whatsapp = findViewById(R.id.whatsapp);
        facebook = findViewById(R.id.facebook);
        gmail = (Button) findViewById(R.id.gmail);
        setContentView(R.layout.activity_main);
        playerA1 = findViewById(R.id.playerA1);
        foulA1 = findViewById(R.id.foulA1);
        player1 = findViewById(R.id.player1);
        playerA2 = findViewById(R.id.playerA2);
        foulA2 = findViewById(R.id.foulA2);
        playerA3 = findViewById(R.id.playerA3);
        foulA3 = findViewById(R.id.foulA3);
        playerA4 = findViewById(R.id.playerA4);
        foulA4 = findViewById(R.id.foulA4);
        playerA5 = findViewById(R.id.playerA5);
        foulA5 = findViewById(R.id.foulA5);
        playerB1 = findViewById(R.id.playerB1);
        foulB1 = findViewById(R.id.foulB1);
        playerB2 = findViewById(R.id.playerB2);
        foulB2 = findViewById(R.id.foulB2);
        playerB3 = findViewById(R.id.playerB3);
        foulB3 = findViewById(R.id.foulB3);
        playerB4 = findViewById(R.id.playerB4);
        foulB4 = findViewById(R.id.foulB4);
        playerB5 = findViewById(R.id.playerB5);
        foulB5 = findViewById(R.id.foulB5);
        teamAScores = findViewById(R.id.teamAScores);
        teamBscores = findViewById(R.id.teamBScores);
        pointA1 = findViewById(R.id.pointA1);
        pointA2 = findViewById(R.id.pointA2);
        pointA3 = findViewById(R.id.pointA3);
        pointB1 = findViewById(R.id.pointB1);
        pointB2= findViewById(R.id.pointB2);
        pointB3 = findViewById(R.id.pointB3);


        // event listener to button '+1' to add a point to team B score
        pointB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = Integer.parseInt((String)teamBscores.getText());
                scoreB+=onePoint();
                teamBscores.setText(""+scoreB);
            }
        });
        // event listener to button '+2' to add a point to team B score
        pointB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = Integer.parseInt((String)teamBscores.getText());
                scoreB+=twoPoints();
                teamBscores.setText(""+scoreB);
            }
        });
        // event listener to button '+3' to add a point to team B score
        pointB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreB = Integer.parseInt((String)teamBscores.getText());
                scoreB+=threePoints();
                teamBscores.setText(""+scoreB);
            }
        });
        // event listener to button '+1' to add a point to team A score
        pointA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = Integer.parseInt((String)teamAScores.getText());
                scoreA+=onePoint();
                teamAScores.setText(""+scoreA);
            }
        });
        // event listener to button '+2' to add a point to team A score
        pointA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = Integer.parseInt((String)teamAScores.getText());
                scoreA+=twoPoints();
                teamAScores.setText(""+scoreA);
            }
        });
        // event listener to button '+3' to add a point to team A score
        pointA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreA = Integer.parseInt((String)teamAScores.getText());
                scoreA+=threePoints();
                teamAScores.setText(""+scoreA);
            }
        });

        //Event listeners for fouls fo playerA1
        playerA1.setOnClickListener(view -> playerA1Fouls());
        //Event listeners for fouls fo player2 of team A
        playerA2.setOnClickListener(view -> playerA2Fouls());
        //Event listeners for fouls fo player3 of team A
        playerA3.setOnClickListener(view ->playerA3Fouls());
        //Event listeners for fouls fo player4 of team A
        playerA4.setOnClickListener( view -> playerA4Fouls());
        //Event listeners for fouls fo player of team A
        playerA5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playerA5Fouls();
            }
        });
        playerB1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 playerB1Fouls();
            }
        });
        playerB2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               playerB2Fouls();
            }
        });
        playerB3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               playerB3Fouls();
            }
        });
        playerB4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              playerB4Fouls();
            }
        });
        playerB5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              playerB5Fouls();
            }
        });
        //endGame.setOnClickListener(view -> onEndGame());



    }


    public void emailling(String message){
        String[] emails = {"cyrusmwendwa370@gmail.com"};
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.setType("'/'");
        intent.putExtra(intent.EXTRA_EMAIL, emails);
        intent.putExtra(intent.EXTRA_SUBJECT, "Todays basket ball results");
        intent.putExtra(intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }

    }
    public  void onEndGame(View view){


    }
    // check number of fouls if greate than 5
    public boolean is_suspension(){
        int numberOfFouls = Integer.parseInt((String) foulA1.getText());
        if (numberOfFouls < 5){return false;}
        else{return true;}
    }
    // player a1 fouls
    public void playerA1Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulA1.getText());
        if (numberOfFouls < 5){
            foulsA1++;
            foulA1.setText(""+foulsA1);
        }else {
            playerA1.setVisibility(View.GONE);
            foulA1.setText("1. suspended");
        }
    }
    // player a2 fouls
    public void playerA2Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulA2.getText());
        if (numberOfFouls < 5){
            foulsA2++;
            foulA2.setText(""+foulsA2);
        }else {
            playerA2.setVisibility(View.GONE);
            foulA2.setText("1. suspended");
        }
    }
    // player a3 fouls
    public void playerA3Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulA3.getText());
        if (numberOfFouls < 5){
            foulsA3++;
            foulA3.setText(""+foulsA3);
        }else {
            playerA3.setVisibility(View.GONE);
            foulA3.setText("1. suspended");
        }
    }
    // player a4 fouls
    public void playerA4Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulA4.getText());
        if (numberOfFouls < 5){
            foulsA4++;
            foulA4.setText(""+foulsA4);
        }else {
            playerA4.setVisibility(View.GONE);
            foulA4.setText("1. suspended");
        }
    }
    // player a5 fouls
    public void playerA5Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulA5.getText());
        if (numberOfFouls < 5){
            foulsA5++;
            foulA5.setText(""+foulsA5);
        }else {
            playerA5.setVisibility(View.GONE);
            foulA5.setText("1. suspended");
        }
    }
    // player b1 fouls
    public void playerB1Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulB1.getText());
        if (numberOfFouls < 5){
            foulsB1++;
            foulB1.setText(""+foulsB1);
        }else {
            playerB1.setVisibility(View.GONE);
            foulB1.setText("1. suspended");
        }
    }
    // player b2 fouls
    public void playerB2Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulB2.getText());
        if (numberOfFouls < 5){
            foulsB2++;
            foulB2.setText(""+foulsB2);
        }else {
            playerB2.setVisibility(View.GONE);
            foulB2.setText("1. suspended");
        }
    }
    // player b1 fouls
    public void playerB3Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulB3.getText());
        if (numberOfFouls < 5){
            foulsB3++;
            foulB3.setText(""+foulsB3);
        }else {
            playerB3.setVisibility(View.GONE);
            foulB3.setText("1. suspended");
        }
    }
    // player b1 fouls
    public void playerB4Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulB4.getText());
        if (numberOfFouls < 5){
            foulsB4++;
            foulB4.setText(""+foulsB4);
        }else {
            playerB4.setVisibility(View.GONE);
            foulB4.setText("1. suspended");
        }
    }
    // player b1 fouls
    public void playerB5Fouls(){
        int numberOfFouls = Integer.parseInt((String) foulB5.getText());
        if (numberOfFouls < 5){
            foulsB5++;
            foulB5.setText(""+foulsB5);
        }else {
            playerB5.setVisibility(View.GONE);
            foulB5.setText("1. suspended");
        }
    }
    // method to return 3 point
    public int threePoints(){return 3;}
    // method to return 2 points
    public  int twoPoints(){return 2;}
    // method to return 1 point
    public  int onePoint(){return 1;}
// event liste for gmail button
    public void gmailBtn(View view) {
        String message = "Game results";
        emailling(message);
    }
}