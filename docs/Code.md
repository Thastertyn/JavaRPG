Hopefuly a useful explanation of whats going on with pseudocode

paths are as __*/foo/bar*__ (bold and italic), while filenames are <span style="text-decoration: underline">foo.java</span> (underlined) and fucntions _foo()_ (italic)
<br>

### <span style="text-decoration: underline">[App.java](/src/App.java)</span>
<details><summary></summary>

Works as Main class  

_main()_  
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
</details>

---

## __*[MenusAndUIs](/src/MenusAndUIs/)*__
<details><summary></summary>

### <span style="text-decoration: underline">[Menu.java](/src/MenusAndUIs/Menu.java)</span>
<details><summary></summary>

#### _mainMenu()_
Print some options to the player  
    those being to start the game,  
    print out a little help  
    quit the game  

#### classChoose()
Print the 4 available classes to choose from and apply according values to player stats

</details>

---

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