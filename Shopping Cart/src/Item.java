
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private double price;
    private int bulkQ;
    private double bulkP;

    public Item(String n, double p)
    {
        this(n,p,0,p);
        name = n;
        price = p;
       
       
    }
    public Item(String n, double p, int bulkQty, double bulkPrice)
    {
        if(p < 0 || bulkQty < 0 || bulkPrice < 0)
        {
            throw new IllegalArgumentException("error");
        }
        name = n;
        price = p;
        bulkQ = bulkQty;
        bulkP = bulkPrice;
    }

    public double priceFor(int quantity)
    {
        if(quantity < 0)
        {
            throw new IllegalArgumentException("error");
        }
        if(quantity >= bulkQ)
        {
            return (bulkP * quantity);
        }
        else
        {
            return (price * quantity);
        }
    }
    private String getName()
    {
        return name;
    }
    public boolean equals(Object obj)
    {
        Item other = (Item) obj;
        if(this.name.equals(other.getName()))
        {
            return true;
        }
        return false;
    }
    public String toString()
    {
        String result = name + ", $" + price;
        if(bulkP != price)
        {
            result += " (" + name + "s are $" + price + " each, or buy " + bulkQ +
            " or more for $" + bulkP + " each)";
        }
        return result;
    }
}