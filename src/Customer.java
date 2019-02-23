public abstract class Customer
{
    protected Store business;
    protected ArrayList<Rental> rentals;
    protected int numToolsRented;

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
                    returnTools(Rentals.get(i));
                }
            }
        }
        else
        {
            if(numToolsRented < 3 && Business.getNumTools() > 0)
            {
                rent();
            }
        }
    }

    protected void rent();

    protected void returnTools(Rental returnRental)
    {
        business.returnTools(returnRental);
        numToolsRented -= rent.numTools();
        rentals.remove(returnRental);
    }
}