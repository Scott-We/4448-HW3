import java.util.concurrent.ThreadLocalRandom;
import java.math.*;
import java.util.*;

public abstract class Customer
{
    protected Store business;
    protected ArrayList<Rental> rentals;
    protected int numToolsRented;

    protected int maxTools;
    protected int minTools;
    protected int minDays;
    protected int maxDays;

    public Customer(Store business)
    {
        rentals = new ArrayList<Rental>();
        this.business = business;
        numToolsRented = 0;
    }

    public void update(int time, boolean morning)
    {
        if(morning)
        {
            for(int i = 0; i < rentals.size(); i++)
            {
                if(rentals.get(i).isDue(time))
                {
                    returnTools(rentals.get(i));
                }
            }
        }
        else
        {
            if(numToolsRented < 3 && business.getNumTools() > 0)
            {
                rent();
            }
        }
    }

    protected void rent()
    {
        int availableTools = business.getNumTools();
        int numToolsToRent;
        ArrayList<Integer> toolsToRent = new ArrayList<Integer>();

        int daysToRent = ThreadLocalRandom.current().nextInt(minDays, maxDays + 1);

        if (availableTools >= maxTools)
        {
            numToolsToRent = ThreadLocalRandom.current().nextInt(minTools, maxTools + 1);
        }
        else
        {
            numToolsToRent = ThreadLocalRandom.current().nextInt(minTools, availableTools + 1);
        }

        for(int i = 0; i < numToolsToRent; i++)
        {
            toolsToRent.add(ThreadLocalRandom.current().nextInt(0, availableTools));
        }

        HashSet hs = new HashSet();

        while(hs.size() < numToolsToRent)
        {

            int num = (int)(Math.random()*availableTools);

            hs.add(num);

        }

        Iterator it = hs.iterator();

        while(it.hasNext())
        {

            toolsToRent.add(it.next());

        }

        store.rent(toolsToRent, daysToRent);
    }

    protected void returnTools(Rental returnRental)
    {
        business.returnTools(returnRental);
        numToolsRented -= rent.numTools();
        rentals.remove(returnRental);
    }
}