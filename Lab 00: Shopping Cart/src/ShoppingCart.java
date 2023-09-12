import java.util.*;
public class ShoppingCart
{
    // instance variables - replace the example below with your own
    private ArrayList<ItemOrder> shopping;

    /**
     * Constructor for objects of class ShoppingCart
     */
    public ShoppingCart()
    {
     shopping = new ArrayList<ItemOrder>();
    }

      public void add(ItemOrder newOrder)
    {
        if(shopping.indexOf(newOrder) != -1)
        {
         shopping.set(shopping.indexOf(newOrder),newOrder);
        }
        else{
           
            shopping.add(newOrder);
        }
    }
    public double getTotal()
    {
       double total = 0.0;
        for(int i = 0;i < shopping.size();i++)
        {
            total += shopping.get(i).getPrice();
        }
        return total;
    }
}
