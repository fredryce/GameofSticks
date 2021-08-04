/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheGameOfSticks;

import java.security.SecureRandom;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author xwang2945
 */
public class Human {

    private String name;

    public Human() {
        name = " ";
    }

    public Human(String name) {
        this.name = name;
    }
    

    public int human(String name, int Sticks) {   // returns the integer value the player enter as the choice.
        
        int input;
        
        String tempChoice = JOptionPane.showInputDialog(null, name + " Enter in an integer(1-3): ", Sticks + " Remaining ", JOptionPane.INFORMATION_MESSAGE);
        while (true) {
            try {
                input = Integer.parseInt(tempChoice);

                while (input != 1 && input != 2 && input != 3) {
                    tempChoice = JOptionPane.showInputDialog(null, name + " Enter in an integer(1-3): ", Sticks + " Remaining ", JOptionPane.INFORMATION_MESSAGE);
                    input = Integer.parseInt(tempChoice);

                }
                return input;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Did you read the instructions, please enter in valid integer", "Idiot box", JOptionPane.OK_OPTION);
                tempChoice = JOptionPane.showInputDialog(null, name + " Enter in an integer(1-3): ", Sticks + " Remaining ", JOptionPane.INFORMATION_MESSAGE);
            }
        }
       
       
        
    }   

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
