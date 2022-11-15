# Fetch Histroy 

Documentation about this [file](../../../src/main/java/Stats/InfoFetcher/FetchMatchHistory.java)

## Functions 

- getHistory(node)
    - Function that takes a json node representing a match and builds a [MatchHistory](../BackEnd/Entitys/MatchHistory.md) object and returns it
    - Steps
        - Grabs fields for the objects from the node and adds them to the builder 
        - returns object using build()

- getLength()
    - Function that takes a start time and end time as longs 
    and returns the number of seconds bewteen them 
    - Steps 
        - Takes away start from end 
        - divided by 1k as there is 1k frames in a second 

- getDates(long creation)
    - Function that takes when the game is created return the number of days since january first 
    - Steps 
        - Takes up all time before januray 1st 2022
        - divide by 86400000 as thats how many frames there are in a day
        - convert result to a int and return it this could be an issue in a very long time if the number of days past 2147483647 but I will fix it a week before then :)