import java.util.concurrent.ThreadLocalRandom;
import java.math.*;
import java.util.*;

public class CasualCustomer extends Customer
{
    public CasualCustomer()
    {
        maxTools = 2;
        minDays = 1;
        maxDays = 2;
    }

}