import java.util.*;
public class GemList
{
    // instance variables - replace the example below with your own
    Node head;
    Node tail = head;
    int size;
    private class Node
    {
        private Gem gem;
        private Node next;
        public Node(Gem gem)
        {
            this.gem = gem;
        }
        public String toString()
        {
            return "" + this.gem.getType();
        }
    }
    public GemList()
    {
        size = 0;
    }

    public int size()
    {
        return size;
    }
    public void draw(double y)
    {
        Node current = head;
        int index = 0;
        while(current != null)
        {
            current.gem.draw(GemGame.indexToX(index),y);
            index++;
            current = current.next;
        }
    }
    public String toString()
    {
        
        Node current = head;
        if(current == null)
        {
            return "<none>";
        }
        String list = "";
        int i = 0;
        while(current.next != null)
        {
            list += current.toString() + " -> ";
            current = current.next;
            i++;
        }
        list += current.toString();
        return list;
    }
    public void insertBefore(Gem gem, int index)
    {
        Node new1 = new Node(gem);
        if(index == 0)
        {
            Node temp = head;
            head = new1;
            new1.next = temp;
            size++;
            if(head.next == null)
            {
                tail = head;
            }
        }
        else if(index >= size())
        {
            if(size() == 0)
            {
                if(head == null)
                {
                    Node temp = head;
                    head = new1;
                    new1.next = temp;
                    size++;
                }
                tail = head;
            }
            else
            {
                tail.next = new1;
            tail = tail.next;
            size++;
            }
            
            

        }
        else
        {
        int i = 0;
        Node current = head;
        while(i < index-1){
            current = current.next;
            i++;
        }
        Node temp = current.next;
        current.next = new1;
        new1.next = temp;
        size++;
       }
      }
       public int score()
      {
      int total = 0;
      int num = 0;
      int inRow = 1;
      Node current = head;
      while(current != null)
        {
            
                while(current.next != null && current.gem.getType()==current.next.gem.getType())
               {
               num += current.gem.getPoints();
               inRow++;
               current = current.next;
              }
            
           
           num += current.gem.getPoints();
           num *= inRow;
           total += num;
           num = 0;
           inRow = 1;
           current = current.next;
        }
      return total;
     }
        public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);        
        
        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);
        
        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);
        
        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list); System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);
        
        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);
        
        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);
        
        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);        
    }    
}
