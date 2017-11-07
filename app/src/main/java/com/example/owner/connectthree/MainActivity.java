package com.example.owner.connectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    // 0 for red][ 1 for yellow
    public int currentPlayer = 0;
    public String board[][]= {{"","",""},{"","",""},{"","",""}};

    public boolean v1 = false, v2 = false, v3 = false, h1 = false, h2 = false, h3 = false, d1 = false, d2 = false;


    //keeps track of moves played
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void dropIn(View view){

        ImageView counter = (ImageView)view;

        String index = counter.getTag().toString();
        int i = Integer.parseInt(index.charAt(0)+"");
        int k = Integer.parseInt(index.charAt(1)+"");



        if(board[i][k] == ""){

            counter.setTranslationY(-1000f);


            if (currentPlayer == 0) {
                counter.setImageResource(R.drawable.red);
                board[i][k] = "X";

                count++;
                currentPlayer = 1;

            } else if (currentPlayer == 1) {
                counter.setImageResource(R.drawable.yellow);
                board[i][k]= "O";

                count++;
                currentPlayer = 0;
            }//end if else if

            counter.animate().translationYBy(1000f).rotation(720).setDuration(1000);
        }//end if


        if (isDiagonalWin()) {

            view.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(d1){
                        ImageView one = (ImageView)findViewById(R.id.one);
                        ImageView two = (ImageView)findViewById(R.id.five);
                        ImageView three = (ImageView)findViewById(R.id.nine);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }else{
                        ImageView one = (ImageView)findViewById(R.id.three);
                        ImageView two = (ImageView)findViewById(R.id.five);
                        ImageView three = (ImageView)findViewById(R.id.seven);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }
                }
            }, 1000);

        }//end if diagonal win


        if (isVerticleWin()) {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(v1){
                        ImageView one = (ImageView)findViewById(R.id.one);
                        ImageView two = (ImageView)findViewById(R.id.four);
                        ImageView three = (ImageView)findViewById(R.id.seven);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }else if(v2){
                        ImageView one = (ImageView)findViewById(R.id.two);
                        ImageView two = (ImageView)findViewById(R.id.five);
                        ImageView three = (ImageView)findViewById(R.id.eight);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }else{
                        ImageView one = (ImageView)findViewById(R.id.three);
                        ImageView two = (ImageView)findViewById(R.id.six);
                        ImageView three = (ImageView)findViewById(R.id.nine);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }
                }
            }, 1000);
        }//end if verticle win


        if (isHorizonalWin()) {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {

                    if(h1){
                        ImageView one = (ImageView)findViewById(R.id.one);
                        ImageView two = (ImageView)findViewById(R.id.two);
                        ImageView three = (ImageView)findViewById(R.id.three);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }else if(h2){
                        ImageView one = (ImageView)findViewById(R.id.four);
                        ImageView two = (ImageView)findViewById(R.id.five);
                        ImageView three = (ImageView)findViewById(R.id.six);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }else{
                        ImageView one = (ImageView)findViewById(R.id.seven);
                        ImageView two = (ImageView)findViewById(R.id.eight);
                        ImageView three = (ImageView)findViewById(R.id.nine);
                        one.animate().rotationX(3600).setDuration(3000);
                        two.animate().rotationX(3600).setDuration(3000);
                        three.animate().rotationX(3600).setDuration(3000);
                    }
                }
            }, 1000);
        }//end if horizontal win


        if (isTie()) {
            view.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //code if tie
                }
            }, 1000);
        }






    }//end dropIn


    public String isWinningMove(){
        //top row scenarios
        if(board[0][0] != "" && board[0][0] == board[0][1] && board[0][2] == "") {
            return "02"; }
        if(board[0][ 2] != "" && board[0][ 0] == board[0][ 2] && board[0][ 1] == "") {
            return "01"; }
        if (board[0][ 1] != "" && board[0][ 1] == board[0][ 2] && board[0][ 0] == "") {
            return "00"; }
        //middle row scenarios
        if (board[1][ 0] != "" && board[1][ 0] == board[1][ 1] && board[1][ 2] == "") {
            return "12"; }
        if (board[1][ 2] != "" && board[1][ 0] == board[1][ 2] && board[1][ 1] == "") {
            return "11"; }
        if (board[1][ 1] != "" && board[1][ 1] == board[1][ 2] && board[1][ 0] == "") {
            return "10"; }
        //bottom row scenarios
        if (board[2][ 0] != "" && board[2][ 0] == board[2][ 1] && board[2][ 2] == "") {
            return "22"; }
        if (board[2][ 2] != "" && board[2][ 0] == board[2][ 2] && board[2][ 1] == "") {
            return "21"; }
        if (board[2][ 1] != "" && board[2][ 1] == board[2][ 2] && board[2][ 0] == "") {
            return "20"; }

        //col1 scenarios
        if (board[0][ 0] != "" && board[0][ 0] == board[1][ 0] && board[2][ 0] == "") {
            return "20"; }
        if (board[2][ 0] != "" && board[0][ 0] == board[2][ 0] && board[1][ 0] == "") {
            return "10"; }
        if (board[1][ 0] != "" && board[1][ 0] == board[2][ 0] && board[0][ 0] == "") {
            return "00"; }
        //col2 scenarios
        if (board[0][ 1] != "" && board[0][ 1] == board[1][ 1] && board[2][ 1] == "") {
            return "21"; }
        if (board[2][ 1] != "" && board[0][ 1] == board[2][ 1] && board[1][ 1] == "") {
            return "11"; }
        if (board[1][ 1] != "" && board[1][ 1] == board[2][ 1] && board[0][ 1] == "") {
            return "01"; }
        //col3 scenarios
        if (board[0][ 2] != "" && board[0][ 2] == board[1][ 2] && board[2][ 2] == "") {
            return "22"; }
        if (board[2][ 2] != "" && board[0][ 2] == board[2][ 2] && board[1][ 2] == "") {
            return "12"; }
        if (board[1][ 2] != "" && board[1][ 2] == board[2][ 2] && board[0][ 2] == "") {
            return "02"; }

        //diag1 scenarios
        if (board[0][ 0] != "" && board[0][ 0] == board[1][ 1] && board[2][ 2] == "") {
            return "22"; }
        if (board[1][ 1] != "" && board[0][ 0] == board[2][ 2] && board[1][ 1] == "") {
            return "11"; }
        if (board[2][ 2] != "" && board[2][ 2] == board[1][ 1] && board[0][ 0] == "") {
            return "00"; }

        //diag2 scenarios
        if (board[0][ 2] != "" && board[0][ 2] == board[1][ 1] && board[2][ 0] == "") {
            return "20"; }
        if (board[2][ 0] != "" && board[0][ 2] == board[2][ 0] && board[1][ 1] == "") {
            return "11"; }
        if (board[1][ 1] != "" && board[2][ 0] == board[1][ 1] && board[0][ 2] == "") {
            return "02"; }

        return "";
    }


    public boolean isDiagonalWin()
    {

        if (board[0][0] == "X" && board[1][ 1] == "X" && board[2][ 2] == "X" || board[0][ 0] == "O" && board[1][ 2] == "O" && board[2][ 2] == "O")
        {
            d1 = true;
            return true;
        }

        if (board[0][ 2] == "X" && board[1][ 1] == "X" && board[2][ 0] == "X" || board[0][ 2] == "O" && board[1][ 1] == "O" && board[2][ 0] == "O")
        {
            d2 = true;
            return true;
        }
        return false;
    }

    /// <summary>
    /// checks scenarios][ and determines what col won][ and what player won
    /// </summary>
    /// <returns></returns>
    public boolean isVerticleWin()
    {
        if (board[0][ 0] == "X" && board[1][ 0] == "X" && board[2][ 0] == "X" || board[0][ 0] == "O" && board[1][ 0] == "O" && board[2][ 0] == "O")
        {
            v1 = true;
            return true;
        }

        if (board[0][ 1] == "X" && board[1][ 1] == "X" && board[2][ 1] == "X" || board[0][ 1] == "O" && board[1][ 1] == "O" && board[2][ 1] == "O")
        {
            v2 = true;
            return true;
        }

        if (board[0][ 2] == "X" && board[1][ 2] == "X" && board[2][ 2]=="X" || board[0][ 2] == "O" && board[1][ 2] == "O" && board[2][ 2] == "O")
        {
            v3=true;
            return true;
        }

        return false;
    }

    /// <summary>
    /// checks scenarios][ and determines what row won][ and what player won
    /// </summary>
    /// <returns></returns>
    public boolean isHorizonalWin()
    {
        if (board[0][ 0] == "X" && board[0][ 1] == "X" && board[0][ 2] =="X" || board[0][ 0] == "O" && board[0][ 1] == "O" && board[0][ 2] == "O")
        {
            h1 = true;
            return true;
        }

        if (board[1][ 0] == "X" && board[1][ 1]=="X" && board[1][ 2] =="X" || board[1][ 0] == "O" && board[1][ 1] == "O" && board[1][ 2] == "O")
        {
            h2 = true;
            return true;
        }

        if (board[2][ 0] == "X" && board[2][ 1] == "X" && board[2][ 2]== "X" || board[2][ 0] == "O" && board[2][ 1] == "O" && board[2][ 2] == "O")
        {
            h3 = true;
            return true;
        }

        return false;
    }

    public boolean isTie()
    {
        if (count == 9 && isDiagonalWin() == false && isVerticleWin() == false && isHorizonalWin() == false)
            return true;
        else
            return false;
    }




}//end class
