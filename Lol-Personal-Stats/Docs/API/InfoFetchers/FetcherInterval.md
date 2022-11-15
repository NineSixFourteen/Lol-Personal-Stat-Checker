# Fetcher Interval
Documentation about this [file](../../../src/main/java/Stats/InfoFetcher/FetchIntervals.java)

## Functions 
- getIntervals(node, matchID, names)
    - A function that takes a JSON node of a timeline and then returns a list of MatchIntervals for every player so a list of a list of MatchIntervals
    - Steps
        - prep 10 matchInterval builder one for each player 
            - give them the players name and match the stats are from 
        - Go through the timeline and look through the frames
            - look at the 11, 16, 21, 31, 36 element as they hold the stats for 10, 15, 20, 30, 35 miniutes 
            - add them to the builders by giving 
                - gold,level,minions,jungle,xp,damagedone
                - (i - 1) is equal to the minute the stats are for 
                - (l) corresponds to the player so you know what builder to give stats to 
            - Look through all of the events that took place 
                - If event type == Champion kill 
                    - get killersId and add a kill 
                        - give the time so the builder knows what match interval to give the kill to 
                    - get VictimId and a death 
                        - give the time so the builder knows what match interval to give the death to 
                    - get list of assistingParticipantsIds and loop through it 
                        - add assists to correct player 