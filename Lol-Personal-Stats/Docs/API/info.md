# API 
The API is responsible for returning the information that is stored in the database in a formatted way when the user request its.

# Table of Contents
  * [Front End](#front-end)
  * [Back End](#back-end)
    + [Tables](#tables)
    + [Builder and Other](#builder-and-other)
  * [Info Fetchers](#info-fetchers)


## Front End 
The front end of the api i.e. the part the user interacts with is built using Spring Boot and is responsible for listening on localhost:8080 for activity at specific urls where it takes information and then returns the correct information based on information in the url

Examples <br>
src\main\java\Stats\FetchSystem\Controllers\TestController.java
```
    @GetMapping("/ping")
    public @ResponseBody String ping(){
        return "pong";
    }
```
The above code makes it so when someone goes to localhost:8080/ping the api will then return "pong" which if they are in a browser will return a webpage with just pong or if someones uses a tool like curl will just pring pong in the console. This is used to test if the server is running.

For more see
- 1 [Front End Info](./FrontEnd/info.md)

## Back End 
The backend of the API is the MYSQL DataBase that all the information we get from the riot servers is stored.<br>
We Connect the Database to spring boot by setting it to a data source in out application.properties that we talked about in [setup.md](../Setup.md). <br>
### Tables 
The tables used for storing data are 
1. Match History 
    <br>&emsp;
    Stores information about each game such as length and data
    <br>&emsp;
    Only one of there per game saved
2. MatchOverall1 
    <br>&emsp;
    Stores the primary information about a player for each match <br>&emsp; i.e. player name, champion, kills, deaths, etc
    <br>&emsp;
    Stores Ten of these a game one for each player 
3. MatchOverall2
    <br>&emsp;
    Stores other information about a player for each match 
    <br>&emsp; i.e. player name, dodged skills shots, peak cs lead
    <br>&emsp;
    Stores Ten of these a game one for each player 
3. MatchInterval
    <br>&emsp;
    Stores information about a player for each match at certain intervals 
    <br>&emsp; i.e. time, player name, kills, deaths
    <br>&emsp;
    Stores up to 50 of these a game one for each player at intervals 
    <br>&emsp; of 15,20,25,30,35

There is a matching class in the Entitys [folder](../../src/main/java/Stats/BackEnd/Entitys/) for each of there table that represent a record in these tables.<br>
This is also a matching a matching class in the Repository [folder](../../src/main/java/Stats/BackEnd/Repository/) that represents the table in the database. <br>These repositorys are CRUD repositorys that gives us the ability to Create, read,update and delete records from the table inside of our programs. See [Repository] for more info.

### Builder and Other 
These are just classes that are used to for help building the objects that will become records in our tables and other contains potential ways we might want to represent the data to the user for example [AverageMatch](../../src/main/java/Stats/BackEnd/Other/AverageMatch.java) which is usefull when we want to get the average of stats for a match(it really does player data its not  named well #TODO).

## Info Fetchers
These are the classes that will interact with the riot api to retrieve the data you want to add to your database.

To see more about them go to there own pages <br>
[Fetcher](/Docs/API/InfoFetchers/Fetcher.md) <br>
[FetcherIntervals](/Docs/API/InfoFetchers/FetcherInterval.md) <br>
[FetcherMatchHistory](/Docs/API/InfoFetchers/FetcherHistory.md) <br>
[FetcherOverall](/Docs/API/InfoFetchers/FetcherOverall.md) <br>