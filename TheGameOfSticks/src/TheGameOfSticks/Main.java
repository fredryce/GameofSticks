/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TheGameOfSticks;
import java.util.Scanner;

/**
 *
 * @author xwang2945
 */
public class Main {
    public static void main(String args[])
    {
        
        GameStart game1 = new GameStart();
        game1.stickvalid();
        game1.Display();
        game1.choice();
        game1.aiTurn();
        if (game1.getPlayerChoice() == 1){
            game1.PVP();
        }
        else if(game1.getPlayerChoice()==2){
            game1.PVI();
        }
        else
        {
            game1.AIvAI();
        }
        
        
        
//        while(game1.getTotalSticks() != 0){
//            
//            
//        }
        
    }
   
   
    
}
