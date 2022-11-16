# Compare Stats 

This [file](../../../frontend/src/Overall/comps/CompareStats.js) just a compent that will create a [card] and place two of the component [Compare](#compare) in a row 

## Compare

This [file](../../../frontend/src/Overall/comps/Compare.js) is responsible for providing a ui for the user to query the database and receive the average of records after filtering to the records they want and then getting the average from them. It also displays the result of the query below the ui. 

The fields you can filter by are 

1. Player 
This means only include records that are about the players entered
2. Champion
This means only include records that are about the champions entered
3. Position 
This means only include records where they are playing one of the positions ticked 
4. This means only include records where the game it is from is of one the selected gamemodes

For Player and Champion you can include more than one if you include a comma bewteen them e.x Varus, Leona, Yuumi