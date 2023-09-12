import java.util.*;
public class QueueProbs
{

    public QueueProbs()
    {

    }

    public Queue<Integer> evenFirst(Queue<Integer> nums)
    {
        Queue<Integer> evens = new LinkedList<>();
        Queue<Integer> odds = new LinkedList<>();
        while(!nums.isEmpty())
        {
            if(nums.peek() % 2 == 0)
            {
                evens.offer(nums.poll());
            }
            else
            {
                odds.offer(nums.poll());
            }
        }
        while(!odds.isEmpty())
        {
            evens.offer(odds.poll());
        }
        return evens;

    }
    public boolean numPalindrome(Queue<Integer> nums)
    {

      Stack<Integer> a = new Stack<>();
      Stack<Integer> b = new Stack<>();
      Queue<Integer> store = new LinkedList<>();
      


      while(!nums.isEmpty())
      {
          a.push(nums.poll());
      }
      int c = a.size();
      for(int i = 0; i < c;i++)
      {
          int temp = a.pop();
          store.offer(temp);
          b.push(temp);
        }
      while(!store.isEmpty())
      {

          if(b.pop() != store.poll())
          {

              return false;
            }
        }
        return true;
    }
    public Stack<Integer> primes(int n)
    {
        Queue<Integer> nums = new LinkedList<>();
        for(int i = 2;i <= n;i++)
        {
            nums.offer(i);
        }
        Stack<Integer> primes = new Stack<>();
        while(!nums.isEmpty())
        {
            primes.push(nums.poll());
            int c = nums.size();
            for(int i = 0;i < c;i++)

                if(nums.peek() % primes.peek() == 0)
                {
                    nums.poll();
                    
                }
                else
                {
                    nums.offer(nums.poll());
                }
            
            }

      

        return primes;
    }
}