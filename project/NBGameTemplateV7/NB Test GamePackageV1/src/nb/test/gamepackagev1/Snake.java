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
public class Snake {
    
//state
    private int x ;
    private int y ;
    private Color snakeColor ;
    private int width ;
    private int height;
    private int tempWidth;
    private int tempHeight;
    private int tempWforRL;
    private int tempHforRL;
    private boolean upRight;
    private int R ;
    private int G;
    private int B;
    private double rotation ;
    
//constructor
    public Snake(){
        this.x = 300;
        this.y = 300;
        this.width = 100;
        this.height = 20;
        this.snakeColor = Color.RED;
    }

//behavior
    public void show(Graphics g){
        g.setColor (snakeColor);
        g.fillRect (x,y,width,height);  
    }
    
    //color
    public void newColor(){
        //generates three random rgb values
        R = (int)(Math.random()*256);
        G = (int)(Math.random()*256);
        B = (int)(Math.random()*256);
        //sets the snake color to the randomly gen RGB color
        this.snakeColor = new Color(R, G, B);
    }
    
    //grow bigger after eating a cube
    public void grow(){
        this.height += 10;
    }

    
    //reflect so that when the snake moves to one endge of the screen it appears
    //on the other end
    public void reflectXMax(){
        this.x =  490;
    }
    public void reflectXMin(){
        this.x = 15;
    }
    public void reflectYMax(){
        this.y = 490;
    }
    public void reflectYMin(){
        this.y = 40;
    }
    

    //rotate up/down
    public void rotateUpDown(){
        tempWidth = width;
        tempHeight = height;
        this.width = tempHeight;
        this.height = tempWidth;
        this.upRight = true;    
    }
    
    public void rotateRight(){
        rotateLeftRight();
        this.x -= this.width;
    }
    
    public void rotateLeftRight(){
        tempWforRL = width;
        tempHforRL = height;
        this.width = tempHforRL;
        this.height = tempWforRL;
        this.upRight = false;
    }
    
    
   
    //accessors
    public int getHeight(){
        return height;
    }
    public int getX(){
         return x;
    }
    public int getY(){
        return y;
    }
    public boolean getUpRight(){
        return upRight;
    }
    
    public Color getColor(){
        return snakeColor;
    }
    
    public int getR(){
        return R;
    }
    
    public int getG(){
        return G;
    }
    
    public int getB(){
        return B;
    }
    
    //move
    public void moveUp(){
        y -= 5;
    }
    public void moveDown(){
        y += 5;
    }
    public void moveLeft(){
        x -= 5;
    }
    public void moveRight(){
        x += 5;
    }
}
