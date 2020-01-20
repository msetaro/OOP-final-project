
package nb.test.gamepackagev1;
import edu.sjcny.gpv1.*;
import javax.swing.JOptionPane;

import java.awt.*;


public class NBTestGamePackageV1 extends DrawableAdapter
{   static NBTestGamePackageV1 ge = new NBTestGamePackageV1();
    static GameBoard gb = new GameBoard(ge, "Snake by Matthew Setaro");
    //object declarations
    Cubes cube = new Cubes(250, 250);
    Snake snakey = new Snake();
    int count = 30;
    
  
    
    
    public static void main(String[] args) 
    {
          gb.setBackground (Color.BLACK);
          showGameBoard(gb);
          JOptionPane.showMessageDialog(gb, "Click start, then use WASD to move the snake and eat as many apples as you can!");
          
    }
    
      public void draw (Graphics g){
        snakey.show(g);
        cube.show(g);
        g.setFont(new Font ("Arial", Font.BOLD, 18));
        g.drawString("Time Remaining: " + count, 10, 50);
      
        
    }
    
    //timer
      public void timer1(){
          count--;
          winCheck();
          
      }
      
    //win
      public void winCheck(){
          if (count == 0){
              JOptionPane.showMessageDialog(gb, "You ate " + cube.getNumOfNew() + " apples!");
              gb.stopTimer(1);
          }
      }
    //collisions
    public void collisionCheck(){
        int cubeX = cube.getX();
        int cubeY = cube.getY();
        int snakeX = snakey.getX();
        int snakeY = snakey.getY();
        boolean collision ;
        
        //above
        if (((snakeY + 20) < cubeY)){ 
            collision = false;
        }
            
        //below
        else if ((snakeY > (cubeY + 20) )){ 
            collision = false;
        }
            
        
        //left
        else if (((snakeX + snakey.getHeight()) < cubeX)){
            collision = false;
        }    
        
        //right
        else if (snakeX > (cubeX + 20)){
            collision = false;
        }
        
        else
            collision = true;
        
        
        if (collision == true){
            cube.newCube();
            //snakey.grow();
            snakey.newColor();
            cube.setCC(snakey.getColor());
        }
            
            
    }

    //rotate snakey functions
    public void rotateUpDown(){
        while (snakey.getUpRight() == false)
                snakey.rotateUpDown();
    }
        
    public void rotateLeftRight(){
        while (snakey.getUpRight() == true)
                snakey.rotateLeftRight();
    }
    
    
    
    //reflect the snake when it hits the end of the canvas
    public void reflect(){
        if (snakey.getX() == 5)
            snakey.reflectXMax();
        
        else if (snakey.getX() == 490)
            snakey.reflectXMin();
        
        else if (snakey.getY() == 40)
            snakey.reflectYMax();
        
        else if (snakey.getY() == 490)
            snakey.reflectYMin();
    }
    
  
    
    
    
    //KEY BINDS
    public void keyStruck(char key){
        if (key == 'W'){
            snakey.moveUp();
            rotateUpDown();
            reflect();
            collisionCheck();
        }
            
             
        else if (key == 'A'){
            snakey.moveLeft();
            rotateLeftRight();
            reflect();
            collisionCheck();
        }
           
            
        
        else if (key == 'S'){
            snakey.moveDown();
            rotateUpDown();
            reflect();
            collisionCheck();
        }
            
             
        else if (key == 'D'){
            snakey.moveRight();
            rotateLeftRight();
            reflect();
            collisionCheck();
            
        }
            
        
    }
}

