/**
 * The Student class represents a student that is able to purchase packets
 * of crisps from a snack machine (modeled using PackOfCrisps and SnackMachine classes).
 * 
 * @author  Alexander Noles
 * @version 1.0
 */
public class Student
{
    private static int STUDENT_ID = 0;

    private String favouriteCrispFlavour;
    private SnackMachine targetSnackMachine;
    private String studentPersonalID;
    private Pocket studentPocket;
    private PackOfCrisps purchasedPackOfCrisps = null;

    /**
    * Creates a Student with the specified favourite flavour and target SnackMachine
    *
    * @param flavour A string representing the student's favourite flavour
    * @param machine A SnackMachine that represents the machine the student is trying to buy food from
    */
    public Student(String flavour, SnackMachine machine)
    {
        STUDENT_ID++;
        favouriteCrispFlavour = flavour;
        targetSnackMachine = machine;
        studentPersonalID = "student" + STUDENT_ID;
        studentPocket = new Pocket(20);
    }

    /**
    * Makes the student buy a packet of crisp from the machine and sets the purchasedPackOfCrisps field
    * to the packet of crips purchased from the machine
    * If the student doesn't have enough money or the machine doesn't have the
    * student's favourite flavour then a suitable error message is output to console
    */
    private void buyCrisps()
    {
        if(studentPocket.pennyCount() < targetSnackMachine.getCost())
        {
            System.out.println(studentPersonalID + " doesn't have enough money to buy a pack!");
        }
        else if(targetSnackMachine.countPacks(favouriteCrispFlavour) < 1)
        {
            System.out.println("The machine has run out of " + studentPersonalID + "'s favourite " + favouriteCrispFlavour + " crisps!");
        }
        else
        {
            int num = targetSnackMachine.getCost();
            while(num > 0)
            {
                targetSnackMachine.insertMoney(studentPocket.removePenny());
                num--;
            }

            purchasedPackOfCrisps = targetSnackMachine.buyPack(favouriteCrispFlavour);
        }
    }

    /**
    * Makes the student eat a crisp from their packet
    * If they don't have a packet of crisps they will attempt to buy one, if none are avaliable
    * then nothing else is done
    * If the packet is closed it will open
    * If the packet is empty the purcahsedPackOfCrisps field will be set to null
    */
    public void snackTime()
    {
        if(purchasedPackOfCrisps == null)
        {
            System.out.println(studentPersonalID + " is buying a pack of crisps");
            buyCrisps();
            if(purchasedPackOfCrisps == null)
            {
                //If pack of crisps is still null then there are no packets left
                return;
            }
        }

        if(purchasedPackOfCrisps.isClosed())
        {
            System.out.println(studentPersonalID + " is opening the packet");
            purchasedPackOfCrisps.open();
        }

        if(purchasedPackOfCrisps.isEmpty())
        {
            System.out.println(studentPersonalID + " has finished the packet!");
            purchasedPackOfCrisps = null;
        }
        else
        {
            System.out.println(studentPersonalID + " is eating a favourite " + purchasedPackOfCrisps.getFlavour() + " crisp");
            purchasedPackOfCrisps.eatCrisp();
        }
    }
}
