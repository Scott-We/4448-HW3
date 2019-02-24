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
        int availableTools = business.getNumTools();
        ArrayList<Tool> toolsToRent = new ArrayList<Tool>();

        Integer[] arr = new Integer[availableTools];
        for(int i = 0; i < minTools; i++)
        {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        for(int i = 0; i < minTools; i++)
        {
            toolsToRent.add(business.getAvailableTools().get(arr[i]));
        }

        business.rent(toolsToRent, minDays);
    }

}