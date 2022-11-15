# Front End 

## Spring 
The front end is made up of multiple classes called controllers these controllers. These are the classes that you put your mapping for each point you want to communicate to the api. <br>
To create points to communicate to the API you typically create a function and map it to an address that a user can visit and give information to. 
```
    @GetMapping("/add/Match")
    public @ResponseBody String index(@RequestParam String id){
        ...
    }
```  

In these functions you also mark if you want it to return anything to the user by marking it @ResponseBody and then what ever you return in the function will be returned as a value for primitive values and as json Object if it is an object.<br>
You Request information from the user by using @RequestParam 
which allows you to ask for a parameter that which the user can provide when the go to the address by adding 
    
        ?param=value&parm2=

where param is the name of the paramater and value is value the user wants to give and then you use a & to input more than one field. <br>
You may also define parameters like below
```
(
    @RequestParam(name = "name", required = true) String name,
    @RequestParam(name = "amount", required = false, defaultValue = "50") String amount
)
```
where you declare if they are required and if they are not you can assign them a default value if the user does not provide one and from there on they act the same way any value passed to a function in java would behave.
## Controllers
The controllers used in this project are 
- [Add Controller]() - which is responsible for adding records to the database 
- [Average Controller]() - which is responsible for returning the average of stats
- [Delete Controller]() - which is repsonsible for deleting records from the database 
- [Get Controller]() - which is responsible for returning data from the databases
- [Pre Controller]() - which is responsible for doing pre calculation whenever the spring server is started and also returning these precalculated values
- [Test Controller]() - which is used for testing purposes and has a ping function to see if the server is up