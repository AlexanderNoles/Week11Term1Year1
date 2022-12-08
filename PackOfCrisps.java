/**
 * The PackOfCrisps class represents a packet of crisps
 * 
 * @author  Alexander Noles
 * @version 1.0
 */
public class PackOfCrisps
{
    private boolean open = false;
    private int numOfCrisps = 10;
    private String crispFlavour;

    /**
    * Creates a PackOfCrisps with the specified flavour
    * 
    * @param flavour A string representing the packets flavour
    */
    public PackOfCrisps(String flavour)
    {
        crispFlavour = flavour;
    }

    /**
    * Tells us if the packet is closed or not
    * 
    * @return A bool, representing whether the packet is closed or not
    */
    public boolean isClosed()
    {
        return !open;
    }

    /**
    * Tells us if the packet is empty or not
    * 
    * @return A bool, representing whether the packet is empty or not
    */
    public boolean isEmpty()
    {
        return numOfCrisps <= 0;
    }

    /**
    * Opens the packet if it is closed, printing a statement describing what it has done
    */
    public void open()
    {
        if(open)
        {
            System.out.println("Packet already opened!");
            return;
        }
        open = true;
        System.out.println("Packet opened!");
    }

    /**
    * Tells us the flavour of the packet
    * 
    * @return The flavour as a string
    */
    public String getFlavour()
    {
        return crispFlavour;
    }

    /**
    * Eats a crisp from the packet.
    * If the packet is not open or empty an appropriate statement will be printed instead.
    */
    public void eatCrisp()
    {
        if(isClosed())
        {
            System.out.println("Need to open the packet first!");
            return;
        }

        if(isEmpty())
        {
            System.out.println("The packet is empty!");
            return;
        }

        numOfCrisps -= 1;
        System.out.println("Ate a crisp!");
        System.out.println("There are " + numOfCrisps + " crisps left");
    }
}
