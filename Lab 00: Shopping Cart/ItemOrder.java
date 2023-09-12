public class ItemOrder
{
    // instance variables - replace the example below with your own
    private Item item;
    private int qty;

    /**
     * Constructor for objects of class ItemOrder
     */
    public ItemOrder(Item it, int quantity)
    {
        item = it;
        qty = quantity;
    }

    public double getPrice()
    {
        return item.priceFor(qty);
    }
   
    public Item getItem()
    {
        return this.item;
    }
   
    public boolean equals(Object obj)
    {
        ItemOrder other = (ItemOrder) obj;
        if(this.item.equals(other.getItem()))
        {
            return true;
        }
        return false;
    }
}
