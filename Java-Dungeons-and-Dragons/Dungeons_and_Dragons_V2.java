import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dungeons_and_Dragons_V2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scMenuHome = new Scanner(System.in);
		Scanner scMenuWeapon = new Scanner(System.in);
		Scanner scMenuMagician = new Scanner(System.in);
		Scanner scCreateCharacter = new Scanner(System.in);
		Scanner scChoiceCharacter = new Scanner(System.in);
		Scanner scChoiceWeapon = new Scanner(System.in);
		Scanner scChoiceSpell = new Scanner(System.in);
		
		
		int menuHome = 0;
		int menuWarrior = 0;
		int menuMagician = 0;
		int createCharacter = 0;
		int choiceCharacter = 0;
		
		
		String choiceWeapon;
		String choiceSpell;
		
		
		ArrayList characters = new ArrayList();
		
		do {																			// Check entry is between 1 & 4			
			String choiceLine1;
					
			System.out.println("\n1: Create a character\n"
							 + "2: Display all characters\n"
							 + "3: Choose a character (look first list of available characters)\n"
							 + "4: Exit");
			System.out.print("\n    Your choice : ");
			choiceLine1 = scMenuHome.nextLine();
				
			if(choiceLine1.isEmpty() ) {												// Check if entry is empty
				menuHome = 0;
			}
			else if(Character.isDigit(choiceLine1.charAt(0)) == true) {	
				menuHome = Integer.parseInt(choiceLine1);								// Check if the entry is a number, otherwise repeat the question
			}			

						
			switch(menuHome) {															// 4 choice menu
				case 1:	 																// Choice 1 : Create Warrior or Magician
					boolean check0 = true;
					
					 do {						 
						String choiceLine2;
						 
						System.out.println("\n1: Create a warrior\n"
										 + "2: Create a magician");
						System.out.print("\n    Your choice : ");
						choiceLine2 = scCreateCharacter.nextLine();
						
						if(choiceLine2.isEmpty() ) {
							check0 = false;
						}
						else if(Character.isDigit(choiceLine2.charAt(0)) == true) {	
							createCharacter = Integer.parseInt(choiceLine2);			// Check if the entry is a number, otherwise repeat the question
							
							if(createCharacter == 1 || createCharacter == 2 ) {		
								check0 = true;
							}
						}
						else {
							check0 = false;
						}
					} while(check0 != true);
					
					switch(createCharacter) {
						case 1:															// Choice 1 : Create a Warrior
							Warrior2 warrior = new Warrior2();							// Initialization Name, Life, Strength
							boolean check1 = true;					
		
							do {
								System.out.print("Choose a weapon : ");
								choiceWeapon = scChoiceWeapon.nextLine();
								
								if(choiceWeapon.isEmpty() ) {
									check1 = false;
								}
								
								for(int i = 0; i < choiceWeapon.length(); i++) {		// Check if the entry is a number, otherwise repeat the question
									if(Character.isDigit(choiceWeapon.charAt(i)) == true) {	
										check1 = false;
									}
									else {
										check1 = true;
									}
								}								
							} while(check1 != true);
														 
							warrior.addWeapon(choiceWeapon);
							characters.add(warrior);									// Add Warrior in ArrayList
							
							break;
							
						case 2:															// Choice 2 : Create a Magician
							Magician mag = new Magician();								// Initialization Name, Life, Strength, Protection
							boolean check2 = true;					
							do {
								System.out.print("Choose a spell : ");
								choiceSpell = scChoiceSpell.nextLine();
								
								if(choiceSpell.isEmpty() ) {
									check2 = false;
								}
								
								for(int i = 0; i < choiceSpell.length(); i++) {					// Check if the entry is a number, otherwise repeat the question
									if(Character.isDigit(choiceSpell.charAt(i)) == true) {		
										check2 = false;
									}
									else {
										check2 = true;
									}
								}								
							} while(check2 != true);
															 
							mag.addSpell(choiceSpell);
							characters.add(mag);											// Add Magiacian in ArrayList

							break;
					}
					break;
					
				case 2: 																// Choice 2 : Display characters
					if(characters.isEmpty() ) {											
						System.out.println("\n    No available character");
					}
					else {
						System.out.println("Available characters are : ");
						for (int i = 0, j = i+1; i < characters.size(); i++, j++) {		// Check if the object in array is Warrior ou Magician
							if ( characters.get(i) instanceof Warrior2) {
								System.out.println("    " + j + " - " + ((Warrior2) characters.get(i)).getName() + " : Warrior" );	
							}
							else {
								System.out.println("    " + j + " - " + ((Magician) characters.get(i)).getName() + " : Magician" );
							}							
						}
					}
				
					break;
					
				case 3:																// Choice 3 : Choose a character
					boolean check3 = true;
					
					if(characters.isEmpty() ) {									
						System.out.println("\n    No available character");
					}
					else {
						
						do {
							String choiceLine3;
							
							System.out.print("    Enter number of a character : ");
							choiceLine3 = scChoiceCharacter.nextLine();
							
							if(choiceLine3.isEmpty() ) {
								check3 = false;
							}
							else if(Character.isDigit(choiceLine3.charAt(0)) == true) {	
								choiceCharacter = Integer.parseInt(choiceLine3)-1;			// Check if the entry is a number, otherwise repeat the question
								
							
								if(choiceCharacter >= 0 && choiceCharacter <= characters.size() ) {		// Check entry is between 0 and size of ArrayList
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
						
						if( characters.get(choiceCharacter) instanceof Warrior2 ) {				// Check if chosen character is a Warrior
						
							boolean check4 = true;
							
							do {
								String choiceLine4;
								
								System.out.println("\n1: Add a weapon\n"
												 + "2: Display the warrior");
								System.out.print("\n    Your choice : ");
								choiceLine4 = scMenuWeapon.nextLine();
								
								if(choiceLine4.isEmpty() ) {
									check4 = false;
								}
								else if(Character.isDigit(choiceLine4.charAt(0)) == true) {	
									menuWarrior = Integer.parseInt(choiceLine4);
								
									if(menuWarrior == 1 || menuWarrior == 2 ) {				
										check4 = true;
									}
								}
								else {
									check4 = false;
								}
							} while(check4 != true);
								
							switch(menuWarrior) {
								case 1:																// Choice 1 : add a weapon
									boolean check5 = true;

									do {
										System.out.print("    Choose a weapon : ");
										choiceWeapon = scChoiceWeapon.nextLine();
										
										if(choiceWeapon.isEmpty() ) {
											check5 = false;
										}
										
										for(int i = 0; i < choiceWeapon.length(); i++) {				// Check if the entry is a letter, otherwise repeat the question
											if(Character.isDigit(choiceWeapon.charAt(i)) == true) {
												check5 = false;
											}
											else {
												check5 = true;
											}
										}										
									} while(check5 != true);
																		
									((Warrior2) characters.get(choiceCharacter)).addWeapon(choiceWeapon);	// Add weapon to Warrior
																			
									break;
								case 2:															// Choice 2 : display warrior
									boolean check6 = true;
									
									do {
										System.out.println(characters.get(choiceCharacter) );				// Display Name, Life, Strength
										((Warrior2) characters.get(choiceCharacter) ).displayWeapons();	// Display weapon

									} while(check6 != true);									
							}
						}
						else {																	// // Check if chosen character is a Magician
							boolean check7 = true;
							
							do {
								String choiceLine5;
								
								System.out.println("\n1: Add a spell\n"
												 + "2: Display the magician");
								System.out.print("\n    Your choice : ");
								choiceLine5 = scMenuMagician.nextLine();
								
								if(choiceLine5.isEmpty() ) {
									check7 = false;
								}
								else if(Character.isDigit(choiceLine5.charAt(0)) == true) {	
									menuMagician = Integer.parseInt(choiceLine5);			// Check if the entry is a number, otherwise repeat the question

									if(menuMagician == 1 || menuMagician == 2 ) {			
										check7 = true;
									}
								}
								else {
									check7 = false;
								}
							} while(check7 != true);
								
							switch(menuMagician) {
								case 1:															// Choice 1 : add a spell
									boolean check8 = true;
									
									do {
										System.out.print("    Choose a spell : ");
										choiceSpell = scChoiceSpell.nextLine();
											
										if(choiceSpell.isEmpty() ) {
											check8 = false;
										}
										
										for(int i = 0; i < choiceSpell.length(); i++) {				// Check if the entry is a letter, otherwise repeat the question
											if(Character.isDigit(choiceSpell.charAt(i)) == true) {	
												check8 = false;
											}
											else {
												check8 = true;
											}
										}										
									} while(check8 != true);

									((Magician) characters.get(choiceCharacter)).addSpell(choiceSpell);	// Add spell to magician				
																				
									break;																
								case 2:																	// Choice 2 : display magician
									boolean check9 = true;
									
									do {
										System.out.println(characters.get(choiceCharacter) );			// Display Name, Life, Strength, Protection
										((Magician) characters.get(choiceCharacter) ).displaySpell();	// Display spell

									} while(check9 != true);
							}
						}
					}
					
					break;
					
				case 4: 																				// Exit
					break;
			}
			
		} while(menuHome != 4);
	}	

}

class Warrior2 extends Warrior{
	
	ArrayList<String> arrayWeapon;
	private int numberWeapon = 0;
	
	public Warrior2() {
		super();											// Initialization Name, Life, Strength
		
		arrayWeapon = new ArrayList<String>();
	}
	
	public void addWeapon(String choiceWeapon) {
		Weapon2 weap = new Weapon2();
		weap.setWeapon(choiceWeapon);								// Initialization Weapon
		arrayWeapon.add(weap.getWeapon() );						// Add weapon to array
		numberWeapon++;										// Counter number of weapons
	}
	
	public void displayWeapons() {
		if (numberWeapon == 1) {
			System.out.print("Warrior have " + numberWeapon + " weapon :");
		}
		else {
			System.out.print("Warrior have " + numberWeapon + " weapons :");
		}
		
		for(int i = 0; i < arrayWeapon.size(); i++) {				// Display weapon
			if(i == 0) {
				System.out.print(" " + arrayWeapon.get(i) );
			}
			else {
				System.out.print(", " + arrayWeapon.get(i) );
			}
		}
		System.out.println();
	}
	
	public String getName() {
		String localName = super.getNameWarrior();			// Get name of Warrior to display in the list
		
		return localName;
	}
	
	@Override
	public String toString() {
		return super.toString();							// Display Name, Life, Strength
	}	
}

class Weapon2 extends Weapons{

	public String weapon2;
	
	public Weapon2() {
		super();											// Initialization weapon
	}
	
	public void setWeapon(String weapon) {
		super.setWeapon(weapon);								
	}
	
	public String getWeapon() {
		String localWeapon = super.getWeapon();				
		
		return localWeapon;
	}

	public void displayWeapon() {							
		weapon2 = getWeapon();
		System.out.println(weapon2);
	}
}

class Magician{
	
	private String magicianName;
	private int magicianLevelLife;
	private int magicianStrengthAttack;
	private String magicianProtection;
	private ArrayList<String> arraySpell;
	private int numberSpell = 0;
	
	
	public Magician() {
		Scanner scName = new Scanner(System.in);
		Scanner scLife = new Scanner(System.in);
		Scanner scStrength = new Scanner(System.in);
		Scanner scProtection = new Scanner(System.in);
		
		boolean check1 = true;
		boolean check2 = true;
		boolean check3 = true;
		boolean check4 = true;
		
		do {
			System.out.print("\nEnter name of the magician : ");
			magicianName = scName.nextLine();
			
			if(magicianName.isEmpty() ) {
				check1 = false;
			}
			
			for(int i = 0; i < magicianName.length(); i++) {					// Check if the entry is a letter, otherwise repeat the question
				if(Character.isDigit(magicianName.charAt(i)) == true) {		
					check1 = false;
				}
				else {
					check1 = true;
				}
			}			
		} while(check1 != true);
		
		do {																				// Check entry is between 0 & 75
			String choiceLine5;
			
			System.out.print("Enter Level of Life of the Magician (betwenn 0 & 75) : ");
			choiceLine5 = scLife.nextLine();
			
			if(choiceLine5.isEmpty() ) {
				check2 = false;
			}
			else if(Character.isDigit(choiceLine5.charAt(0)) == true) {	
				magicianLevelLife = Integer.parseInt(choiceLine5);
			
				if(magicianLevelLife > 0 && magicianLevelLife <= 75) {
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
		
		do {																				// Check entry is between 0 & 150
			String choiceLine6;
			
			System.out.print("Enter the strength of Attack of the Magician (between 0 & 150) : ");
			choiceLine6 = scStrength.nextLine();
			
			if(choiceLine6.isEmpty() ) {
				check3 = false;
			}
			else if(Character.isDigit(choiceLine6.charAt(0)) == true) {	
				magicianStrengthAttack = Integer.parseInt(choiceLine6);
			
				if(magicianStrengthAttack > 0 && magicianStrengthAttack <= 150) {
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
		
		do {											 // Check if the entry is a letter, otherwise repeat the question
			System.out.print("Enter a Protection Spell: ");
			magicianProtection = scProtection.nextLine();
			
			if(magicianProtection.isEmpty() ) {
				check4 = false;
			}
			
			for(int i = 0; i < magicianProtection.length(); i++) {
				if(Character.isDigit(magicianProtection.charAt(i)) == true) {
					check4 = false;
				}
				else {
					check4 = true;
				}
			}
		} while(check4 != true);
		
		arraySpell = new ArrayList<String>();
	}
	
	public void addSpell(String choiceSpell) {
		Spell sp = new Spell();
		sp.setSpell(choiceSpell);							
		arraySpell.add(sp.getSpell() );						
		numberSpell++;										
	}
	
	public void displaySpell() {
		if( numberSpell == 1) {
			System.out.print("Magician have " + numberSpell + " spell :");
		}
		else {
			System.out.print("Magician have " + numberSpell + " spells :");
		}
		
		for(int i = 0; i < arraySpell.size(); i++) {				// Display spells
			if(i == 0) {
				System.out.print(" " + arraySpell.get(i) );
			}
			else {
				System.out.print(", " + arraySpell.get(i) );
			}
		}
		System.out.println();
	}	
	
	public String getName() {
		return magicianName;											// Get name of Magician to display in the list
	}
	
	public String toString() {										
		return "\nMagician " + magicianName + ": Level of Life = " + magicianLevelLife + ", Strength of Attack = " + magicianStrengthAttack + " , Protection Spell = " + magicianProtection;
	}	
}

class Spell{
	
	private String spell;

	public Spell() {
		spell = "Null";
	}
	
	public void setSpell(String Spell) {			
		this.spell = Spell;						
	}

	public String getSpell() {					
		return spell;							
	}	
}