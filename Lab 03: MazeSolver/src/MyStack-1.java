import java.util.*;
public class MyStack
{
    // instance variables - replace the example below with your own
    private Square[] stack;
    private int size;

    /**
     * Constructor for objects of class MyStack
     */
    public MyStack()
    {
        this(7);
        stack = new Square[7];
        size = 0;
    }
    public MyStack(int initCap)
    {
        stack = new Square[initCap];
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
    public Square peek()
    {
        if(size==0)
        {
            throw new EmptyStackException();
        }
        return stack[size-1];
    }
    public Square pop()
    {
        if(size==0)
        {
            throw new EmptyStackException();
        }
        Square a = stack[size-1];
        stack[size-1] = null;
        size--;
        return a;
    }
    public void push(Square item)
    {
        if(size == stack.length)
        {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }
    private void doubleCapacity()
    {
        Square[] newStack = new Square[stack.length * 2];
        for(int i = 0;i < stack.length;i++)
        {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }
    public String toString()
    {
        String result = "[";
        for(int i = size-1;i >= 0;i--)
        {
            result += stack[i];
        }
        result += "]";
        return result;
    }
    public int size()
    {
        return size;
    }
    public void clear()
    {
        while(!isEmpty())
        {
            pop();
        }
        size = 0;
    }
}