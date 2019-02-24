import java.util.concurrent.ThreadLocalRandom;
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
        ArrayList<Tool> toolsToRent = new ArrayList<Tool>();

        int daysToRent = ThreadLocalRandom.current().nextInt(minDays, maxDays + 1);

        if (availableTools >= maxTools)
        {
            numToolsToRent = ThreadLocalRandom.current().nextInt(minTools, maxTools + 1);
        }
        else
        {
            numToolsToRent = ThreadLocalRandom.current().nextInt(minTools, availableTools + 1);
        }

        int[] toolIndices = sampleRandomNumbersWithoutRepetition(0, availableTools, numToolsToRent);
        for(int i = 0; i < numToolsToRent; i++)
        {
            toolsToRent.add(business.getAvailableTools().get(toolIndices[i]));
        }
    
        business.rent(toolsToRent, daysToRent);
    }

    protected void returnTools(Rental returnRental)
    {
        business.returnTools(returnRental);
        numToolsRented -= returnRental.numTools();
        rentals.remove(returnRental);
    }

    protected static int[] sampleRandomNumbersWithoutRepetition(int start, int end, int count) {
        Random rng = new Random();

        int[] result = new int[count];
        int cur = 0;
        int remaining = end - start;
        for (int i = start; i < end && count > 0; i++) {
            double probability = rng.nextDouble();
            if (probability < ((double) count) / (double) remaining) {
                count--;
                result[cur++] = i;
            }
            remaining--;
        }
        return result;
    }
}