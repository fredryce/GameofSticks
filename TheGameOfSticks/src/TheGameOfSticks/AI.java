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
public class AI {
    private String aiName;
    private int stickNum;
    private int arrayNum;
    private int[] targets;
    

    public AI() {
        arrayNum = 0;
        targets = new int[arrayNum];
    }

   
    
    public int getArrayNum() {
        return arrayNum;
    }

    public void setArrayNum(int arrayNum) {
        this.arrayNum = arrayNum;
    }

    public void setTargets(int[] targets) {
        this.targets = targets;
    }

    public int[] getTargets() {
        return targets;
    }
    
    
    public void arrayFill()
    {
        targets = new int[arrayNum];
        targets[0] = 6;
        for(int i = 1; i < arrayNum; i ++)
        {
            targets[i] = 6 + i * 4;
        }
    }
    public void printArray(){
        for(int i = 0; i< arrayNum; i++)
        {
            System.out.println(targets[i]);
        }
    }

    public String getAiName() {
        return aiName;
    }

    public void setAiName(String aiName) {
        this.aiName = aiName;
    }

    public int getStickNum() {
        return stickNum;
    }

    public void setStickNum(int stickNum) {
        this.stickNum = stickNum;
    }
    
    
    

    
    
    
}
