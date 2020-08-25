import java.util.Scanner;
public class sticks {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		//multiplying math.random by 10 gives use our range of 10 integers.
		// cast to an int which will cut off the decimal spots.
		//casting to an int will give us 0-9, inclusive
		// then simply add 21 to get 21-30, inclusive
		int sticks = (int)(Math.random()*10) + 21;
		System.out.println("There are " + sticks + " sticks.");
		System.out.println("Select 1 to go first, select 2 to go second.");
		boolean turn; //boolean is true/false 
		if (reader.nextInt() == 1)
			turn = true;
		else
			turn = false;
		//game stops at 0 sticks so have a while loop
		while(sticks > 0) {
			if(turn)
				sticks = playerMove(sticks, reader);
			else
				sticks = computerMove(sticks);
			System.out.println("There are " + sticks + " left.");
			if (sticks == 0 && turn) // && means and
				System.out.println("Player wins!");
			if (sticks == 0 && !turn) // ! means false
				System.out.println("Computer wins!");
			turn = !turn;	// switches between turns 	
		}			
	}
	public static int playerMove(int sticks, Scanner reader) {
		System.out.println("Select how many sticks to take.");
		int take = reader.nextInt(); 
		// scanner reader is to allow the player to type in
		if (take < 1)
			take = 1;
		if (take > 3)
			take = 3;
		else if (take > sticks)
			take = sticks;
		System.out.println("You took " + take + " sticks.");
		return sticks - take; //int being returned 
	}
	public static int computerMove(int sticks) {
		int take;
		if (sticks % 4 != 0) // ! means not equal to 
			take = sticks % 4; // % will give you the remainder
		else 
			take = (int)(Math.random()*3) + 1;
		System.out.println("The computer took " + take + " sticks.");
		return sticks - take;
	
	}
}
