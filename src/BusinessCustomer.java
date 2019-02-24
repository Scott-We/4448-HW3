import java.util.*;

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

    protected void rent()
    {
        int numToolsToRent = maxTools;
        int availableTools = business.getNumTools();
        ArrayList<Tool> toolsToRent = new ArrayList<Tool>();

        int[] toolIndices = sampleRandomNumbersWithoutRepetition(0, availableTools, numToolsToRent);
        for(int i = 0; i < numToolsToRent; i++)
        {
            toolsToRent.add(business.getAvailableTools().get(toolIndices[i]));
        }

        business.rent(toolsToRent, minDays);
    }

}