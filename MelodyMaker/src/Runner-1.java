import java.util.*;
public class Runner
{
    public static void main(String[] args)
    {
        QueueProbs a = new QueueProbs();
        System.out.println(a.evenFirst(makeQueue(new int[]{3,5,4,17,6,83,1,84,16,37})));
        System.out.println(a.numPalindrome(makeQueue(new int[]{3,8,17,9,17,8,3})));
        System.out.println(a.numPalindrome(makeQueue(new int[]{3,10,17,9,17,8,3})));
        System.out.println(a.primes(100));
    }
    public static Queue<Integer> makeQueue(int[] nums)
    {
        Queue<Integer> queue = new LinkedList<>();
        for(int n: nums)
        {
            queue.offer(n);
        }
        return queue;
    }
}