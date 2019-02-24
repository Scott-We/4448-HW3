public class BusinessCustomer extends Customer
{
    public BusinessCustomer(Store business)
    {
        super(business);
        maxTools = 3;
        minTools = 3;
        minDays = 7;
        maxDays = 7;
    }

}