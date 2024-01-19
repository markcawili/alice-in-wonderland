**Concept and Plan**

  Alice in Wonderland is a Java text-based game based on the 1865 novel by
Lewis Carroll named, “Alice’s Adventures in Wonderland”. The game is a
puzzle/adventure game, with the ultimate goal for the player is to get Alice out of
Wonderland by collecting treasures attainable in the world.
Alice’s adventure starts at the Riverbank, where she sees a White Rabbit that
she follows down a rabbit hole. This leads to Alice becoming stuck in the world of
Wonderland with no way out. Through gameplay, Alice will come to find out how she
can return home and escape Wonderland. Alice will encounter a series of rooms or
locations she can go in and out of. Characters that she can talk to, fight, or play games
with. She will encounter items which can be traded, received as a prize, picked up,
dropped, or eaten.

**Design Elements**

The game includes 7 characters that the player can interact with. This includes,

White Rabbit - trades Pearl Necklace with Pocketwatch\
The Mad Hatter - trades Queen’s Crown with Velvet Hat\
Queen of Hearts - reveals goal of the game\
The Caterpillar - rewards Hookah upon winning addition minigame\
Cheshire Cat - gives Pocketwatch on first conversation\
The Duchess - rewards King’s Staff upon winning number guessing minigame\
March Hare - gives Teacup on first conversation

The game includes 12 items that the player interacts with. This includes,

Cake - health item\
Pocketwatch - item given on first conversation, barter for Pearl Necklace\
Pearl Necklace - treasure item traded for Pocketwatch\
Velvet Hat - barter item for Queen’s Crown\
Queen’s Crown - treasure item traded for Velvet Hat\
King’s Staff - treasure item reward for number guessing minigame\
Hookah - treasure item reward for addition minigame\
Teacup - treasure item given on first conversation\
Gloves - treasure item\
Book - treasure item\
Gold Ring - treasure item\
Sword - utility item for increasing damage

The game includes 9 locations that the player can visit. This includes,

Riverbank - initial starting location\
White Rabbit’s House - safe room, contains the Velvet Hat, Sword, and Cake\
Croquet Court - contains The Queen of Hearts\
Yard - contains The White Rabbit, Pearl Necklace, and Gloves\
Forest - contains The Caterpillar, Hookah, and Gold Ring\
Tea Party - contains The Mad Hatter and Queen’s Crown\
Meadows - contains The March Hare and Teacup\
Duchess’ Manor - contains The Duchess, King’s Staff, and Book\
Garden - contains Cheshire Cat and Pocketwatch

**Goal**

The goal of Alice at the start of the game is to find her way out of Wonderland.
Alice can happen upon The Queen of Hearts or talk to characters which will hint her to
the Queen. Upon conversation with the Queen, Alice will be tasked to collect the
Queen’s Crown and 6 other treasures that the Queen may possibly want as barter to
leave Wonderland. These items can be found around the world, given on conversation
with characters, or won as a reward from certain character’s minigames. These items
must be put in the White Rabbit’s House for the Queen to inspect at the end of the
game. The win is initiated when Alice has stored all the items in the house and comes
back to the Croquet Court, where the Queen is located, to talk to her.

**Gameplay**

At first start, the player will be presented a menu introducing them to the game. If
the player chooses help, a simple brief text outlines the basic concept of how to play the
game. Starting the game creates an object of Wonderland and calls runGame() to start.
If the player chooses to quit, the program ends. The player also has the option to quit
the game when started by typing “quit”.

There are two minigames available. The first minigame is prompted by The
Caterpillar and is an addition game. The player must answer three addition questions
correctly in order to receive the reward treasure item, Hookah. The second minigame is
prompted by the Duchess and is a number guessing game. The player must guess the
right number between 1 to 10 in 3 tries to receive the reward treasure item, King’s Staff.
The games are prompted upon the second conversation with the respective characters.
The player can reply only with “yes” or “no”.

Alice can also encounter thieves randomly at a 25% chance outside of the
Riverbank, White Rabbit’s House, and Croquet Court every time the player moves
between rooms. Alice must either fight the thief or run away, any of these actions can be
advanced by the player by typing out “attack” or “run” only. If Alice has a sword in her
inventory, she can increase her damage to 30 points, otherwise she would only be
hitting with her hands for 10 points of damage. Alice can run away but there is a 50%
chance to do so. Every time the player makes a decision, the thief has a 50% chance to
hit Alice for 33 points. If Alice defeats the thief, she can continue on to her journey. If
Alice’s health reaches 0, she dies and the player loses the game.

On first conversation, characters have a first dialogue which introduces the
character and sets a backstory. The player will be prompted to go to a location, retrieve
an item, play a game, or will be given an item. Consequent conversations with the
character do nothing more than repeat a secondary dialogue. Locations have a main
description which can be referenced to by calling look(), otherwise a return to that
location will only print out a return message. The player can also interact with the Cake
item to eat it, increasing Alice’s health by 30 points if lower than 100.

Finally, Alice possesses a 4 item inventory. Alice can pick up items available to
be picked up within the location she is at or drop items from her inventory. Within her
inventory, Alice can look at items which will print out a description of said item. The
White Rabbit’s House acts as a saferoom for increased item storage.

**Gameplay Commands**

There are a variety of commands that the player can input into the program to
trigger events within the game. Note that commands are not case sensitive. To
successfully input commands, the player must first type a command word followed by a
respective noun. Command word examples can be seen below, nouns can be either a
cardinal direction north, south, east, west, a character, or an item. Only a combination of
verb and noun will be accepted by the program.

The first command group is “TAKE”, which consists of verbs take, grab, get,
which calls the add() method to add items from the room Alice is in to her inventory if
allowed.

The second command group is “”DROP”, which consists of verbs drop, remove,
leave, which calls the drop() method to remove items from Alice’s inventory to the room
she is in.

The third command group is “MOVE”, which consists of verbs move, go, walk,
run, which calls the move() method to move Alice between rooms via the chosen
cardinal direction. The player can also simply move Alice by typing just one of the
cardinal directions as the only input instead of typing a verb with the command group
“MOVE” if they wish so.

The fourth command group is “INVENTORY”, which consists of the words inv, i,
and inventory, which calls the lookInventory() method to look inside Alice’s inventory.

The fifth command group is “TALK”, which consists of verbs chat and talk, which
calls the talk() method to talk to the character in question.

The sixth command group is “EAT”, which consists of verbs eat and bite, which
calls the eat() method to eat the cake if it is in Alice’s inventory.

The last command group is “LOOK” which consists of look that calls the look()
method for Alice to look around the room for items, characters, and a description or look
within her inventory to print a description of an item. The player must type “look [item]”
or “look around” to look at an item or the room.

**Classes**

_Wonderland_\
Contains main that presents the player with an initial menu for the game. Invokes
a method that initializes the game itself.

_Control_\
Contains methods that load text files for locations, items, characters, help into
respective HashMaps and returns the HashMap. Also contains methods to load verbs
and store them into ArrayList and getter method for the list. Also contains the
inputVerify() method which reads user input and verifies it against allowed actions to call
the corresponding action method.

_Characters_\
Contains variables that initialize a character. This includes its name, location in
the game, dialogues, and a counter for dialogue. The constructor initializes character
objects with these variables. Also contains getter methods for all variables and a setter
method for counter. Counter acts as a switch to print out first or secondary dialogue.

_Item_\
Contains variables that initialize an item. This includes its name, description,
location in the game, and a can pick up counter. The constructor initializes item objects
with these variables. Also contains getter methods for all variables and a setter method
for can pick up which acts as a switch to set if a player can pick up a specific item or
not.

_Player_\
Superclass that contains variables to initiate a Player object that represents the
player. Variables include current player location and player health. Contains getter and
setter methods for both variables.

_Inventory extends Player_\
Subclass of Player contains variables for the HashMap that represents the
player's inventory. Also contains methods to add and remove items from inventory and
to look at inventory and item descriptions. Has a getter method for inventory HashMap.

_Actions extends Player_\
Subclass of Player, contains methods that run events in the game for the player.
This includes move, look, talk, eat, and look.

_Minigame_\
Contains methods that initialize and run the two minigames available within the
game. The first method is a number guessing game, the second method is a math
addition game. Has variables that act as a switch if the player wins the game or not
which in turn allows the player to pick up an item.

_Enemy_\
Contains a method that initiates a randomized thief encounter in certain locations
within the game. Basically runs a fight or run sequence for the player until the thief
instance or the player “dies”. Has an additional method for the enemy attacking
sequence.

_Locations_\
Contains variables that initialize a location. This includes its name, adjacent
rooms, description, items in the room, characters in the room, a counter for secondary
description, and HashMaps for roomItems and roomCharacters. The constructor
initializes a location object with these variables, setting items and characters in their
respective locations by calling certain methods. Contains methods that set the items
and characters. Getter methods available for all variables and HashMaps. Setter
available for the counter.

_Verbs_\
Contains variables that initialize verb action and corresponding group label for
use in the Control class. Constructor initializes a verb and its group. Getter methods
available for action and group. User input in Control is verified if an action is available
and its group is used to call the respective method for the action.

**Text Files**

All files, excluding Help.txt, follow a simple outline for loading into the game.
Each line represents a variable to be assigned and usually includes its name,
description, location, and respective counters, groups, and adjacent rooms if applicable.
“BREAK” must be included to separate different items/locations/characters/actions. The
reader will stop loading if null is read after the last “BREAK”.

_Actions.txt_\
Contains action and label group for each allowed action.

_Characters.txt_\
Contains name, location, dialogue counter, first and secondary dialogues for
each character.

_Help.txt_\
Displays brief help text to inform the player on how to simply play the game.

_Items.txt_\
Contains name, pick up counter, location, and description for each item.

_Locations.txt_\
Contains name, adjacent rooms, repeat visit counter, and description for each
location.
