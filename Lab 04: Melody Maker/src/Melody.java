import java.util.*;

/**
 * Write a description of class Melody here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Melody
{
    private Queue<Note> notes;
    
    public Melody(Queue<Note> song)
    {
        notes = new LinkedList<>();
        while(!song.isEmpty())
        {
            notes.offer(song.poll());
        
        }
    }
    
    public double getTotalDuration() {
        double totalDuration = 0.0;
        
        int s = notes.size();
        for (int i = 0; i < s; i++) {
            Note n = notes.poll();
            if(n.isRepeat())
            {
                Queue<Note> repeat = new LinkedList<>();
                repeat.offer(n);
                notes.offer(n);
                i++;
                n = notes.poll();
                
                while(!n.isRepeat())
                {
                    repeat.offer(n);
                    notes.offer(n);
                    i++;
                    n = notes.poll();

                }

                repeat.offer(n);
                while(!repeat.isEmpty()){
                    totalDuration += repeat.poll().getDuration() * 2;

                }
                
                }
            
            else
            {
                totalDuration += n.getDuration();
            }
            notes.offer(n);
        }
        return totalDuration;
        }
    public String toString(){
        String result = "";
        int s = notes.size();
        for(int i = 0;i < s;i++)
        {
            result += notes.poll().toString() + "\n";
            notes.offer(notes.poll());
        }
        return result;
        }
    public void changeTempo(double tempo)
    {
        int s = notes.size();
        for(int i = 0;i < s;i++)
        {
            Note n = notes.poll();
            n.setDuration(n.getDuration() / tempo);
            notes.offer(n);
        }
    }
    public void reverse(){
        Stack<Note> reverse = new Stack<>();
        while(!notes.isEmpty()){
            reverse.push(notes.poll());
        }
        while(!reverse.isEmpty()){
            notes.offer(reverse.pop());
        }
    }
    public void append(Melody other){
        Queue<Note> o = other.getNotes();
        int s = o.size();
        for(int i = 0;i < s;i++)
        {
            Note n = o.poll();
            notes.offer(n);
            o.offer(n);
        
        }
        
        
    }
    public void play(){
        
        int s = notes.size();
        for (int i = 0; i < s; i++) {
            Note n = notes.poll();
            if(n.isRepeat())
            {
                Queue<Note> repeat = new LinkedList<>();
                repeat.offer(n);
                notes.offer(n);
                i++;
                n = notes.poll();
                
                while(!n.isRepeat())
                {
                    repeat.offer(n);
                    notes.offer(n);
                    i++;
                    n = notes.poll();

                }

                repeat.offer(n);
                int x = repeat.size();
                for(int j = 0;j < (2 * x);j++){
                    Note a = repeat.poll();
                    a.play();
                    repeat.offer(a);
                }
                
                }
            
            else
            {
                n.play();
            }
            notes.offer(n);
        }
    }
    public Queue<Note> getNotes(){
        return notes;
    }
}