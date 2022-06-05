Hopefuly a useful explanation of whats going on with pseudocode

paths are as __*/foo/bar*__ (bold and italic), while filenames are <span style="text-decoration: underline">foo.java</span> (underlined) and fucntions _foo()_ (italic)
<br>

### <span style="text-decoration: underline">[App.java](/src/App.java)</span>
<details><summary></summary>

Works as Main class  

#### _main()_
Create a shutdown hook from which [_quit()_](####_quit()_)
Get flags from user, if there are any  
switch through the flags when flag is either  
    help,  
    bigger-help,  
    invincible or,  
    super-strength  
        call Help.flagHelp(),  
        Help.biggerHelp(),  
        Player.isInvincible = true;  
        Player.isSuperStrong = true  
in this order

at the end call Menu.mainMenu();

#### _quit()_
When the program gets a Sigterm or a Sigint, or exits on its own, this method gets called, via the [_main()_](####_main()_)  
based on the user, aka flag, the player stats will be written in a `data.csv` file in the current directory
</details>

---

## __*[Classes](/src/Classes/)*__
<details><summary></summary>

### <span style="text-decoration: underline">[ASCII.java](/src/Classes/ASCII.java)</span>
<details><summary></summary>

Contains ascii art of wizard and megamind

</details>

### <span style="text-decoration: underline">[DataAndOtherStuff.java](/src/Classes/DataAndOtherStuff.java)</span>
<details><summary></summary>

Contains most of the data, mainly enemy and player hp, strength and such

</details>

### <span style="text-decoration: underline">[Enemy.java](/src/Classes/Enemy.java)</span>
<details><summary></summary>

This is what the player will fight when hunting or searching  
Enemy has just a constructor applying the correct hp and strength and other data based on rarity or a special location  

Rarity is works as interval, so enemy rarity 5 means enemy from 1 to 5 can spawn  
Special location allows only one type of enemy to spawn

</details>

### <span style="text-decoration: underline">[Inventory.java](/src/Classes/Inventory.java)</span>
<details><summary></summary>

Stores all items player has, that can be used in a meaningfull way  
Everything is stored in an arraylist

#### _init()_
Set all item values to 0

#### _get(String item)_
Returns the amount of items asked for

`get("wood");`

#### _add(String item, int value)_
Add the value given to an existing item

`get("wood"); => 10`

`add("wood", 5);`

`get("wood"); => 15`

#### _set(String item, int value)_
Set the items value to the given one

`get("wood"); => 10`

`add("wood", 5);`

`get("wood"); => 5`

</details>

### <span style="text-decoration: underline">[Player.java](/src/Classes/Player.java)</span>
<details><summary></summary>

The class you play as, contains a lot of varibles, including some not nescessary values like kills and coins

#### _init(String class)_
Give the player stats according to input

#### _addXP(int amount)_
Add xp from battle to existing amount  
If applies, increase the level as well  
Each level takes `500 * [Current Level]`

#### _playerInfoString()_
Returns a string of information mainly usefull when in battle
includes hp, strength and potions

</details>
</details>

---

## __*[Colors](/src/Colors/)*__
<details><summary></summary>

### <span style="text-decoration: underline">[Colorize.java](/src/Colors/Colorize.java)</span>
<details><summary></summary>

Contains strings usefull in ansi supporting terminals  
these strings are mainly colors, but also the prompt and separators

#### _capitalize(String s)_
Capitalizes the string given

`capitalize("hello"); => "Hello"`

#### _scannerize(String s)_
Returns a string rid of spaces and capital letters

`scannerize("Hello World"); => "helloworld"`

</details>
</details>

---

## __*[Help](/src/Help/)*__
<details><summary></summary>

### <span style="text-decoration: underline">[Help.java](/src/Help/Help.java)</span>
<details><summary></summary>

Contains flag help and some very very short info about whats going on

</details>
</details>

---

## __*[Managers](/src/Managers/)*__
<details><summary></summary>

## __*[Searching](/src/Managers/Searching)*__
<details><summary></summary>

### <span style="text-decoration: underline">[POIs](/src/Managers/Searching/)</span>
<details><summary></summary>

This includes everything except Poi.java  
They all have `wasFound()` which starts giving the player loot and possibly even creating enemies  
Get the loot which player got from the respective poi  

</details>

### <span style="text-decoration: underline">[Poi.java](/src/Managers/Searching/Poi.java)</span>
<details><summary></summary>

Has all the methods to add and colorize the info about loot that player got

</details>

### <span style="text-decoration: underline">[SearchManager.java](/src/Managers/Searching/SearchManager.java)</span>
<details><summary></summary>

Gets a random location and calls its `wasFound()` method

</details>
</details>

### <span style="text-decoration: underline">[BattleManager](/src/Managers/BattleManager.java)</span>
<details><summary></summary>

Manages everything battle related

Contains an arraylist of enemies, integer array containing the counts of enemies and an arraylist of enemy names, that currently exist for the purpose of choose who to attack 

#### _startBattle(int count, int rarity, int specialLocation)_
Clears and the enemy arraylist and fills it with enemies according to count and passes the `specialLocation` and `rarity` to the new enemy  
Next the enemy counts are filled. The index is according to position in [DataAndOtherStuff](###DataAndOtherStuff) in enemy ids string array  
Last the enemies that exist is filled the same way, except the enemy string is not parsed to index  
Absolutely last is [BattleMenu.battleMenu()](####_battleMenu()_) called


#### _enemyAttack()_
Makes all the enemies alive attack the player with a 50% chance to miss  
[BattleMenu.battleMenu()](####_battleMenu()_) is called

#### _playerAttack(int index)_
Attacks a valid enemy, where `index` must be a valid position in the enemies arraylist  
The player has 5% chance to miss

#### _isPlayable()_
Check whether the enemies arraylist isn't empty.  
If it isn't, call [enemyAttack()](####enemyAttack())  
If it is empty, call [endBattle()](####endBattle)  

#### _endBattle()_
clears the enemy arraylist, gives the player xp  

#### _enemyDied(Enemy e)_
When player attacks an enemy, there is a check whether the enemy's hp isnt below zero and when it is, the enemy is sent here to be removed from the enemies arraylist and append xp to be given at the end and add coins  
xp is `[enemyId (position in DataAndOtherStuff)] * (random number <30, 60>)`  
coins are `[enemyId] * (random number <10, 20>)`

#### _defend(boolean usePotion)_
Player may choose to defend themselves instead of attacking and maybe use a potion to heal  
There is a check performed whether the player even has potions to use and use it if player wants  
When the time comes, the player may succeed in defending 50% of the time  
When they succeed, the player may immediately attack  
When they fail, the player will be attacked  

#### _escape()_
Player may choose to escape from a battle with a 33.3% success rate

</details>

### <span style="text-decoration: underline">[Crafting.java](/src/Managers/Crafting.java)</span>
<details><summary></summary>

Print out available upgrades and if player chooses so upgrade items

#### _craft()_
Prints out the current levels of the weapon and armor and gets an input from the user

#### _upgrade(String item)_
The player has choosen to upgrade an item, here a check if performed whether they can upgrade the item (they have enough items or the item isnt max level)  
If the player has enough items, their count is lowered by the required amount and weapon or armor level is increased together with strength or health respectively  
Health goes up as `([currentHP] / 10) * 15`  
Strength goes up as `([currentStrength] / 10) * 15`

#### _getUpgradeCost(String item)_
Returns an array of item prices based on current items level  
Each upgrade takes 3/2 time more than before


</details>

### <span style="text-decoration: underline">[EnemyManager.java](/src/Managers/EnemyManager.java)</span>
<details><summary></summary>

Contains some functions to working with enemies and getting some data from them

#### _getEnemyId(String input)_
Returns an integer based on the enemy's position in `DataAndOtherStuff`  
Includes short names and numbers

#### _getEnemyIndex(String input)_
The player was given a choice from `battleMenu()` and since these don't correspond to their positions in enemies arraylist, the input needs to be converted to actual positions  
When player choose via number, the enemies arraylist is looped through and the first enemy whose string matches the one from the enemiesThatExist on position the player gave is choosen and their position in the enemies arraylist is returned  
When player choose via name, the enemies arraylist is looped through and both the user input and the enemy strings are converted to their relative ids in `DataAndOtherStuff` and the first matches' position in the enemies arraylist is returned  
If any problem occured -1 will be returned

#### _writeEnemies(String how)_
Prints out the existing enemies in format of either  
` > Count Enemy [Stats]`  
or
` Position.> Count Enemy`
based on the `how` argument  
`how` can be either `long` or `short`

</details>

### <span style="text-decoration: underline">[Final.java](/src/Managers/Final.java)</span>
<details><summary></summary>

An extension of [Bathroom.java](/src/Managers/Searching/Bathroom.java), containing modified battle manager for the special case of the final battle

</details>

### <span style="text-decoration: underline">[GameManager.java](/src/Managers/GameManager.java)</span>
<details><summary></summary>

When player dies the player is given a choice to restart  
or when they win, their level can be reset and continue or they can quit  
Also a `missInput()` method is present to tell the player they messed the input

</details>
</details>

---

## __*[MenusAndUIs](/src/MenusAndUIs/)*__
<details><summary></summary>

### <span style="text-decoration: underline"> [ActionMenu.java](/src/MenusAndUIs/ActionMenu.java) </span>
<details><summary></summary>

Gives the player the actions they can perform

#### _mainMenu()_
Tells the player they can
1. Explore for pois
2. Hunt for enemies
3. Open their inventory

#### _inventory()_
Prints out the contents of the players inventory  
and gives the option to go back, open crafting menu and open statistics

#### _statistics()_
Prints out the player kills, coins, xp, level, hp, strength and if they are using cheats then also that they are indeed not playing fair

</details>

### <span style="text-decoration: underline">[BattleMenu.java](/src/MenusAndUIs/BattleMenu.java)</span>
<details><summary></summary>

#### _battleMenu()_
Print out the enemies to the player and give them to option to
1. Attack an enemy
2. Defend and maybe use a potion
3. Escape

#### _chooseEnemy()_
Print out enemies for the player to choose which to attack  
The input is converted via [getEnemyIndex()](####getEnemyIndex()) and check if it isn't -1, if not then proceed attacking the enemy, if it is then call self

#### _defendMenu()_
When player chooses to defend themself, they will be given the option to use a potion and their anwser is passed to battle manager

</details>

### <span style="text-decoration: underline"> [ClassChoose.java](/src/MenusAndUIs/ClassChoose.java) </span>
<details><summary></summary>

Not to be confused with Menu.classChoose()  
Sort of submenu of Menu.classChoose()  
When player chooses something, they are given some info about that class, including option to go back and choose again

When Player is happy with their class, the game proceeds to  
1. Initialize
2. Initialize the player class
3. Start ActionMenu

</details>

### <span style="text-decoration: underline">[Menu.java](/src/MenusAndUIs/Menu.java)</span>
<details><summary></summary>

#### _mainMenu()_
Print some options to the player  
    those being to start the game,  
    print out a little help  
    quit the game  

#### _classChoose()_
Print the 4 available classes to choose from and apply according values to player stats

</details>
</details>