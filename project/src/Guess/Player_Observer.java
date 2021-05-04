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
public class Player_Observer implements Observer {
    
	    protected static String data =""; 
	    private String player1;
	    private String player2;
	    private String player3;
	    protected static int tracker = 0;
	    private int id;
	    private Subject scores;
            
            
	    public  Player_Observer(Subject s ){
	        this.scores=s;
	        scores.register(this);
                
	    }
            /**
              *update all observers, and only prints if pt is true.
              */
	    public void update(String p1,String p2, String p3,boolean pt) {
	         
	        this.player1 = p1;
	        this.player2 = p2;
	        this.player3 = p3;
	         
                //only prints if i wanted it too
                if(pt==true)
	        print();
	         
	    }
	    /**
            *Writes players 1 2 and 3 to the text area on Standings panel.
            */ 
	    public void print(){
                      
                        this.id = ++tracker;  
                      data+="\nUpon Update #"+id+"\n";
                      if(player1!=null) data+=player1+"\n";
                      if(player2!=null) data+=player2+"\n";
                      if(player3!=null) data+=player3+"\n";
                      data+="____________________________\n";
                     
                      
                      Standings.user.setText(data);    
         
	    }

   
	}



