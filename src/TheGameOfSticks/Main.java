/* Xin Wang
 * Pex 1 GameOfSticks
 * Due Date: 09/09/2016
 * Programming 2 
 * Deen Bushey
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
        game1.stickvalid();             //Ask user for Stick number to start.
        game1.Display();                //Displays the 3 options and ask the user to choose.
        if (game1.getPlayerChoice() == 1){    //based on choice make decision
            game1.PVP();
        }
        else if(game1.getPlayerChoice()==2){
            game1.PVI();
        }
        else
        {
            game1.AIvAI();
        }
        
       
        
    }
   
   
    
}
