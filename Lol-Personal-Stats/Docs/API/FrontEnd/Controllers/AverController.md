# Average Controller 

Documentation about this [file](../../../../src/main/java/Stats/FrontEnd/AverController.java)

# Mapping

- /average/ChampGames, [Function]() - This is responsible for returning the average stats for a player playing a champion
    - Fields
        - Player Name
        - Champion
    - Returns
        - List
            - Overall 
            - SR 
            - ARAM 
- /average/PlayerPosition, [Function]() - This is respnsible for returning average stats of a player in differn't positions 
 - Fields
    - Player Name
 - Returns
    - List
        - Overall 
        - SR 
        - ARAM
        - Top
        - Jungle
        - Mid 
        - Adc 
        - Support
- /average/Player/Team, []() - This is responsible for returning average stats of a players teamates
    - Fields
        - Player Name
    - Returns
        - List 
            - Overall
            - SR
            - ARAM
            - Top
            - Jungle
            - Mid 
            - Adc 
            - Support
- /average/Stats, []() - This is responsible for returning the average stats after filtering all games 
    - Fields / Filters
        - Player name
        - Champions Played
        - Postions Played
        - Game Modes 
    - Returns 
        - List
            - Overall
            - SR
            - ARAM
            - Top
            - Jungle
            - Mid 
            - Adc 
            - Support
- /average/Team, []() - This is responsible for returning the average stats after filtering all games twice 
    - First Filter 
        - Player name (required)
        - Champions Played
        - Postions Played
        - Game Modes 
    - Second Filter i.e. filters applied to games left after first filters  
        - Team or Enemy
        - Player name (not required)
        - Champions Played
        - Postions Played
        - Game Modes 

## Functions 

- getChampGames(name, champ)
    - Steps 
        - Find all Match data about the player in using overall1.findByName(name) and overall2.findByName(name)
        - loop through all match records and add them to an a [averageMatch]() instance if they are playing the champion and seperate by if they are playing in ARAM or SR. 
            - They are playing ARAM if they don't have a position so if
            ```m1s.get(i).getPosition().trim().length() != 0 ``` <br> is true they are playing SR if false they are playing ARAM
        - Find average by using build()
        - return average for overall, SR, ARAM
- getPlayerPosition(name)
    - Steps 
        - Find all Match data about the player in using overall1.findByName(name) and overall2.findByName(name)
        - prepare list of [averageMatch]() 
        - look through all records and the data to [averageMatch]() depending on what position they are playing 
            - see getChampGames() to how see how gamemodes are detrmined
        - Find average by using build()
        - return Overall, SR, ARAM, Top,Jungle,Mid,Adc,Supp
- getPlayerTeam(name)
    - Steps 
        - Find all the match ids a player has been in 
        - prepare list of [averageMatch]() 
        - For every match they have been in 
            - Find all player records for that match
            - Find the team the player played in that match
            - Go through all records for that match
                - if they are on players team but not the player 
                    - add there data to an [averageMatch]() based on position 
                    - see getChampGames() to how see how gamemodes are detrmined 
        - Find average by using build()
        - Return Overall, SR, ARAM, Top,Jungle,Mid,Adc,Supp
- getStats(name,champion,position,gamemodes)
    - Steps
        - if name == all 
            - add all games 
        - else 
            - use findByName(name) to filter to only records with that name
        - if champ == all
            - do nothing
        - else
            - spilt champ on "," to make a list of champion names
            - use [filter]() to filter records to only ones with these champs
        - repeat for position and gms 
        - for all remaining records 
            - find corresponding match2 for every match1 
            - add them to an [averageMatch]() 
        - find average with build()
        - return average
- getTeam(name, champion, postion, gamemodes, team, otherName, otherChampion, otherPosition, otherGamemodes)
    - do all the steps from getStats(...) up until for all ..
    - get match ids for all records remaining
    - for ever match
        - find the side that $name played on   
        - check if record is on the correct side 
            - if $team == false its other side of $name if true its the same side
        - check if record fits new filters 
        - if it does add to an [averageMatch]() instance 
    - find average with build()
    - return average

                    


