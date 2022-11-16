# Add Panel 

This panel is to give access to the api functions that can add records into the database 

Documentation about this [file](../../../frontend/src/Admin/AddPanel.js)

## Buttons 

There are 2 buttons in this panel one for adding a match and one for adding a player.

### Add Match 

The add match displays 
1. Text field 
2. Button 

When the button is pressed fetch command to the server at /add/Match?id= + the text inside the text box this is equivalant to if when to the address in your browser. This will cause the api to get records for this match and them to database see this [file](../../API/FrontEnd/Controllers/AddController.md) for more info on how they are added.

### Add Match 

The add player displays

1. Text field called player
2. Text field called amount
3. Button

When the button is pressed fetch command to the server at add/Player?name={the value in player}&amount={the value in amount}. This will cause the api to get a list of this players recent games and add the amount requets to the database see this [file](../../API/FrontEnd/Controllers/AddController.md) for more info on how they are added.