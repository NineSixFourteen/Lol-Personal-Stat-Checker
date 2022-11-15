# Pre Controller 

Documentation about this [file](../../../../src/main/java/Stats/FrontEnd/DeleteController.java)

## Mapping
- /pre/Pos - This is responsible for returning the total stats across all records in the db
    - No Fields
    - Returns List
        - Overall 
        - SR 
        - ARAM
        - Top
        - Jungle
        - Mid 
        - Adc 
        - Support

- /pre/averagePos - This is responsible for returning the average stats across all records in the db
    - No Fields
    - Returns List
        - Overall 
        - SR 
        - ARAM
        - Top
        - Jungle
        - Mid 
        - Adc 
        - Support

## Functions 

- getPos()
    - returns list of total stats

- getAveragePos()
    - finds average of all [averageMatch](../../BackEnd/Other.md) using build()
    - returns list of average stats

- doSomethingAfterStartup()
    - Function will run on startup of the api server
    - Finds every match id in the db 
    - preps list of [averageMatch](../../BackEnd/Other.md) 
    - For every match 
        - Checks to see if there is a issue with a match 
            - if there is delete it
            - else add it an [averageMatch](../../BackEnd/Other.md) based on position/gamemode
                - if positions == "" then aram else sr 