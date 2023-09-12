
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

/*
*  This is the Model component.
*/

private static int SIZE = 60;
private LifeCell[][] grid;
private LifeCell[][] reGrid;
private boolean isNullFile;

LifeView myView;
Timer timer;

/** Construct a new model using a particular file */
public LifeModel(LifeView view, String fileName) throws IOException
{      
int r, c;
grid = new LifeCell[SIZE][SIZE];
for ( r = 0; r < SIZE; r++ )
for ( c = 0; c < SIZE; c++ )
grid[r][c] = new LifeCell();

if ( fileName == null ) //use random population
{                                          
for ( r = 0; r < SIZE; r++ )
{
for ( c = 0; c < SIZE; c++ )
{
if ( Math.random() > 0.85) //15% chance of a cell starting alive
grid[r][c].setAliveNow(true);
}
}
isNullFile = true;
}
else
{                
Scanner input = new Scanner(new File(fileName));
int numInitialCells = input.nextInt();
for (int count=0; count<numInitialCells; count++)
{
r = input.nextInt();
c = input.nextInt();
grid[r][c].setAliveNow(true);
}
input.close();
isNullFile = false;
for(int i = 0; i < grid[0].length; i++)
{
    for(int j = 0; j < grid.length; j++)
    {
        reGrid[i][j]=grid[i][j];
    }
}
}

myView = view;
myView.updateView(grid);

}

/** Constructor a randomized model */
public LifeModel(LifeView view) throws IOException
{
this(view, null);
}

/** pause the simulation (the pause button in the GUI */
public void pause()
{
timer.stop();
}

/** resume the simulation (the pause button in the GUI */
public void resume()
{
timer.restart();
}
public void reset()
{
timer.stop();
if(!isNullFile)
{
    grid= reGrid;
}
else
{
    for (int r = 0; r < SIZE; r++ )
{
for (int c = 0; c < SIZE; c++ )
{
    grid[r][c].setAliveNow(false);
if ( Math.random() > 0.85) //15% chance of a cell starting alive
grid[r][c].setAliveNow(true);
}
}
    
}
myView.updateView(grid);
}


/** run the simulation (the pause button in the GUI */
public void run()
{
timer = new Timer(50, this);
timer.setCoalesce(true);
timer.start();
}
public void color()
{
    myView.changeColor();
}

/** called each time timer fires */
public void actionPerformed(ActionEvent e)
{
oneGeneration();
myView.updateView(grid);
}

/** main logic method for updating the state of the grid / simulation */
private void oneGeneration()
{

   for(int i = 0;i < grid[0].length;i++)
{
   for(int j = 0;j < grid.length;j++)
   {
       
       int aliveNeighbors = 0;
       
       if(grid[i][j].isAliveNow() == true)
       {
           for(int r = i-1;r <= i+1;r++)
           {
               for(int c = j-1;c <= j+1;c++)
               {
                   
                   if(r >= grid[0].length || r < 0 || c >= grid.length || c < 0)
                   {
                       
                       
                    }
                   
                   else if(grid[r][c].isAliveNow() == true)
                   {
                       
                       aliveNeighbors++;
                     }
                   System.out.println(aliveNeighbors);
                 }
             }
             
             aliveNeighbors--;
             if(aliveNeighbors <= 1 || aliveNeighbors >= 4)
             {
                 grid[i][j].setAliveNext(false);
                }
                else if(aliveNeighbors == 2 || aliveNeighbors == 3)
                {
                    grid[i][j].setAliveNext(true);
                }
         }
       else
       
       {
           for(int r = i-1;r <= i+1;r++)
           {
               for(int c = j-1;c <= j+1;c++)
               {
                   if(r >= grid[0].length || r < 0 || c >= grid.length || c < 0)
                   {
                       aliveNeighbors = aliveNeighbors;
                    }
                   else if(grid[r][c].isAliveNow() == true)
                   {
                       aliveNeighbors++;
                     }
                   
                 }
             }
           
             if(aliveNeighbors == 3)
             {
                 grid[i][j].setAliveNext(true);
                }
                else
                {
                    grid[i][j].setAliveNext(false);
                }
         }
     }
 }
    for(int i = 0;i < grid[0].length;i++)
{
   for(int j = 0;j < grid.length;j++)
   {
       //if(grid[i][j].isAliveNext())
       //{
       //    grid[i][j].setAliveNow(true);
       // }
       
           grid[i][j].setAliveNow(grid[i][j].isAliveNext());
        
    }
}
}
}
