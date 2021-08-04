/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGameOfSticks;

import java.security.SecureRandom;


/**
 *
 * @author xwang2945
 */
public class AI {

    private String aiName;

    private int[] choice;          //keeps the winner choices every game the bot play.
    private int[][] hat;           //Hat that keeps the data everytime the Ai wins a game
    private int [] current;        //keeps the index number for the hat at certain number of sticks so the choices would be correctly placed
    SecureRandom rand = new SecureRandom();

    public AI() {                  //default constructor
        aiName = " ";
        hat = new int[0][0];
        choice = new int[0];
        current = new int [0];
    }

    public AI(String aiName, int[] choice, int[][] hat, int[] current) {
        this.aiName = aiName;
        this.choice = choice;
        this.hat = hat;
        this.current = current;
    }

    
    public void setHat(int totalSticks, int trainNUM){        //creating the Hat array and current array. then setting the first 3 columns of the hat array as 1,2,3. fill in the current array all as 3. 
        hat = new int[totalSticks][trainNUM];
        current = new int[totalSticks];
       

          for (int i = 0; i < totalSticks; i++) {
            current[i] = 3;
            for (int j = 0; j < 3; j++) {
                hat[i][j] = j + 1;

            }
        }
        
    }
    public void addHat(int[] winnerChoice){                 //Takes in the winner array from the Ai, for everychoice Ai made that is not 0, its added to the hat Array then the current array is updated at that index
        for(int i = 0; i < winnerChoice.length; i++){
            if(winnerChoice[i] != 0){
                hat[i][current[i]] = winnerChoice[i];
                current[i]+= 1;
            }
        }
       
         
    }
    

    public void setArray(int column) {                      //Used to set the local choice array that is going to store the choices of the winner bot single game.
        //count = 0;
        choice = new int[column];
        //setArrayNum(column);

    }

 

   

    public void printArray() {                              //print the choice array of AI every game if needed
        for (int i = 0; i < choice.length; i++) {
            System.out.print(choice[i]);

        }
        System.out.println();
    }

    public String getAiName() {                             //get the name of the AI
        return aiName;
    }

    public void setAiName(String aiName) {                  //set the name of the AI
        this.aiName = aiName;
    }

    public int aiTurn(int currentSticks, int Total) {       //at index total - currentSTicks, the choice would be chosen within the hat array. and the choice is returned and also added to the choice array.

        int aiChoice = hat[Total - currentSticks][random(0, current[Total - currentSticks] - 1)];
        if (aiChoice >= currentSticks) {
            aiChoice = aiChoice - currentSticks;
            if (aiChoice == 0) {
                aiChoice = 1;
            }
        }
        choice[Total - currentSticks] = aiChoice;
        //current[Total - currentSticks] += 1;
        return (aiChoice);
    }

    public int random(int begin, int end) {                 //function generate a securerandom number
        
        int n = rand.nextInt(end) + begin;
        return n;
    }
    public int[][] getHat(){                                //get hat returns 2D array if needed 
        return hat;
    }
    public int[] getCurrent(){                              //get current returns the 1d array if needed
        return current;
    }

    public int[] getArray() {                               // get Array return choice array if needed

        return choice;
    }
    public void printHat(){                                 //printHat prints the hat Array of the Ai if needed
        for(int i = 0; i < hat.length; i++ ){
            System.out.println();
            for(int j = 0; j < hat[0].length; j++){
                System.out.print(hat[i][j]);
            }
        }
    }
}
