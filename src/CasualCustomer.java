import java.util.*;

public class CasualCustomer extends Customer
{
    public CasualCustomer(Store business, String _name)
    {
        super(business, _name);
        maxTools = 2;
        minTools = 1;
        minDays = 1;
        maxDays = 2;
    }

}