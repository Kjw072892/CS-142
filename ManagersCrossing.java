// Chase Whitney
public class ManagersCrossing {
	public static boolean isMoveOkay(int boatBefore, int managerABefore, int managerBBefore, int managerCBefore,
									 int engineerABefore, int engineerBBefore, int engineerCBefore,
									 int boatAfter, int managerAAfter, int managerBAfter, int managerCAfter,
									 int engineerAAfter, int engineerBAfter, int engineerCAfter) {

		int[] objArr = {boatBefore, managerABefore, managerBBefore, managerCBefore, engineerABefore, engineerBBefore,
				engineerCBefore, boatAfter, managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter,
				engineerCAfter};

		int[] afterArr = {managerAAfter, managerBAfter, managerCAfter, engineerAAfter, engineerBAfter, engineerCAfter};

		int[] beforeArr = {managerABefore, managerBBefore, managerCBefore, engineerABefore, engineerBBefore,
				engineerCBefore};

		//Checks if method parameters are either a 1 or a 2
		//Iterates through objArr using a for loop checking if the indexed items are either a 1 or 2.
		//Returns false and prints message if array indices are < 1 or > 2
		for(int x = 0; x < objArr.length; x++){
			if (objArr[x] < 1 || objArr[x] > 2) {
				System.out.println("All positions must be 1 or 2!");
				return false;
			}
		}

		//Checks if boatBefore equals boatAfter
		//Returns false if statement is true and prints string
		if(boatBefore == boatAfter){

			System.out.println("The boat must move!");
			return false;
		}

		//Initiated indices counter and numOfPeople counter
		//While loop checks if i counter is less than the beforeArr.length
		//The if statement compares elements in beforeArr and afterArr, if statements don't equal, inner if statements
		//	checks if boatAfter does not equal to elements in afterArr[].
		//If inner if statement is true, string is printed and returns false
		//If inner if statement is false, numOfPeople is incremented and variable i is incremented
		int i = 0;
		int numOfPeople = 0;

		while(i < afterArr.length){
			if(afterArr[i]!= beforeArr[i]){
				if(boatAfter != afterArr[i]){

					System.out.println("You may not move a person who is not with the boat!");
					return false;
				}

				//This counter will be used in the following check
				numOfPeople++;
			}
			i++;
		}

		//Checks if numOfPeople is either less than 1 or greater than 2
		//If true, string is printed and returns false
		if(numOfPeople < 1 || numOfPeople > 2){

			System.out.println("You must move one or two people!");
			return false;
		}

		//Series of if statements to check if Manager X would try to recruit someone
		//if true, string is printed and returns false;
		if(managerAAfter == engineerBAfter && managerBAfter != engineerBAfter || managerAAfter == engineerCAfter &&
				managerCAfter != engineerCAfter){

			System.out.println("Manager A would try to recruit someone!");
			return false;
		}

		if(managerBAfter == engineerAAfter && managerAAfter != engineerAAfter || managerBAfter == engineerCAfter &&
				managerCAfter != engineerCAfter){

			System.out.println("Manager B would try to recruit someone!");
			return false;
		}

		if(managerCAfter == engineerAAfter && managerAAfter != engineerAAfter || managerCAfter == engineerBAfter &&
				managerBAfter != engineerBAfter){

			System.out.println("Manager C would try to recruit someone!");
			return false;
		}

		//Initialized counter to use to iterate through afterArr[]
		//for loop statement checks if boatAfter equals 2 and iterates through afterArr using j variable used in for loop
		//	to check if elements in afterArr is equal to 2. if true, counter is incremented by 1.
		//Second if statement checks if the counter is equal to the afterArr length. if true, string is printed and returns
		// true

		int counter = 0;

		for(int j = 0; j < afterArr.length; j++){
			if(boatAfter==2 && afterArr[j] == 2){
				counter ++;
			}
			if(counter == afterArr.length){
				System.out.println("You solved the puzzle!");
				return true;
			}
		}
			//returns True if the move is okay
			return true; // The method should only return false sometimes!
		}
}