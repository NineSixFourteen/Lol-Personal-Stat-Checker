# Builders
We use builders for creating objects in multiple steps these means we will have a bunch of funtions that allow us to change the values in the objects we are building and all methods apart from the build() function will return this meaning we can change together a bunch of these functions together like below
```
MatchHistoryBuilder mhb = new MatchHistoryBuilder();
mhb.setID(0)
 .setWinner("red")
 .setSomething(true);
```
and then when we want the finished object we are building we use the build() function to get the object. 

There is a correspending builder for each entity that we have to create apart from MathcOverallBuilder that create MatchOverall1 and MatchOverall2 as there is overlap in the information they store. 