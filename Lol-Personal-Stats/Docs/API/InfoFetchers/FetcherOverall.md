# Fetch Overall 
Documentation about this [file](../../../src/main/java/Stats/InfoFetcher/FetchOverall.java)

## Functions 

- getPlayers(node)
    - Function takes a json representing a match and returns a 10 objects of [MatchOverall](../BackEnd/Other.md)
    - Steps
        - gets MatchId from node 
        - Loops through json array of objects called particapantes
            - Gets players with getPlayer(node,matchId)
        - returns list 

- getPlayer(node, matchId)
    - Function that builds a [MatchOverall](../BackEnd/Other.md) from a node by looking through its fields and matching them to fields in MatchOverall 1 and 2 then returns built object 
    - Steps 
        - Uses builder functions to add data from the node and its sub node "challenges" which contain info about a player performed 
        - return built object
        - some fields maybe null so if they are set to 0 
