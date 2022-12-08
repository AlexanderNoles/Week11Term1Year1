import java.util.ArrayList;
/**
 * The SnackMachine class represents a snack machine that contains packets of crisps.
 * 
 * @author  Alexander Noles
 * @version 1.0
 */
public class SnackMachine
{
    private ArrayList<PackOfCrisps> packets = new ArrayList<PackOfCrisps>();
    private int capacity;
    private int cost;
    private int payment;
    private ArrayList<Penny> pennies = new ArrayList<Penny>();

    /**
    * Creates a SnackMachine with the specified capacity and cost of individual packet
    *
    * @param capacityOfMachine An integer representing the capacity of the machine (i.e. how many packets can it hold)
    * @param costOfAPacket An integer representing the cost of an individual packet
    */
    public SnackMachine(int capacityOfMachine, int costOfAPacket)
    {
        capacity = capacityOfMachine;
        cost = costOfAPacket;
    }

    /**
    * Prints the current state of the machine to console as follows
    * This snack machine has (n) packets of crisps left and has taken (m) pennies in payment
    */
    public void describe()
    {
        System.out.println("This snack machine has " + packets.size() + " packets of crisps left and has taken " + pennies.size() + " pennies in payment");
    }

    /**
    * Tells us the cost of a singular packet
    *
    * @return An integer representing the cost of an individual packet
    */
    public int getCost()
    {
        return cost;
    }

    /**
    * Tells us the amount of packets in the machine that are a certain flavour
    *
    * @param flavour flavour of the packets that are being counted
    * @return An integer representing the amount of packets (of flavour) in machine
    */
    public int countPacks(String flavour)
    {
        int countToReturn = 0;
        for(int i = 0; i < packets.size(); i++)
        {
            if(packets.get(i).getFlavour() == flavour)
            {
                countToReturn++;
            }
        }

        return countToReturn;
    }

    /**
    * Buys a packet of crisps from the machine of a specificed flavour.
    * If the packets of crisps is not in the machine, or if there 
    * is not enough money in the machince to make a purchase, then sutiable error messages
    * are output to console and null is returned.
    *
    * @param flavour flavour of the packets that is being purchased
    * @return The packet of crisps that has been purchased or null if the packet could not be purchased
    */
    public PackOfCrisps buyPack(String flavour)
    {
        if(payment < cost)
        {
            System.out.println("Not enough money inserted into machine!");
            return null;
        }

        for(int i = 0; i < packets.size(); i++)
        {
            if(packets.get(i).getFlavour() == flavour)
            {
                PackOfCrisps packToReturn = packets.get(i);
                packets.remove(i);
                payment = 0;
                return packToReturn;
            }
        }
        
        System.out.println("No packs in machine with flavour '" + flavour + "'");
        return null;
    }

    /**
    * Adds a packet of crisps to the machine.
    * The packet will not be added if the machine is full or
    * the machine already contains the packet
    *
    * @param pack The packet of crisps being added
    */
    public void addPack(PackOfCrisps pack)
    {
        if(packets.size() >= capacity)
        {
            System.out.println("Machine is already full!");
            return;
        }

        if(packets.contains(pack))
        {
            System.out.println("Packet is already in machine!");
            return;
        }

        packets.add(pack);
    }

    /**
    * Inserts a penny into the machine 
    * If the penny is already in the machine a suitable message is output
    * to console and the penny object is not added.
    *
    * @param penny The penny being entered into the machine
    */
    public void insertMoney(Penny penny)
    {
        if(pennies.contains(penny))
        {
            System.out.println("Penny has already been inserted into machine!");
            return;
        }

        pennies.add(penny);
        payment++;
    }
}

