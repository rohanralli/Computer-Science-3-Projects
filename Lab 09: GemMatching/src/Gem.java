import java.awt.Font;
import java.awt.Graphics;
import java.util.*;
enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem
{  
    private GemType gemType;
    private int points;
    public Gem()
    {
        Random rng = new Random();
        int x = rng.nextInt(3);
        if(x == 0)
        {
            gemType = GemType.GREEN;
        }
        else if(x == 1)
        {
            gemType = GemType.BLUE;
        }
        else
        {
            gemType = GemType.ORANGE;
        }
        points = rng.nextInt(11) * 5;
        
    }
    public Gem(GemType type, int points)
    {
        gemType = type;
        this.points = points;
    }
    public String toString()
    {
        return gemType + " " + points;
    }
    public GemType getType()
    {
        return gemType;
    }
    public int getPoints()
    {
        return points;
    }
    public void draw(double x, double y)
    {
        if(gemType == GemType.ORANGE)
        {
            StdDraw.picture(x,y,"gem_orange.png");
        }
        else if(gemType == GemType.BLUE)
        {
            StdDraw.picture(x,y,"gem_blue.png");
        }
        else
        {
            StdDraw.picture(x,y,"gem_green.png");
        }
        
        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.text(x,y,points + "");
       
    }
    /** Tester main method */
    public static void main(String [] args)
    {
      final int maxGems = 16;
      
      // Create a gem of each type
      Gem green  = new Gem(GemType.GREEN, 10);
      Gem blue   = new Gem(GemType.BLUE, 20);
      Gem orange = new Gem(GemType.ORANGE, 30);
      System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());        
      System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
      System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
      green.draw(0.3, 0.7);
      blue.draw(0.5, 0.7);
      orange.draw(0.7, 0.7);
     
      // A row of random gems
      for (int i = 0; i < maxGems; i++)
      {
          Gem g = new Gem();
          g.draw(1.0 / maxGems * (i + 0.5), 0.5);
      }
    }
}