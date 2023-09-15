import javax.swing.JFrame;
public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while(true) //for the flurry
		{
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
                }
	}
}