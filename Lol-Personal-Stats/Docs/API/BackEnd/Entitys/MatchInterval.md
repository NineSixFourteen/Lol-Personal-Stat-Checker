# Match Interval
The Table that represents a player stats at differnt intervals during a game 

## Fields
- id(int) - auto generated unique id (PK)
- name(String) - name of the player
- matchId(String) - id for the player
- time(int) - time in the game that these stats are for 
- kills(int) - kills at $time
- deaths(int) - deaths at $time
- assists(int) - assists at $time
- damageDone(int) - the amount of damge dealt to champions at $time
- level(int) - the level the player is at $time minutes
- minions(int) - the numer of minions this player killed at $time
- jungle(int) - the numer of jungle monsters this player killed at $time
- xp(int) - the amount of experience this player has at $time
- gold(int) - the amount of total gold this player has at $time