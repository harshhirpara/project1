package Reccursion;
import java.util.Scanner;
public class ToweOfHanoi {
	 static int count = 0;	
	  /** Main method */
	  public static void main(String[] args) {
	    // Create a Scanner
	    Scanner input = new Scanner(System.in);
	    System.out.print("Enter number of disks: ");
	    int n = input.nextInt();

	    // Find the solution recursively
	    System.out.println("The moves are:");
		long begin, end, time; // we will measure time it took to search
		begin = System.nanoTime();//we measure in nanoseconds.
		moveDisks(n, 'A', 'B', 'C');
		end = System.nanoTime();
		time = end-begin;
		System.out.println("# of moves: "+ count);
	    System.out.println("Run time of tower of hanoi:" + time);
	  }

	  /** The method for finding the solution to move n disks
	      from fromTower to toTower with auxTower */
	  public static void moveDisks(int n, char fromTower,
	      char toTower, char auxTower) {  
	    if (n == 1) // Stopping condition
	    {
	      System.out.println("Move disk " + n + " from " +
	        fromTower + " to " + toTower);
	      count++;
	    }
	    else {
	      moveDisks(n - 1, fromTower, auxTower, toTower);
	      System.out.println("Move disk " + n + " from " +
	        fromTower + " to " + toTower);
	      count++;
	      moveDisks(n - 1, auxTower, toTower, fromTower);
	    }
	  }

}
