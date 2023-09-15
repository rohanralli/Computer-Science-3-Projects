public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;
    boolean safe = true;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */

    public void solve()
    {
        // student code here
        solveHelperBottom(0);
        myView.updateView(myGrid);
        if(safe)
        {
            System.out.println("Onett is safe.");
        }
        else
        {
            System.out.println("Onett is in trouble!");
        }
       
    }
    public void solveHelperBottom(int c)
    {
        // student code here
        if(c == SIZE)
        {
            return;
        }
        if(myGrid[SIZE - 1][c].getStatus() == 1)
        {
            myGrid[SIZE - 1][c].setStatus(2);
            solveHelperGeneral(SIZE - 1,c);
           
           
        }
        solveHelperBottom(c + 1);
       
    }
    public void solveHelperGeneral(int r,int c)
    {
        // student code here
       
        if(r == 0 && myGrid[r][c].getStatus() == 2)
        {
            safe = false;
        }
        if(r < SIZE - 1 && !(myGrid[r + 1][c].getStatus() == 2) && myGrid[r + 1][c].getStatus() == 1)
        {
            myGrid[r + 1][c].setStatus(2);
            solveHelperGeneral(r + 1, c);
        }
        if(r > 0 && !(myGrid[r - 1][c].getStatus() == 2) && myGrid[r - 1][c].getStatus() == 1)
        {
            myGrid[r - 1][c].setStatus(2);
            solveHelperGeneral(r - 1, c);
        }
        if(c < SIZE - 1 && !(myGrid[r][c + 1].getStatus() == 2) && myGrid[r][c + 1].getStatus() == 1)
        {
            myGrid[r][c + 1].setStatus(2);
            solveHelperGeneral(r, c + 1);
        }
        if(c > 0 && !(myGrid[r][c - 1].getStatus() == 2) && myGrid[r][c - 1].getStatus() == 1)
        {
            myGrid[r][c - 1].setStatus(2);
            solveHelperGeneral(r, c - 1);
        }
    }

}
