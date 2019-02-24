public class RegularCustomer extends Customer
{
    public RegularCustomer(Store business)
    {
        super(business);
        maxTools = 1;
        minTools = 3;
        minDays = 3;
        maxDays = 5;
    }

}