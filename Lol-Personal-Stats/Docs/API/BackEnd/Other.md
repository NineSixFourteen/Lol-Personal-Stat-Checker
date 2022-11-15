# Other 
Other is a folder that stores format that the api returns information in as they will be converted to json.

## Average Match
Average Match is that is like MatchOverall but has two extra functions that are add() and build() these function allow you to total up the stats of multiple records and if you want to find the average you can use build() which will create a new AverageMatch that has the average of all of the records stored in it.
## MatchOverall
A class that stores both a MatchOverall1 and MatchOverall2 object inside of it
## MatchRecord
A class that stores all the information about a match this includes the MatchHistory object, 10 Match Overall objects one for each player and up to 50 MatchInterval Objects up to 5 for each player 
## PlayerRecord
A class that stores all the objects for a give player from a match this include a Match Overall Object and up to 5 Match Intervals objects. 