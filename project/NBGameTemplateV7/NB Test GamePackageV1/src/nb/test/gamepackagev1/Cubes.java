/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nb.test.gamepackagev1;
import java.awt.*;
/**
 *
 * @author mattsetaro
 */
public class Cubes {
    
//state
    private int xCoord ;
    private int yCoord ;
    private int xLen ;
    private int yLen ;
    private Color cubeColor ;
    private int newXCoord ;
    private int newYCoord ;
    private int numOfNew ;
    
//constructor
    public Cubes ( int xCord, int yCord ){
        this.xCoord = xCord;
        this.yCoord = yCord;
        this.xLen = 20;
        this.yLen = 20;
        this.cubeColor = Color.RED;
    }
    
//behavior
    public void show(Graphics g){
        g.setColor (cubeColor);
        g.fillRect(xCoord, yCoord, xLen, yLen);
    }
    
    //newcube spawn
    public void newCube(){
        newXCoord = (int)(Math.random()*416) + 45;
        newYCoord = (int)(Math.random()*391) + 70;
        this.xCoord = newXCoord;
        this.yCoord = newYCoord;
        this.numOfNew++;
        
    }
    
    public void setCC(Color c){
        this.cubeColor = c;
    }
    //accessors
    public int getX(){
        return xCoord;
    }
    
    public int getY(){
        return yCoord;
    }
    
    public int getNumOfNew(){
        return numOfNew;
    }
    
    }
