# Overview 

The overview is to provide to the user an overlook at what happend in the game without showing alot of stats. 

The only stats it shows are the ones that can cleary indicate how the game went they are

- Kills
- Deaths
- Assists
- KDA 
- Vision Score

It also shows the position they played, the team and the champion via the champions splash art 

## Files 

- [PlayerTop](../../../frontend/src/Match/comps/PlayerTop.js)

This file is responsible for creating each of the cards shown in the Overview section you pass it a players [MatchOverall](../../API/BackEnd/Other.md) and it absracts the stats and formats.