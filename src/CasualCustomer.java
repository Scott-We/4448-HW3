public class CasualCustomer extends Customer
{
    public CasualCustomer(Store business)
    {
        super(business);
        maxTools = 2;
        minTools = 1;
        minDays = 1;
        maxDays = 2;
    }

}