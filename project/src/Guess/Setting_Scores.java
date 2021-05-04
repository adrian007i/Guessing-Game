/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guess;
import java.util.ArrayList;
/**
 *
 * @author Adrian John 00061686
 */
public class Setting_Scores implements Subject {
    	       
	    private ArrayList<Observer> observers;
	    private String player1;
	    private String player2;
	    private String player3;

            /**
             * Creates an ArrayList for observers.
             */
	    public Setting_Scores(){
	         
	        observers = new ArrayList<Observer>();
	    }
	     
            /**
             *notify is to display when an update has been made,
             * "pt" is a variable used to restrict the number of prints.
             */
	    public void notifyObserver(boolean pt) {
	         
	        for(Observer observer : observers){
	             
	            observer.update(player1, player2, player3,pt);
	        }
	    }
	     /**
              *create a new observer and add it to the array list.
              */
	     public void register(Observer newObserver) {
	        observers.add(newObserver);
	         
	    }
	     /**
              *change value of player1.
              */
	    public void setPlayer1(String p,boolean pt){
	         
	        this.player1 = p;
	        notifyObserver(pt);
	    }
	 /**
              *change value of player2.
              */
	    public void setPlayer2(String p,boolean pt){
	         
	        this.player2 = p;
	        notifyObserver(pt);
	    }
            /**
              *change value of player3.
              */
            public void setPlayer3(String p,boolean pt){
	         
	        this.player3 = p;
	        notifyObserver(pt);
	    }
	     
	}


