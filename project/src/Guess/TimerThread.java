/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guess;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Adrian John 00061686
 * 
 * This class is used to run the timer separate from the application.
 */
public class TimerThread implements Runnable {

Game myGame;
Timer myTimer;
TimerTask task;
int seconds = 180;


public TimerThread(Game g) {
    myGame=g;
}
/**
 *Runs the timer. 
 */
public void run(){
   start();
}

/**
 * starts the timer.
 */
    public void t() {
        myTimer = new Timer();
        task = new TimerTask() {
            public void run() {
                seconds--;
                myGame.timer.setText(seconds+"");
                
                if(myGame.gameStop==true || seconds==0){
                    myTimer.cancel();
                    myGame.gameStop();
                    
                     myGame.timer.setText("");
                }
                
            }
        };
    }

    public void start() {
        t();
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }

    public int getSeconds() {
        return seconds;
    }
    
    
    
}
