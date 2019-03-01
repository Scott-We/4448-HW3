import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

public class Customer
{
    private Store store;
    private ArrayList<Rental> rentals;
    private int numToolsRented;

    private String name;

    private RentalStrategy rentalStrategy;

    private Customer(Store store, String name, RentalStrategy strategy) {
        this.name = name;
        rentals = new ArrayList<Rental>();
        this.store = store;
        numToolsRented = 0;
        this.rentalStrategy = strategy;
    }

    // Handles creation of Casual Customers. Generates a RandomRentalStrategy with the appropriate limits.
    public static Customer createCasualCustomer(Store store, int ID)
    {
        RentalStrategy rs = new RandomRentalStrategy(1, 2, 1, 2);
        String name = "Casual Customer " + ID;
        return new Customer(store, name, rs);
    }

    // Handles creation of Regular Customers. Generates a RanomRentalStrategy with the appropriate limits.
    public static Customer createRegularCustomer(Store store, int ID)
    {
        RentalStrategy rs = new RandomRentalStrategy(1, 3, 3, 5);
        String name = "Regular Customer " + ID;
        return new Customer(store, name, rs);
    }
    // Handles creation of Business Customers. Generates an ExactRentalStrategy with the appropriate numbers.
    public static Customer createBusinessCustomer(Store store, int ID)
    {
        RentalStrategy rs = new ExactRentalStrategy(3, 7);
        String name = "Business Customer " + ID;
        return new Customer(store, name, rs);
    }

    // In the mornings, return any rentals that are due.
    // In the afternoon, make a rental with 1/3 probability.
    public void update(int time, boolean morning)
    {
        if(morning)
        {
            for(int i = rentals.size()-1; i >= 0; i--)
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

    // Use the RentalStrategy to choose number of tools and how long to rent.
    // If possible, choose a random list of tools and rent them.
    private void rent()
    {
        int availableTools = store.getNumTools();
        ArrayList<Tool> toolsToRent = new ArrayList<Tool>();

        int daysToRent = rentalStrategy.numDaysToRent();
        int numToolsToRent = rentalStrategy.numToolsToRent();

        if (availableTools >= numToolsToRent && numToolsToRent + numToolsRented <= 3) {
            int[] toolIndices = sampleRandom(0, availableTools, numToolsToRent);

            for (int i = 0; i < numToolsToRent; i++) {
                toolsToRent.add(store.getAvailableTools().get(toolIndices[i]));
            }

            rentals.add(store.rent(toolsToRent, daysToRent, name));
            numToolsRented += numToolsToRent;
        }
    }

    // Returns a rental.
    private void returnTools(Rental returnRental)
    {
        store.returnTools(returnRental);
        numToolsRented -= returnRental.numTools();
        rentals.remove(returnRental);
    }

    // Helper function which chooses a random list of non-repeating numbers from a range.
    // This function was created by user "the" on Stack Overflow, here:
    // https://stackoverflow.com/a/29750138
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