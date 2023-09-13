import java.util.*;
public abstract class MazeSolver
{
    // instance variables - replace the example below with your own
    public Maze maze = new Maze();
    private boolean solved = false;
    private boolean solvable = true;
    



    /**
     * Constructor for objects of class MazeSolver
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
        makeEmpty();
        add(maze.getStart());
    }


    public abstract void makeEmpty();
    public abstract boolean isEmpty();
    public abstract void add(Square s);
    public abstract Square next();
    public boolean isSolved()
    {
        if(solved)
        {
            return solved;
        }
        else if(solvable == false)
        {
            return !solvable;
        }
        return false;
    }
    public void step()
    {
        if(isEmpty())
        {
            solvable = false;
        }
        else //I know I don't really need to add the "else" structure, but just for readability!
        {
            Square a = next(); 
            if(a.getType() == Square.EXIT)
            {
                solved = true;
            }
            else
            {

                List<Square> neighbors = maze.getNeighbors(a);
                 for(int i = 0; i < neighbors.size();i++)
                 {
                     if(!(neighbors.get(i).getType() == Square.WALL))
                     {
                         if(!(neighbors.get(i).getStatus() == Square.WORKING) && !(neighbors.get(i).getStatus() == Square.EXPLORED))
                         {
                             
                             neighbors.get(i).setStatus(Square.WORKING);
                             add(neighbors.get(i));
                             
                            }
                         
                        }
                    }
                    a.setStatus(Square.EXPLORED);
            }
        }
    }
    public String getPath()
    {
        String a = "";
        if(!isSolved())
        {
            a += "Maze not solved";
        }
        else if(solved = true)
        {
            a += "Maze is solved";
            
        }
        else if(solvable = false)
        {
            a += "Maze is unsolvable";
        }
        return a;
    }
    public void solve()
    {
        while(!isSolved())
        {
            step();
        }
    }
}