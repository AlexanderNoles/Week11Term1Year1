import java.util.*;
/**
 * The Pocket class represents a pocket that contains pennies (represented by the Penny class). 
 * It is used to model the pockets of students.
 * 
 * @author  Alexander Noles
 * @version 1.0
 */
public class Pocket
{
    HashSet<Penny> pennies;
    
    /**
    * Creates a Pocket of the specified size
    *
    * @param sizeOfPocket An integer representing the size of the pocket
    */
    public Pocket(int sizeOfPocket)
    {
        pennies = new HashSet<Penny>();

        for(int i = 0; i < sizeOfPocket; i++)
        {
            pennies.add(new Penny());
        }
    }

    /**
    * Tells us the number of pennies in the pocket
    *
    * @return Integer representing the number of pennies in the pocket
    */
    public int pennyCount()
    {
        return pennies.size();
    }

    /**
    * Removes a Penny from the pocket
    *
    * @return Returns the removed Penny, if there are no pennies null is returned
    */
    public Penny removePenny()
    {
        for(Penny currentPenny: pennies)
        {
            pennies.remove(currentPenny);
            return currentPenny;
        }

        System.out.println("No pennies in pocket");
        return null;
    }
}
