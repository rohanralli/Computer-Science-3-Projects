
public class MazeSolverStack extends MazeSolver
{
    // instance variables - replace the example below with your own
    private MyStack stack;


    /**
     * Constructor for objects of class MazeSolverStack
     */
    public MazeSolverStack(Maze maze)
    {
        super(maze);
    }


    public void makeEmpty()
    {
        stack = new MyStack();
    }
    public boolean isEmpty()
    {
        return stack.isEmpty();
    }
    public void add(Square s)
    {
        stack.push(s);
    }
    public Square next()
    {
        return stack.pop();
    }

}
