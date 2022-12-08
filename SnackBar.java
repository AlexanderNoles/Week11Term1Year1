import java.util.*;
/**
 * The SnackBar class represents a snack bar at a school that contians a snack machine (utilizing the SnackMachine class).
 * It is also used as the entry point for the program with the "main" function.
 * 
 * @author  Alexander Noles
 * @version 1.0
 */
public class SnackBar
{
    private Random random;
    private String[] flavours;
    private SnackMachine machine;
    private ArrayList<Student> studentsInBar;

    /**
    * Creates a SnackBar with the specified number of students, specified number of packets in the machine and
    * the specified cost of a packet
    *
    * @param numberOfStudents An integer representing the number of students in the snack bar
    * @param numberOfPacketsOfCrisps An integer representing the number of packets of crisps in the snack machine
    * @param packetCost An integer representing the cost of a packet from the machine
    */
    public SnackBar(int numberOfStudents, int numberOfPacketsOfCrisps, int packetCost)
    {
        random = new Random();
        flavours = new String[]{"spicy","salt and vinegar", "ready-salted", "spring onion","prawn cocktail"};

        machine = new SnackMachine(numberOfPacketsOfCrisps, packetCost);
        for(int i = 0; i < numberOfPacketsOfCrisps; i++)
        {
            machine.addPack(new PackOfCrisps(randomFlavour()));
        }

        studentsInBar = new ArrayList<Student>();
        for(int i = 0; i < numberOfStudents; i++)
        {
            studentsInBar.add(new Student(randomFlavour(), machine));
        }
    }

    /**
    * Gives us a random flavour from the flavour array
    *
    * @return A string that is one of the flavours
    */
    private String randomFlavour()
    {
        return flavours[random.nextInt(flavours.length)];
    }

    /**
    * Prints the current state of the snack bar to console as follows
    * The SnackBar has (n) hungry students
    * The SnackMachine has:
    * (m) packet(s) of (flavour1) crisps
    * (q) packet(s) of (flavour2) crisps
    * ...
    */
    public void describe()
    {
        System.out.println("The SnackBar has " + studentsInBar.size() + " hungry students");
        System.out.println("The SnackMachine has:");
        for(int i = 0; i < flavours.length; i++)
        {
            String currentFlavour = flavours[i];
            int numberOfPacketsOfFlavour = machine.countPacks(currentFlavour);
            String packetString = " packet";
            if(numberOfPacketsOfFlavour != 1)
            {
                packetString += "s";
            }
            System.out.println(numberOfPacketsOfFlavour + packetString + " of " + currentFlavour + " crisps");
        }
    }

    /**
    * Gives us a random flavour from the flavour array
    *
    * @param nSteps An integer representing the number of steps to execute
    */
    public void runSnackBar(int nSteps)
    {
        int n = 1;
        while(nSteps >= n)
        {
            System.out.println("Time Step " + n);
            describe();
            studentsInBar.get(random.nextInt(studentsInBar.size())).snackTime();
            System.out.println(""); //Blank line for formatting
            n++;
        }
    }

    /**
    * Entry point for the program, runs when SnackBar is called from terminal
    *
    * @param args[0] A string that will be converted to an integer representing the number of students
    * @param args[1] A string that will be converted to an integer representing the number of steps
    */
    public static void main(String[] args)
    {
        SnackBar newSnackBar = new SnackBar(Integer.parseInt(args[0]), 20, 5);
        newSnackBar.runSnackBar(Integer.parseInt(args[1]));
    }
}