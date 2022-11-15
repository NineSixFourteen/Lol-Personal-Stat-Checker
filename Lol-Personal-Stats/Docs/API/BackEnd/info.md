# Back End

The back end of the api is connected to the mysql database so to add tables we create [repositorys](#repositorys)
but to create one of them we need an [entity](#entitys) which is basically just a class that represents a record in our tables and to create any of these "entitys" we could either use one bigger massive constructor that would have like 30 parameters to and make basically unreadable every time we make the objects or we could use a [builder](#builders) to create these objects steps using differn't functions in the builder which at the very least allows us to write more readable code. 

## Builders
As stated above we use builders for creating objects in multiple steps these means we will have a bunch of funtions that allow us to change the values in the objects we are building and all methods apart from the build() function will return this meaning we can change together a bunch of these functions together like below
```
MatchHistoryBuilder mhb = new MatchHistoryBuilder();
mhb.setID(0)
 .setWinner("red")
 .setSomething(true);
```
and then when we want the finished object we are building we use the build() function to get the object. For more info see [Builders](./Builders.md).

## Entitys

Entitys are the class represntation of records for each table so for every field in the class spring will create a field in the table where the value from the object can be stored when its saved to a repository.

Entitys can also include code that looks like this 
```
@NamedQuery(name = "MatchOverall1.findByMatchIDAndName",
query = "select h from MatchOverall1 h where h.MatchID = ?1 AND h.Name =?2")
```
This is writing a query that can be used as a function on the repository of the entity. It simple reads as get all records (select h) from the table (from MatchOverall1 h) where MatchId equals the first paramater the function (where h.MatchID = ?1)
and where name equals the second parameter (AND h.Name =?2) so later when you call the function it would look like this
```
.findByMatchIDAndName("EUW1_11111111", "player")
```
and that will return all records in a list where the record matchID = EUW1_11111111 and name = player
## Repositorys

Repositorys are what represent tables in your database so when you create a repository and put it in a [controller](../FrontEnd/Controllers/AddController.md) and start the spring server it will create the table in the database for you if one doesn't already exist.<br>
When creating a repository you simple extend one of the existing repository in spring but give it an entity for the table.
```
    public interface MatchHistoryRespository extends CrudRepository<MatchHistory,Integer> {
``` 
Integer is to represent the id field in the table which is auto generated <br>
you then give it a list of functions such as findByMatchID(String Matchid) and spring will auto generate these functions or you can write a query in the entity that corresponds to the function <br>
see [Repository](Repository.md)

## Other

Other is classes that store data in format that we want to return data to the user in.

see <br>

- 


