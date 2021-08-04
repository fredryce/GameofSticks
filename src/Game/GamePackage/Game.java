package GamePackage;




import java.security.SecureRandom;
//import java.util.InputMismatchException;
import javax.swing.JOptionPane;

/**
 *
 * @author xwang2945
 */
public class Game {

   
    private int totalSticks;
    private int Winner;
    private int playerChoice;

    private int arrayCounter;
    SecureRandom SR = new SecureRandom();
    

    public Game() {
        playerChoice = 1;
        totalSticks = 20;
        Winner = 0;
        arrayCounter = 0;

    }

    public Game(int totalSticks, int Winner, int playerChoice, int arrayCounter) {
        this.totalSticks = totalSticks;
        this.Winner = Winner;
        this.playerChoice = playerChoice;
        this.arrayCounter = arrayCounter;
    }
    

   

    public void stickvalid() {
        String tempTotalSticks = JOptionPane.showInputDialog(null, "Whats the Total Number of Sticks to start From? ", "Total Sticks? ", JOptionPane.INFORMATION_MESSAGE);
        while (true) {
            try {
                int Sticks = Integer.parseInt(tempTotalSticks);

                while (Sticks <= 1) {
                    tempTotalSticks = JOptionPane.showInputDialog(null, "Whats the Total Number of Sticks to start From? ", "Total Sticks? ", JOptionPane.INFORMATION_MESSAGE);
                    Sticks = Integer.parseInt(tempTotalSticks);

                }

                setTotalSticks(Sticks);
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Did you read the instructions, please enter in valid integer", "Idiot box", JOptionPane.OK_OPTION);
                tempTotalSticks = JOptionPane.showInputDialog(null, "Whats the Total Number of Sticks to start From? ", "Total Sticks? ", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    public void Display() {
        int choice = 0;
        String tempChoice = JOptionPane.showInputDialog(null, "Press 1 for Player vs. player\nPress 2 for Player Vs. AI\nPress 3 for AI Training AI\n", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        while(true){
        try{
            choice = Integer.parseInt(tempChoice);
        
            while (choice != 1 && choice != 2 && choice != 3) {
                tempChoice = JOptionPane.showInputDialog(null, "Press 1 for Player vs. player\nPress 2 for Player Vs. AI\nPress 3 for AI Training AI\n", "ERROR INPUT!!! Value between 1 - 3", JOptionPane.INFORMATION_MESSAGE);
                choice = Integer.parseInt(tempChoice);

            }
            setPlayerChoice(choice);
            break;
        }
        catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Did you read the instructions, please enter in valid integer", "Idiot box", JOptionPane.OK_OPTION);
            tempChoice = JOptionPane.showInputDialog(null, "Press 1 for Player vs. player\nPress 2 for Player Vs. AI\nPress 3 for AI Training AI\n", "Main Menu", JOptionPane.INFORMATION_MESSAGE);
        }
        }
        
        
    }

    public int getPlayerChoice() {
        return playerChoice;
    }

    public int getTotalSticks() {
        return totalSticks;

    }

    public void setTotalSticks(int totalSticks) {
        this.totalSticks = totalSticks;
    }

    public void setPlayerChoice(int playerChoice) {
        this.playerChoice = playerChoice;
    }

    public void PVP() { 
        
        String name, player1, player2;
        JOptionPane.showMessageDialog(null, "You have chose to PVP the battle will begin NOW!", "Player Vs. Player", JOptionPane.INFORMATION_MESSAGE );
        Human human1 = new Human();
        Human human2 = new Human();
        name = JOptionPane.showInputDialog(null, "Name of the First Player", "Player 1", JOptionPane.INFORMATION_MESSAGE );
        
        human1.setName(name);
        name = JOptionPane.showInputDialog(null, "Name of the Second Player", "Player 2", JOptionPane.INFORMATION_MESSAGE );
        human2.setName(name);
        int randomNumber = random(0, 100);

        if (randomNumber >= 50) {
            player1 = human1.getName();
            player2 = human2.getName();
            human1.setName(player2);
            human2.setName(player1);
            JOptionPane.showMessageDialog(null, "PLAYER 2 Have been Chosen to go first", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );

        } else {
            JOptionPane.showMessageDialog(null, "PLAYER 1 Have been Chosen to go first", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );
        }
        while (getTotalSticks() > 0) {
            humanPlayer(human1);
            if (winCondition()) {
                JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining " + human2.getName() + " is the Winner!!", "Game OVER!!!", JOptionPane.INFORMATION_MESSAGE );
                
                break;
            }
            //JOptionPane.showMessageDialog(null, "There are " + totalSticks + " Left", "", JOptionPane.INFORMATION_MESSAGE );
            
            humanPlayer(human2);
            if (winCondition()) {
                JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining " + human1.getName() + " is the Winner!!", "Game OVER!!!", JOptionPane.INFORMATION_MESSAGE );
                break;
            }
            //JOptionPane.showMessageDialog(null, "There are " + totalSticks + " Left", "", JOptionPane.INFORMATION_MESSAGE );

        }

    }

    public void PVI() { 
        JOptionPane.showMessageDialog(null, "You've decided to challenge the AI, Good luck", "Player Vs. Bot", JOptionPane.INFORMATION_MESSAGE );
        
        AI aiBot1 = new AI();
        Human human1 = new Human();
        String name = JOptionPane.showInputDialog(null, "Name of the Human player? ", "Player Name", JOptionPane.INFORMATION_MESSAGE );
        human1.setName(name);
        JOptionPane.showMessageDialog(null, "The Name of Your Oppoent is: Chicken Ramen Noodle Soup", "Bot Name", JOptionPane.INFORMATION_MESSAGE );
        aiBot1.setAiName("Chicken Ramen Noodle Soup");
        aiBot1.setArray(totalSticks);
        int startTotal = totalSticks;
        aiBot1.setHat(totalSticks, 3);
        int randomNumber = random(0, 100);
        if (randomNumber >= 50) {
            JOptionPane.showMessageDialog(null, "The AI has been chosen to go first", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );
            while (getTotalSticks() > 0) {

                AiPlayer(aiBot1, startTotal);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!!" + human1.getName() + " is The Winner", "Game OVER!! ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);
                humanPlayer(human1);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!!" + aiBot1.getAiName() + " is The Winner", "Game OVER!! ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "The Player has been chosen to go first", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );
            while (getTotalSticks() > 0) {

                humanPlayer(human1);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!!" + aiBot1.getAiName() + " is The Winner", "Game OVER!! ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);
                AiPlayer(aiBot1, startTotal);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!!" + human1.getName() + " is The Winner", "Game OVER!! ", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    public void AIvAI() {
        int trainNUM = 1000;
        JOptionPane.showMessageDialog(null, "You have decided to Train a Smarter Bot!", "Bot Vs. Bot", JOptionPane.INFORMATION_MESSAGE );
        String tempString  = JOptionPane.showInputDialog(null, "What is the number of trainings?" , "Training Number" , JOptionPane.INFORMATION_MESSAGE );
        while(true){
            try{
                trainNUM = Integer.parseInt(tempString);
                while(trainNUM == 0 || trainNUM < -1){
                    tempString  = JOptionPane.showInputDialog(null, "What is the number of trainings?" , "Training Number" , JOptionPane.INFORMATION_MESSAGE );
                    trainNUM = Integer.parseInt(tempString);
                }
                break;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Did you read the instructions, please enter in valid integer", "Idiot box", JOptionPane.OK_OPTION);
                tempString  = JOptionPane.showInputDialog(null, "What is the number of trainings?" , "Training Number" , JOptionPane.INFORMATION_MESSAGE );
            }
        }
        
 

        AI aiBot1 = new AI();
        AI aiBot2 = new AI();
        aiBot1.setArray(totalSticks);
        aiBot2.setArray(totalSticks);
        
        int startTotal = totalSticks;
        aiBot1.setHat(totalSticks, trainNUM);
        aiBot2.setHat(totalSticks, trainNUM);

        for (int i = 0; i < trainNUM; i++) {
            setTotalSticks(startTotal);
            aiBot1.setArray(totalSticks);
            aiBot2.setArray(totalSticks);
            while (getTotalSticks() > 0) {
                int choice = aiBot1.aiTurn(totalSticks, startTotal);
                setTotalSticks(getTotalSticks() - choice);
                if (winCondition()) {
                    //aiBot2.printArray();
                    //System.out.println( "Bot 2 is the Winner!!");
                    Winner = 2;
                    break;
                }
                //System.out.println("Bot1 choice " + choice + " left " + getTotalSticks() );
                choice = aiBot2.aiTurn(totalSticks, startTotal);
                setTotalSticks(getTotalSticks() - choice);
                if (winCondition()) {
                    //aiBot1.printArray();
                    //System.out.println( "Bot 1 is the Winner!!");
                    Winner = 1;
                    break;
                }
                //System.out.println("Bot2 choice " + choice + " left " + getTotalSticks() );
            }
 
                if (Winner == 1) {
                //addAndSort(aiBot1.getArray());
                //addArray(aiBot1.getArray());
                aiBot1.addHat(aiBot1.getArray());
                aiBot2.addHat(aiBot1.getArray());
            } else {
                //addAndSort(aiBot2.getArray());
                //addArray(aiBot2.getArray());
                aiBot1.addHat(aiBot2.getArray());
                aiBot2.addHat(aiBot2.getArray());
                
            }
                

            //System.out.println();
            //System.out.println();      
        }
       // aiBot1.printHat();
        

      
        System.out.println();
        JOptionPane.showMessageDialog(null, "The Training have been completed!! Let the game Begain", "Player Vs AI", JOptionPane.INFORMATION_MESSAGE );
        
        
        Human human1 = new Human();
        String name = JOptionPane.showInputDialog(null, "What is the Name of the human Player? ", "Player Name? ", JOptionPane.INFORMATION_MESSAGE );
        human1.setName(name);
        JOptionPane.showMessageDialog(null, "The Name of Your Oppoent is: Chicken Ramen Noodle Soup", "Player Name? ", JOptionPane.INFORMATION_MESSAGE );
        aiBot1.setAiName("Chicken Ramen Noodle Soup");
        setTotalSticks(startTotal);
        
        int randomNumber = random(0, 100);
        if (randomNumber >= 50) {
            JOptionPane.showMessageDialog(null, "The AI have chosen to go first!! ", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );
            while (totalSticks > 0) {

       
                
                int choice = randomInRow(totalSticks, startTotal, aiBot1.getHat(), aiBot1.getCurrent());
                JOptionPane.showMessageDialog(null, "Chicken Ramen Noodle Soup have chosen " + choice + " Sticks", "AI Choice" , JOptionPane.INFORMATION_MESSAGE );
                setTotalSticks(totalSticks - choice);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!! " + human1.getName() + " Is the Winner!! ", "Game OVER!!!!" , JOptionPane.INFORMATION_MESSAGE );
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);
                humanPlayer(human1);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!! " + aiBot1.getAiName() + " Is the Winner!! ", "Game OVER!!!!" , JOptionPane.INFORMATION_MESSAGE );
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);

            }
        } else {
            JOptionPane.showMessageDialog(null, "The Player have chosen to go first!! ", "First Pick? ", JOptionPane.INFORMATION_MESSAGE );
            while (totalSticks > 0) {

                humanPlayer(human1);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!! " + aiBot1.getAiName() + " Is the Winner!! ", "Game OVER!!!!" , JOptionPane.INFORMATION_MESSAGE );

                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);

                
                int choice = randomInRow(totalSticks, startTotal, aiBot1.getHat(), aiBot1.getCurrent());
                JOptionPane.showMessageDialog(null, "Chicken Ramen Noodle Soup have chosen " + choice + " Sticks", "AI Choice" , JOptionPane.INFORMATION_MESSAGE );
                setTotalSticks(totalSticks - choice);
                if (winCondition()) {
                    JOptionPane.showMessageDialog(null, "There are 0 Sticks Remaining!! " + human1.getName() + " Is the Winner!! ", "Game OVER!!!!" , JOptionPane.INFORMATION_MESSAGE );
                    break;
                }
                JOptionPane.showMessageDialog(null, "There are " + totalSticks + " left", "Sticks Remain", JOptionPane.INFORMATION_MESSAGE);

            }

        }

    }

    public boolean winCondition() {

        return (getTotalSticks() <= 0);
    }


    public int randomInRow(int index, int total, int[][] target, int[] current){
        int choice = random(0,current[total - index] - 1);
        choice = target[total - index][choice];
        
        
        return choice;
    }

    
    public void humanPlayer(Human playerOBJ) {
        int choice;
        
        choice = playerOBJ.human(playerOBJ.getName(), totalSticks);
        JOptionPane.showMessageDialog(null, playerOBJ.getName() + " Chosen " + choice + " Number of Sticks!" , "Sticks Remaining", JOptionPane.INFORMATION_MESSAGE );
        setTotalSticks(totalSticks - choice);
        
        
        

    }

    public void AiPlayer(AI AiOBJ, int startTotal) {
        int choice = AiOBJ.aiTurn(totalSticks, startTotal);
        JOptionPane.showMessageDialog(null, AiOBJ.getAiName() + " Chosen " + choice + " Sticks ", "AI Choice", JOptionPane.INFORMATION_MESSAGE);
        setTotalSticks(totalSticks - choice);

    }

    public int random(int Start, int End) {
        
        int randomNum = SR.nextInt(End) + Start;
        return randomNum;
    }
   

}
