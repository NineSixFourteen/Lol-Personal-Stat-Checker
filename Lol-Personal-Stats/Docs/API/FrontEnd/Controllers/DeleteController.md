# Delete Controller 

Documentation about this [file](../../../../src/main/java/Stats/FrontEnd/DeleteController.java)

## Mapping
- /delete/Match- This will delete all records about a match in the data base
    - Fields
        - Match id 
    - returns  "Match has been deleted";

- /delete/Player - This will delete all records about a player in the database
    - Fields
        - Player name
    - Returns
        - Message about how matches records where deleted

- /clean - This is reponible for cleaning up the data in the database i.e. delete all duplicate matches and remove any errors data 
    - No Fields
    - Returns   
        - Message saying complete

# Functions 

- deleteMatch(id)
    - Steps
        - use deleteRecords(id) to delete record
        - returns message saying done

- deletePlayer(name)
    - Steps
        - Finds matches the player has been in 
        - iterate through list of matches 
            - delete match using deleteRecords(id) give it the match id

- clean()
    - Steps
        - Loops through every match in the database 
            - Adds match id to a list 
            - If any match is already in the list adds to a list of dup games
            - Delete all instances of duplicate matches in the database using deleteRecords(id)
            - Deletes all null records using deleteNulls();
            - Adds all games in the duplicate match list back to the database so there is only one set of records in the database now
        - return message saying done

- deleteNulls()
    - Steps
        - Loops throught all records in the database 
            - if matchId == null
                - deletes records

- saveGame() and addGames()
    - Does same as saveGame() from the [Add Controller](./AddController.md)

- deleteRecords(id)
    - Loops through all recrods
        - if records match id == $id 
            - delete record
