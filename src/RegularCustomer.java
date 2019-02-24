import java.util.*;

public class RegularCustomer extends Customer
{
    public RegularCustomer(Store business, String _name)
    {
        super(business, _name);
        maxTools = 3;
        minTools = 1;
        minDays = 3;
        maxDays = 5;
    }

}