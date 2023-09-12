import java.util.*;
public class Catalog
{
    // instance variables - replace the example below with your own
    private String name;
    private ArrayList<Item> catalog = new ArrayList<Item>();

    public Catalog(String n)
    {
        name = n;
    }
      public void add(Item item)
    {
        catalog.add(item);
    }
    public int size()
    {
        return catalog.size();
    }
    public Item get(int index)
    {
        return catalog.get(index);
    }
    public String getName()
    {
        return name;
    }
}