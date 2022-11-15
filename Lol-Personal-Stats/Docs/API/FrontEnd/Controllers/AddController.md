# Add Controller 

Documentation about this [file](../../../../src/main/java/Stats/FrontEnd/AddController.java)

## Mapping 

- /add/Match, [function]() - This is reponsible for adding a matcht to the database 
    - Fields 
    - Match ID - The id of the match that you want to add 
    looks like EUW1_6151208976
- /add/Player, [funtcion]() - This is repsonsible for adding recent games that a player has played. 
    - Fields 
    - Player Name 
    - Number of games 
- /add/test, [function]() - This test to see if the riot api key is currently working
    - No Fields 

## Functions 

- Index(id) 
    - Steps 
        - Fetch Match data using [Fetcher]() and the id
        - Check object to make sure it didn't fail
        - Save Match History to repository
        - Save Player data to repositorys
- AddPlayer(name, amount)
    - Steps 
        - Try and parse amount to an int 
            - if fails then set to 50
        - Test key to see if workds
        - Fetch player puuid using [Fetcher]() using name
        - Fetch a list of players recent matches
        - Check there is enough games played 
            - if there is not only adds as many games as player has played
        - Add games to db using addGames(playerGames, amount)
- addGames(playerGames, amount)
    - Steps
        - Iterates through playerGames list until added the amount of matches requested
            - Save game to db using saveGame(id)
                - Does what Index does but returns false if it fails and true if succes
            - If false pauses for a minute as likely cause is that the to much data has been requested by the api key and is blocked for a minute
            - Trys again to add save match
            - If fails 4 times skips match
- addTest()
    - Steps 
        - Test key using [Fetcher]()
        - Returns "Key is working" if true 
        - Returns "Key is not working" if false