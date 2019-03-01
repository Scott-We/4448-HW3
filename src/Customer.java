import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class Customer
{
    private Store business;
    private ArrayList<Rental> rentals;
    private int numToolsRented;

    private String name;

    private RentalStrategy rentalStrategy;

    private Customer(Store business, String name, RentalStrategy strategy) {
        this.name = name;
        rentals = new ArrayList<Rental>();
        this.business = business;
        numToolsRented = 0;
        this.rentalStrategy = strategy;
    }

    public static Customer createCasualCustomer(Store business, int ID)
    {
        RentalStrategy rs = new RandomRentalStrategy(1, 2, 1, 2);
        String name = "Casual Customer " + ID;
        return new Customer(business, name, rs);
    }
    public static Customer createRegularCustomer(Store business, int ID)
    {
        RentalStrategy rs = new RandomRentalStrategy(1, 3, 3, 5);
        String name = "Regular Customer " + ID;
        return new Customer(business, name, rs);
    }
    public static Customer createBusinessCustomer(Store business, int ID)
    {
        RentalStrategy rs = new ExactRentalStrategy(3, 7);
        String name = "Business Customer " + ID;
        return new Customer(business, name, rs);
    }

    public void update(int time, boolean morning)
    {
        if(morning)
        {
            for(int i = 0; i < rentals.size(); i++)
            {
                if(rentals.get(i).isDue(time))
                {
                    if(rentals.get(i).returnDate < time){
                        System.out.println(rentals.get(i) + " is over due");
                    }else{
                        //System.out.println(rentals.get(i) + " is due");
                    }
                }
            }
            for(int i = rentals.size()-1; i >= 0; i--)
            //for(int i = 0; i < rentals.size(); i++)
            {
                if(rentals.get(i).isDue(time))
                {
                    this.returnTools(rentals.get(i));
                }
            }
        }
        else
        {
            if (ThreadLocalRandom.current().nextInt(0, 3) == 0) {
                rent();
            }
        }
    }

    private void rent()
    {
        int availableTools = business.getNumTools();
        ArrayList<Tool> toolsToRent = new ArrayList<Tool>();

        int daysToRent = rentalStrategy.numDaysToRent();
        int numToolsToRent = rentalStrategy.numToolsToRent();

        if (availableTools >= numToolsToRent && numToolsToRent + numToolsRented <= 3) {
            int[] toolIndices = sampleRandom(0, availableTools, numToolsToRent);

            for (int i = 0; i < numToolsToRent; i++) {
                toolsToRent.add(business.getAvailableTools().get(toolIndices[i]));
            }

            rentals.add(business.rent(toolsToRent, daysToRent, name));
            numToolsRented += numToolsToRent;
        }
    }

    private void returnTools(Rental returnRental)
    {
        business.returnTools(returnRental);
        numToolsRented -= returnRental.numTools();
        rentals.remove(returnRental);
    }

    private static int[] sampleRandom(int start, int end, int count) {
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