# Java-Dungeons-and-Dragons

Code developed during Bachelor's degree.

## Dungeons-and-Dragons_V1

The goal of the activity that follows is to create a game, inspired by the board games of the universe "Dungeons and
Dragons ", using the Java language. We will start by creating and displaying characters.

We will start with a simplified version: we will manipulate only one type of characters
(Warriors) and their default equipment (Weapons). Create a Warrior class.
The warrior has one or more weapons. Create an Weapon class that will contain an array of String. (weapon array)

Warriors are characterized by the following attributes:
  Warrior:
    o Name
    o Level of Life (0-100)
    o Attack Strength
    o Weapon (one or more weapons) (stored in a String array)
    o Number of weapons
  
The program begins by offering you a first menu in which you can:
   Create a Warrior (1): for this, he will ask for the appropriate information (Name, level
      of life and Force of attack) to create this character, with the input via reading of the entries
      keyboard (Scanner class), Warrior information. (In this version, the Warriors
      will be stored in an array of Warriors).
   List all existing Warriors (2)
   Choose a Warrior (3) to add a Weapon or to display it. To ask for it
      entering the Warrior number (table index.
   Exit the program (0) (otherwise we loop on the menu)
  
## Dungeons-and-Dragons_V2

We will improve the program "Dungeons and Dragons", previously developed.
We will manipulate two types of characters (warrior or magician) and their equipment by default
(weapon or spell).
The warrior has one or more weapons. The magician has one or more spells and can have a
protection spell to defend himself.

Each character type is characterized by the following attributes:
  Warrior:
    o Name
    o Level of Life (0-100)
    o Attack Strength
    o Weapon (one or more weapons)
  Magician :
    o Name
    o Level of Life (0-75)
    o Attack Strength
    o Spell (one or more spells)
    o Protection Spell (of type String)
    
Identify the class structure and inheritance to put in place in order to better manage the characters.
Create the corresponding classes.

In this version, Warriors and Magicians will be stored in a collection of Characters.
(ArrayList). Likewise, Weapons will be stored in a weapon ArrayList (which will be an attribute of
Warrior) and spells will be stored in an ArrayList (which will be an attribute of the Wizard)

The program begins by offering you a first menu in which you can:
   Create a character (1): for that, he will ask what type of character you want
     create (Warrior or Magician), then ask you for the proper information to create this
    character (name, standard of living and attack strength for Warriors, and name, level of
    life, attacking force and philtre for the Magicians), with the input via reading of the entries
    keyboard (Scanner class), character information (Warrior or Wizard).
   List all existing Characters (Warriors and Magicians) (2)
   Choose a Character (3), to add either a Weapon or a Spell, or to display it.
    To do this, enter the number of the Character (index in the ArrayList).
   Exit the program (0) (otherwise we loop on the menu)
