import java.util.*;
import java.io.*;
public class WordLadder
{
    // instance variables - replace the example below with your own
    private String start;
    private String end;
    private Queue<Stack<String>> ladder = new LinkedList<>();
    private Set<String> usedWords = new HashSet<>();
    private List<String> dictWords = new ArrayList<>();

    /**
     * Constructor for objects of class WordLadder
     */
    public WordLadder(String st,String en)
    {
        start = st;
        end = en;
        File file = new File("dictionary.txt");
        Scanner input = null;
        try {
            input = new Scanner(file);
        }
         catch(IOException e){System.out.println("File not found!");
        }

        while(input.hasNextLine())
        {
            String w = input.nextLine();
            if(w.length() == start.length())
            {
                dictWords.add(w);
            }
        }
        
        if(dictWords.contains(start.toUpperCase()) && dictWords.contains(end.toUpperCase()))
        {
         Stack<String> a = new Stack<>();
         a.push(start);
         ladder.offer(a);
        }

    }

    public void getWordLadder()
    {
        while(!ladder.isEmpty() && !(ladder.peek().peek().equals(end)))
        {
            if(!(usedWords.contains(ladder.peek().peek())))
            {
             dictionarySearch();
            }
            else
            {
                ladder.poll();
            }
        }
        if(ladder.isEmpty())
        {
            System.out.println("No ladder between " + start + " and " + end);
        }
        else{
            System.out.println("Found a ladder! >>> " + ladder.peek());
        }
        
    }
   
    public void dictionarySearch()
    {
        Stack<String> stack = ladder.poll();
        String a = stack.peek();
        usedWords.add(a);
        List<String> list = new ArrayList<>();
        while(!stack.isEmpty())
        {
            list.add(0,stack.pop());
        
        }
        for(int i = 0; i < dictWords.size();i++)
        {
           
            String word = dictWords.get(i);
            
                int count = 0;
                for(int j = 0;j < word.length();j++)
                {
                    if(!(word.substring(j,j+1).equalsIgnoreCase(a.substring(j,j+1))))
                    {
                        count++;
                    }
                }
                if(count == 1)
                {
                    Stack<String> newStack = new Stack<>();
                    for(int j = 0; j < list.size();j++)
                    {
                        newStack.push(list.get(j));
                       
                    }
                    word = word.toLowerCase();
                    newStack.push(word);
                    ladder.offer(newStack);
                }
            }
        }
    }

