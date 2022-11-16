# Widgets

The widgets on this page are two allow you to view the stats of all the players in a game to see how they performed. There are also created in a way that allows you to be flexible to how many of Stats/Leadboard widget you want allowing one or two widgets per row up to 3 rows. 

## Files 

1. [Leadboard](../../../frontend/src/Match/comps/LeaderBoard.js)

This file is responsible for creating the leaderboard section in the widget. It allows you to view what players achieved in differn't stats in either Ascending or Descending order. It takes the list of players [PlayerRecord](../../API/BackEnd/Other.md) and abstracts a value when a field is selected via the dropdown menu and places in map with the players name, it then sorts this and displays the sorted map to screen 

2. [Stats](../../../frontend/src/Match/comps/Stats.js)

This file is responsible for displaying the stats of the selected player at the end of the game in a formated table with two columns it displays all stats that are the [MatchOverall](../../API/BackEnd/Other.md) 

3. [Widges](../../../frontend/src/Match/comps/Widges.js)

This file is responsible for combing the above two into a single Card that can be toggled bewteen the two formats for displaying information. It has a button for each option that when clicked will swap to that option.

4. [playerIntervals](../../../frontend/src/Match/comps/playerInterval.js)

This file is responsible for showing the stats of a player at certain intevals through out the game it allows you to toggle which intervals you want to see. It is paired with the listed above file Stats and allows you to switch between looking at stats at end of game or at intervals. Contains less stats that at the end of a game

5. [StatsRow](../../../frontend/src/Match/comps/StatsRow.js)

This file is responsible for allowing you to controll how many of the widgets you want displayed on the webpage i.e. how many rows and do you want one or two in a row.