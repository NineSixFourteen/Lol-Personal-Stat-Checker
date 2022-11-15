# Fetcher 
Documentation about this [file](../../../src/main/java/Stats/InfoFetcher/Fetcher.java)

## Functions 
- getGames(puuid,amount)
    - Function that takes the puuid(unique id) of a player and the amount of games you want from this person 
    - Steps 
        - Creates a HttpUrlCoonection (equivalnet to fetch() in js)
        - addes api key to request 
        - gets response and puts in string
        - creates json object of response 
        - loops throught every object an json array
            - converts to text(it is just a matchID)
            - adds to list
        - returns list with players last $amount of games

- getMatchRecords(matchID)
    - Function that takes a matchID then returns an [MatchRecord](../BackEnd/Other.md) with all match information it.
    - Steps 
        - gets JSON with all match information in it from getMatch($matchID)
        - checks its not null
            - returns null if it is as it has failed
        - gets MatchHistory from [fetchMatchHistory](./FetcherHistory.md)
        - gets overall from [fetchOverall](./FetcherOverall.md)
        - gets list of names from overall 
        - getIntervals from [fetchInterals](./FetchInterval.md) and [Helper]()
        - Creates MatchRecord object and returns it

- getMatch(matchID)
    - Attempts to get JSON version of a game from riot api 
    - Steps         
        - Creates a HttpUrlCoonection (equivalnet to fetch() in js)
        - addes api key to request 
        - gets response and puts in string
        - creates json object of response 
        - returns json object

- getTimeLine(matchID)
    - Attempts to get JSON version of a gamesTimeline from riot api 
    - Steps
        - Creates a HttpUrlCoonection (equivalnet to fetch() in js)
        - addes api key to request 
        - gets response and puts in string
        - creates json object of response 
        - returns json object

- test()
    - Used to test if riot api key is working 
    - Steps 
        - Creates a HttpUrlCoonection (equivalnet to fetch() in js)
        - addes api key to request 
        - gets response and puts in string
        - returns true; 
        - returns false if any of the above fails and causes an exception i.e. if the request failse

- puuid(name)
    - Used to get a players puuid
    - Steps 
        - Creates a HttpUrlCoonection (equivalnet to fetch() in js)
        - addes api key to request 
        - gets response and looks for field called puuid and returns it as text