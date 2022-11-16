# Frontend/ Website

The frontend of this project was made to make using the api easier and to display the information returned by the api in a nicer way to the user.

## Pages 

There are 4 pages on this website they are seperated depending on what you want to do 

### Admin
The admin is a page that has all of the differn't features of the api on it you can add,delete,get and see the status of the api i.e. is it running and is the roit api key working. This page wil just also simply return the object from the api if you use the get panel and will not display it any differntly unlike the other pages.

For more see [Admin](./Admin/info.md)

### Match

The Match page is for viewing information about a singular match, you will give the page a MatchID in the box that asks for the matchID and then when you hit the search button it will load the page. 

The Loaded page has an overview of the game i.e. what team each player is, their name, what champ they played and other information.

Under the overview there is a widget controller that allows you to view each players stats from the game in a variety of ways you can view the players overall stats at the end of games, at differn't intervals during the game and you can view a leaderboard for all stats in the game and sort in asc and desc orders.

The widget controller allows you to have up to 6 widgets on the page three rows of up to two and you can choose to have one or two widgets in each row.

For more see [Match](./Match/info.md)

### Overall

The overall page is viewing and comparing stats across the database, when the page loads it will load both the total stats of all records and the average stats of all records, it displays overall, sr, aram and all 5 positions for both total and average.

There is also two more parts of the page the first is two stat checkers that allow you to search the average stats after filtering records that allow you to compare stats for example if you wanted to you could compare two players mid lane Varus's in ARAM by entering each players names in the player field, typing Varus in the Champion field for both and only ticking the Mid box in the Postion field and only ARAM box in Gamemode field then hitting go on both stat checkers. 

The last part of the page is called compare team it allows you to apply two stages of filter so for example you could filter it first to be only your games played and then after that you could another filter where the first gets the average of the stats of Yasuo players on your team and the second Yasuo players on the enemy team this will allow you to answer the question whos better teamate Yasuo or enemy Yasuo.

For more see [Overall](./Overall/info.md)

### Player

The Player page is for viewing the stats about a certain player, when the page loads there is only a box asking for a players name after you type in a players name it will then ask then load a Match History, Champion Stats and a Stats area. The Match History Section shows an overview of players games it shows 5 at a time and shows the in order of most recent games it allows you to filter the games it shows using the filters champion and position.

The Champion Stats section allows you to view a players stats on certain champions it will load the players top 10 most played champions at the top and there splash arts you can the click on the splash arts to view a players stats on that champion in overall, sr, aram. Apart from there top 10 champs you can also search for a champion in the search bar and hit Search button to get information about that champ, there is also a show champion button that load the persons champions played list and say how many times they have played the champion overall, in sr and in aram.
 
The Stats widget athe he bottom of the page is a stats section that has shows two widgets you can what widgets it shows with the drop down boxs above the widgets. The three widgets to choose from are Player, Average Teamate and Average Player, the Player widget shows the average stats for player whos name you entered into the page it shows overall,sr,aram and the 5 positions. The Average Team shows the players average teamate in overall, sr, aram and the 5 positions and the Average Player shows the average stats for overall, sr, aram and the 5 position.

For more see [Player](./Player/info.md)