import java.util.*;
import java.io.*;
public class Maze
{
    // instance variables - replace the example below with your own
    private Square[][] maze;
    private Square s;
    private Square e;

    public Maze()
    {
       
    }

    public boolean loadMaze(String fileName)
    {
       
        File file = new File(fileName);
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
        catch (IOException e) {
            System.out.println("Can't find file!");
            return false;
        }
        int r = input.nextInt();
        int c = input.nextInt();
        maze = new Square[r][c];
        
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                maze[i][j] = new Square(i, j , input.nextInt());
                if(maze[i][j].getType() == Square.EXIT)
                {
                    e = maze[i][j];
                }
                if(maze[i][j].getType() == Square.START)
                {
                    s = maze[i][j];
                }
            }
        }
        return true;
    }
    public List<Square> getNeighbors(Square s)
    {
        List<Square> list = new ArrayList<Square>();
        if(s.getRow()-1 >= 0)
        {
            list.add(maze[s.getRow()-1][s.getCol()]);
        }
         if(s.getCol()+1 < maze[0].length)
        {
            list.add(maze[s.getRow()][s.getCol()+1]);
        }
        if(s.getRow()+1 < maze.length)
        {
            list.add(maze[s.getRow()+1][s.getCol()]);
        }
        if(s.getCol()-1 >= 0)
        {
            list.add(maze[s.getRow()][s.getCol()-1]);
        }
       
        
        return list;
    }
    public Square getStart()
    {
        return s;
    }
    public Square getExit()
    {
        return e;
    }
    public void reset()
    {
        for(int i = 0; i < maze.length; i++)
        {
            for(int j = 0; j < maze[0].length; j++)
            {
                if(maze[i][j].getType() == 0)
                {
                    maze[i][j].reset();
                }
            }
        }
    }
    public String toString()
    {
        String str = "";
        for(int i = 0; i < maze.length; i++)
        {
            if(i != 0) //just adding this so it won't add an extra line
            {
                str += "\n";
            }
            for(int j = 0; j < maze[0].length; j++)
            {
                str += maze[i][j].toString() + " ";
            }
        }
        return str;
    }
    public Square[][] getMaze()
    {
        return maze;
    }
}
