import java.util.Scanner;

public class Dungeons_and_Dragons_V1 {

	private static int indexArrayWarrior = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scMenuHome = new Scanner(System.in);
		Scanner scMenuWarrior = new Scanner(System.in);
		Scanner scChoiceWeapon = new Scanner(System.in);
		Scanner scChoiceWarrior = new Scanner(System.in);
		
		int menuHome = 0;
		int menuWarrior = 0;
		int choiceWarrior = 0;
		
		String choiceWeapon;
		
		Warrior[] arrayWarrior = new Warrior[20];
		
		do {																		// Checking the number entered is between 1 & 4
			
			String choiceLine0;
			
			System.out.println("\n1: Create a Warrior\n"
							 + "2: Display existing Warriors\n"
							 + "3: Choose a Warrior (look first list of available Warriors)\n"
							 + "4: Exit");
			System.out.print("\n    Your choice : ");
			choiceLine0 = scMenuHome.nextLine();
			
			if(choiceLine0.isEmpty() ) {
				menuHome = 0;
			}
			else if(Character.isDigit(choiceLine0.charAt(0)) == true) {	
				menuHome = Integer.parseInt(choiceLine0);							// Check if the entry is a number, otherwise repeat the question
			}	
						
			switch(menuHome) {														// 4 choice menu
				case 1:	 															// Choice 1 : Create Warrior
					Warrior g = new Warrior();										// Initialization Name, Life, Strength
					boolean check1 = true;					

					do {
						System.out.print("Choose a weapon : ");
						choiceWeapon = scChoiceWeapon.nextLine();
						
						if(choiceWeapon.isEmpty() ) {
							check1 = false;
						}
						
						for(int i = 0; i < choiceWeapon.length(); i++) {				// Check if the entry is a number, otherwise repeat the question
							if(Character.isDigit(choiceWeapon.charAt(i)) == true) {
								check1 = false;
							}
							else {
								check1 = true;
							}
						}	
					} while(check1 != true);
					
						 
					g.addWeapon(choiceWeapon);
					arrayWarrior[indexArrayWarrior] = g;							// Add Warrior in array
					indexArrayWarrior++;											
						 						 
					break;
					
				case 2: 															// Choice 2 : Display list of characters
					if(arrayWarrior[0] == null) {									// If the array is empty then no character is displayed
						System.out.println("\n    None Warrior exist.");
					}
					else {
						System.out.println("Existing Warriors are : ");
						for (int i = 0, j = i+1; i < indexArrayWarrior; i++, j++) {
							System.out.println("    " + j + " - " + arrayWarrior[i].getNameWarrior());
						}
					}
				
					break;
					
				case 3:																// Choice 3 : Choose a character
					boolean check2 = true;
					
					if(arrayWarrior[0] == null) {									// If the array is empty then no character is displayed
						System.out.println("\n    None Warrior exist.");
					}
					else {
						String choixLine1;
						
						do {
							System.out.print("    Choose Warrior number : ");
							choixLine1 = scChoiceWarrior.nextLine();
							
							if(choixLine1.isEmpty() ) {
								check2 = false;
							}
							else if(Character.isDigit(choixLine1.charAt(0)) == true) {	
								choiceWarrior = Integer.parseInt(choixLine1)-1;								// Check if the entry is a number, otherwise repeat the question								
							
								if(choiceWarrior >= 0 && choiceWarrior <= indexArrayWarrior-1) {			// Check that entered number is between 0 and size of the array
									check2 = true;
								}
								else {
									check2 = false;
								}
							}
							else {
								check2 = false;
							}
						} while(check2 != true);
					
						boolean check3 = true;
							
						do {
							String choixLine2;
							
							System.out.println("\n1: Add a weapon\n"
												 + "2: Show Warrior");
							System.out.print("\n    Your choice : ");
							choixLine2 = scMenuWarrior.nextLine();
							
							if(choixLine2.isEmpty() ) {
								check3 = false;
							}
							else if(Character.isDigit(choixLine2.charAt(0)) == true) {	
								menuWarrior = Integer.parseInt(choixLine2);					// Check if the entry is a number, otherwise repeat the question
																
								if(menuWarrior == 1 || menuWarrior == 2) {					// Check that entered number is 1 or 2
									check3 = true;
								}
							}
							else {
								check3 = false;
							}
						} while(check3 != true);
							
						switch(menuWarrior) {
							case 1:															// Choice 1 : Add a weapon
								boolean verif4 = true;

								do {
									System.out.print("    Choose a weapon : ");
									choiceWeapon = scChoiceWeapon.nextLine();
										
									if(choiceWeapon.isEmpty() ) {
										verif4= false;
									}
									
									for(int i = 0; i < choiceWeapon.length(); i++) {				// Check if the entry is a letter, otherwise repeat the question
										if(Character.isDigit(choiceWeapon.charAt(i)) == true) {	
											verif4 = false;
										}
										else {
											verif4 = true;
										}
									}										
								} while(verif4 != true);
															
								arrayWarrior[choiceWarrior].addWeapon(choiceWeapon);					// Add weapon to the warrior					
										
								break;
							case 2:															// Choice 2 : Display warriors
								boolean verif5 = true;
								
								do {
									System.out.println(arrayWarrior[choiceWarrior]);			// Display Name, Life, Strength
									arrayWarrior[choiceWarrior].displayWeapons();				// Display weapon
								} while(verif5 != true);									
						}						
					}
					
					break;
					
				case 4: 
					break;
			}			
		} while(menuHome != 4);
		
	}	
}



class Warrior{
	
	private String nameWarrior;
	private int levelLifeWarrior;
	private int strengthAttackWarrior;
	private String[] arrayWeapons;
	private int numberWeapons = 0;
	private int indexWeapons = 0;
	
	
	public Warrior() {
		Scanner scName = new Scanner(System.in);
		Scanner scLife = new Scanner(System.in);
		Scanner scStrength = new Scanner(System.in);
		
		boolean check1 = true;
		boolean check2 = true;
		boolean check3 = true;
		
		do {
			System.out.print("\nEnter name of the Warrior : ");
			nameWarrior = scName.nextLine();
			
			if(nameWarrior.isEmpty() ) {
				check1 = false;
			}

			for(int i = 0; i < nameWarrior.length(); i++) {								// Check if the entry is a leter, otherwise repeat the question
				if(Character.isDigit(nameWarrior.charAt(i)) == true) {
					check1 = false;
				}
				else {
					check1 = true;
				}
			}			
		} while(check1 != true);
		
		do {																			// Check if the entry is between 0 and 100
			String choiceLine3;
			
			System.out.print("Enter Level of Life of the Warrior (betwenn 0 & 100) : "); 
			choiceLine3 = scLife.nextLine();
			
			if(choiceLine3.isEmpty() ) {
				check2 = false;
			}
			else if(Character.isDigit(choiceLine3.charAt(0)) == true) {	
				levelLifeWarrior = Integer.parseInt(choiceLine3);						// Check if the entry is a number, otherwise repeat the question
						
				if(levelLifeWarrior > 0 && levelLifeWarrior <= 100 ) {
					check2 = true;
				}
				else {
					check2 = false;
				}
			}
			else {
				check2 = false;
			}
		} while(check2 != true);
		
		do {																			// Check if the entry is between 0 and 150
			String choiceLine4;
			
			System.out.print("Enter the strength of Attack of the Warrior (between 0 & 150) : "); 
			choiceLine4 = scStrength.nextLine();
			
			if(choiceLine4.isEmpty() ) {
				check3 = false;
			}
			else if(Character.isDigit(choiceLine4.charAt(0)) == true) {	
				strengthAttackWarrior = Integer.parseInt(choiceLine4);
			
				if(strengthAttackWarrior > 0 && strengthAttackWarrior <= 150) {
					check3 = true;
				}
				else {
					check3 = false;
				}
			}
			else {
				check3 = false;
			}
		} while(check3 != true);
		
		arrayWeapons = new String[20];
		
	}
	
	public void addWeapon(String choiceWeapon) {
		Weapons a = new Weapons();
		a.setWeapon(choiceWeapon);							// Set weapon
		arrayWeapons[indexWeapons] = a.getWeapon();			// Add weapon in array
		indexWeapons++;										// Index counter of the array
		numberWeapons++;									// Weapon counter
	}
	
	public void displayWeapons() {
		if( numberWeapons == 1) {
			System.out.print("Warrior have " + numberWeapons + " weapon :");
		}
		else {
			System.out.print("Warrior have " + numberWeapons + " weapons :");
		}
		
		for(int i = 0; i < indexWeapons; i++) {						// Display weapons
			if(i == 0) {
				System.out.print(" " + arrayWeapons[i] );
			}
			else {
				System.out.print(", " + arrayWeapons[i] );
			}
		}
		System.out.println();
	}
	
	public String getNameWarrior() {
		return nameWarrior;
	}

	public String toString() {
		return "\nWarrior " + nameWarrior + ": Level of Life = " + levelLifeWarrior + ", Strength of Attack = " + strengthAttackWarrior;
	}
	
}

class Weapons{
	
	public String weapon;

	public Weapons() {
		weapon = "Null";
	}
	
	public void setWeapon(String weapon) {			// Set weapon
		this.weapon = weapon;
	}

	public String getWeapon() {						// Get weapon
		return weapon;
	}	
}