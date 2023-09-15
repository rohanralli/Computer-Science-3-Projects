import java.util.*;
public class RecursionProbs
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class RecursionProbs
     */
    public RecursionProbs()
    {
       
    }

    public double sumReciprocals(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        else
        {
            return 1.0/n + sumReciprocals(n-1);
        }
    }
    public int productOfEvens(int n)
    {
        if(n == 1)
        {
            return 2;
        }
        else
        {
            return (n * 2) * productOfEvens(n-1);
        }
    }
    //Riddle Attempt: The future?
    public String conversion(int num, int base)
    {
        if(num / base == 0)
        {
            return "" + num % base;
        }
        else
        {
            return "" + conversion(num/base,base) + num % base;
        }
    }
    public int matchingDigits(int a, int b)
    {
        if(a == 0 || b == 0)
        {
            return a % 10 == b % 10 ? 1 : 0;
            //(condition)? value for true : value for false
        }
        else if(a % 10 == b % 10)
        {
            return 1 + matchingDigits(a/10,b/10);
        }
        else
        {
            return 0 + matchingDigits(a/10,b/10);
        }
    }
    public void doubleUp(Stack<Integer> nums)
    {
        if(nums.isEmpty())
        {
            return;
        }
        else
        {
            int temp = nums.pop();
            doubleUp(nums);
            nums.push(temp);
            nums.push(temp);
        }
    }
    public void printThis(int n)
    {

        if(n == 2)
        {
            System.out.print("**");
            return;
        }
        if(n == 1)
        {
            System.out.print("*");
            return;
        }
        else
        {
            if(n % 2 == 0)
            {
                System.out.print("<");
                printThis(n-2);
                System.out.print(">");

            }
            else
            {
                System.out.print("<");
                printThis(n-2);
                System.out.print(">");
            }
           
        }
    }
    public void printNums2(int n)
    {
        if(n == 2)
        {
            System.out.print(1 + " ");
            System.out.print(1 + " ");
            return;
        }
        if(n == 1)
        {
            System.out.print(1 + " ");
            return;
        }
        else
        {
            if(n % 2 == 0)
            {
                System.out.print(n/2 + " ");
                printNums2(n-2);
                System.out.print(n/2 + " ");

            }
            else
            {
                System.out.print(n/2 + 1 + " ");
                printNums2(n-2);
                System.out.print(n/2 + 1 + " ");
            }
           
        }
    }
    public static void main(String[] args) {
        RecursionProbs test = new RecursionProbs();
        System.out.println(test.sumReciprocals(10));
        System.out.println(test.productOfEvens(4));
        System.out.println(test.conversion(10,2));
        System.out.println(test.conversion(1453,8));
        System.out.println(test.matchingDigits(1000,0));
        System.out.println(test.matchingDigits(298892,892));
        Stack<Integer> nums = new Stack<>();
        nums.push(1);
        nums.push(2);
        nums.push(3);
        nums.push(4);
        test.doubleUp(nums);
        for(int i = 1; i <= 8; i++)
        {
            test.printThis(i);
            System.out.println();
        }
        for(int i = 1; i <= 10; i++)
        {
            test.printNums2(i);
            System.out.println();
        }
    }
   
   
}
