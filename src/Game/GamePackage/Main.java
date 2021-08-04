package GamePackage;


public class Main {
    public static void main(String args[])
    {
        
        Game game1 = new Game();
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