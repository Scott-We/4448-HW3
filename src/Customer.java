public abstract class Customer
{
    protected Store Business;
    protected List<Rental> Rentals;
    protected int numToolsRented;

    public void Customer()
    {
        Rentals = new ArrayList<Rental>();
    }

    public void update(int time, boolean morning)
    {
        if(morning)
        {
            for(int i = 0; i < Rentals.size(); i++)
            {
                if(Rentals.get(i).isDue(time))
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

    protected void returnTools(Rental rent)
    {
        Business.returnTools(rent);
        numToolsRented -= rent.numTools();
        Rentals.remove(rent);
    }
}