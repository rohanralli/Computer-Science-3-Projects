import java.util.*;
public class RingBuffer
{
    private double[] data;          // items in the buffer
    private int      first;         // index for the next dequeue or peek
    private int      last;          // index for the next enqueue
    private int      size;          // number of items in the buffer

    /** create an empty buffer, with given max capacity */
    public RingBuffer(int capacity)
    {
        first = 0;
        last = 0;
        data = new double[capacity];
        size = 0;
    }

    public int size()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return size == 0;
    }
    public boolean isFull()
    {
        return size == data.length;
    }
    public void enqueue(double x)
    {
        if (isFull())
        {
            throw new RuntimeException();
        }
        else
        {
        data[last] = x;
        if(last == data.length-1)
        {
            last = 0;
        }
        else
        {
            last++;
        }
        size++;
        }
    }
    public double dequeue()
    {
        if (isEmpty())
        {
            throw new RuntimeException();
        }
        double temp = data[first];
        data[first] = 0.0;
        if(first == data.length-1)
        {
            first = 0;
        }
        else
        {
            first++;
        }
        size--;
        return temp;
    }
    public double peek()
    {
        return data[first];
    }
        public String toString() {
        return Arrays.toString(data);
    }

    /** a simple test of the constructor and methods in RingBuffer */
    public static void main(String[] args) {
        int N = 100;
        RingBuffer buffer = new RingBuffer(N);
        System.out.println(buffer.isEmpty());
        for (int i = 1; i <= N; i++) {
            buffer.enqueue(i);
        }
        System.out.println(buffer);
        System.out.println(buffer.isFull());
        double t = buffer.dequeue();
        buffer.enqueue(t);
        System.out.println("Size after wrap-around is " + buffer.size());
        while (buffer.size() >= 2) {
            double x = buffer.dequeue();
            double y = buffer.dequeue();
            buffer.enqueue(x + y);
        }
        System.out.println(buffer.peek());

        /*
         * Your program should produce the following output:
         *
         *  Size after wrap-around is 100
*  5050.0
         */
    }
}