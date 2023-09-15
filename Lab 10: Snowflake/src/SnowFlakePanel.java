import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

class SnowFlakePanel extends JPanel
{
    public SnowFlakePanel()
    {
        super.setPreferredSize(new Dimension(1000, 1000));
        super.setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g)
    {
        int width  = getWidth();
        int height = getHeight();

        super.paintComponent(g);

        /*
         * DRAWING CODE BELOW
         */
        //g.setColor(Color.BLUE);

        for(int i = 0;i < 20; i++)
        {
            Random rcg = new Random();
           int a = rcg.nextInt(257);
           Random rcgg = new Random();
           int b = rcgg.nextInt(257);
           Random rcggg = new Random();
           int c = rcggg.nextInt(257);
            g.setColor(new Color(a,b,c));
           Random rng = new Random();
           int x = rng.nextInt(1000);
           Random rngg = new Random();
           int y = rngg.nextInt(1000);
           Random rsg = new Random();
           int z = rsg.nextInt(50);
           drawStar(g,x,y,z);
        }
       
        //g.drawLine(0, 0, width - 1, height - 1);
    }
    public void drawStar(Graphics g,int x,int y,int size)
    {
        if(size <= 10)
        {
            return;
           }
           else
           {
               int recursionDivider = 2;
               


        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(0.0))),y - (int)(size * Math.sin(Math.toRadians(0.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(0.0))),y - (int)(size * Math.sin(Math.toRadians(0.0))),size / recursionDivider);
        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(60.0))),y - (int)(size * Math.sin(Math.toRadians(60.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(60.0))),y - (int)(size * Math.sin(Math.toRadians(60.0))),size / recursionDivider);
        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(120.0))),y - (int)(size * Math.sin(Math.toRadians(120.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(120.0))),y - (int)(size * Math.sin(Math.toRadians(120.0))),size / recursionDivider);
        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(180.0))),y - (int)(size * Math.sin(Math.toRadians(180.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(180.0))),y - (int)(size * Math.sin(Math.toRadians(180.0))),size / recursionDivider);
        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(240.0))),y - (int)(size * Math.sin(Math.toRadians(240.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(240.0))),y - (int)(size * Math.sin(Math.toRadians(240.0))),size /recursionDivider);
        g.drawLine(x,y,x + (int)(size * Math.cos(Math.toRadians(300.0))),y - (int)(size * Math.sin(Math.toRadians(300.0))));
        drawStar(g,x + (int)(size * Math.cos(Math.toRadians(300.0))),y - (int)(size * Math.sin(Math.toRadians(300.0))),size / recursionDivider);

       
       
       }
        }
}
