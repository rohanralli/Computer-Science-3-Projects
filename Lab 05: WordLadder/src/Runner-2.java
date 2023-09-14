import java.util.*;
import java.io.*;
public class Runner
{
    public static void main(String[] args)
    {
        //WordLadder ladder = new WordLadder("mikhail","jeff");
        //ladder.getWordLadder();
        File file = new File("input.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
         catch(IOException e){System.out.println("File not found!");
        }

        while(input.hasNext())
        {
            WordLadder ladder = new WordLadder(input.next(),input.next());
            ladder.getWordLadder();
            }
        }
    }
