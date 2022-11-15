Repositorys are what represent tables in your database so when you create a repository and put it in a [controller](../FrontEnd/Controllers/AddController.md) and start the spring server it will create the table in the database for you if one doesn't already exist.<br>
When creating a repository you simple extend one of the existing repository in spring but give it an entity for the table.
```
public interface MatchHistoryRespository extends CrudRepository<MatchHistory,Integer> {
``` 
Integer is to represent the id field in the table which is auto generated <br>
you then give it a list of functions such as findByMatchID(String Matchid) and spring will auto generate these functions or you can write a query in the entity that corresponds to the function.
<br> 
For Example if this in the entity for the repository 
```
@NamedQuery(name = "MatchInterval.findByMatchID",
  query = "select h from MatchInterval h where h.MatchID = ?1")
```
You would add the function 
```
List<MatchInterval> findByMatchID(String id);
```


