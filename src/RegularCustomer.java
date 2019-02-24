import java.util.*;

public class RegularCustomer extends Customer
{
    public RegularCustomer(Store business)
    {
        super(business);
        maxTools = 3;
        minTools = 1;
        minDays = 3;
        maxDays = 5;
    }

}