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
 *  Update is called when subject changes	 
 */
public interface Observer {
     public void update(String player1, String player2,String player3,boolean pt);
    
}
