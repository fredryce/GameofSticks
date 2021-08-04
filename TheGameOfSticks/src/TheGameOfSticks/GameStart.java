/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGameOfSticks;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;
/**
 *
 * @author xwang2945
 */
public class GameStart {
    private int playerChoice;
    private int totalSticks;
    AI aibot = new AI();
    AI aibot2= new AI();
    
     
    
    void stickvalid(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the number of sticks to start from?");
        try{
        int Sticks = scan.nextInt();
         while (Sticks <= 1){
            System.out.println("ERROR: The number of sticks to start from is invalid, enter a new number > 1");
            Sticks = scan.nextInt();
            
        }
         setTotalSticks(Sticks);
         aibot.setArrayNum(((Sticks - 6)/4) + 1);
         aibot2.setArrayNum(((Sticks - 6)/4) + 1);
        }
        catch(InputMismatchException e){
            e.printStackTrace();
        }
        
    }
    void Display(){
        System.out.println("Press 1 for Player vs. player");
        System.out.println("Press 2 for Player Vs. AI");
        System.out.println("Press 3 for AI Vs. AI");
        
    }
    void choice(){
        Scanner choiceInput = new Scanner(System.in);
        int choice = choiceInput.nextInt();
        while(choice != 1 && choice != 2 && choice != 3){
            System.out.println("Error: Choice not valid");
            Display();
            choice = choiceInput.nextInt();
            
        }
        setPlayerChoice(choice);
      
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
    public void aiTurn()
    {
        //System.out.println(aibot.getArrayNum());
        aibot.arrayFill();
        
        
        aibot.printArray();
    }
    public int random(int begin, int end)
    {
        Random rand = new Random();
        int n = rand.nextInt(end) + begin;
        return n;
    }
    public void PVP()
    {
       System.out.println("You have chose to PVP the battle will begin NOW!");
    }
    public void PVI()
    {
        System.out.println("You've decided to challenge the AI, Good luck");
        Scanner botName = new Scanner(System.in);
        System.out.println("Name Your Enemy: ");
        String aiName = botName.nextLine();
        aibot.setAiName(aiName);
        int startingRand = random(1,2);
        if(startingRand == 1){
            System.out.println("The Pikachu have decided to let the AI for first");
            
        }
        else
        {
            System.out.println("You got the First attack, you can fight or run. pick number betweeen 1-3");
        }
        
        
        
    }
    public void AIvAI()
    {
        System.out.println("You have chosen to watch bots fight each other, PIKACHU i choose you!!!");
    }
    
    
    
    
}
    