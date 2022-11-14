# Setup Guide 
This is a set up guide to get the project working after you install from github.
## Files Needed 
You will need to add the following files to the project to make it work. 
1. src\main\resources\application.properties
2. src\main\java\Stats\FetchSystem\Helpers\GetInfo.java
<br>

You will need to create these files and make sure you add them to ./gitignore 
as you do not want to upload these to any source controlls as they will contain personal information. <br>
Below is a template of both files 

src\main\resources\application.properties
```
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/#DBName
spring.datasource.username=#UserName
spring.datasource.password=#Password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
This files is what connects the spring application to the db where the match data is stored. You will enter the name of your data base at #DBName aswell username at #UserName and the password to the db at #Password. This requries you to already a have a mysql db running on localhost if you don't have a db running I would go to the following links.<br>

&nbsp; Sever: https://dev.mysql.com/downloads/mysql/ <br>
&nbsp; Tools:  https://www.mysql.com/products/workbench/ 

Those links will take you where to install a server a tool to use the server.

src\main\java\Stats\Other\GetInfo.java
```
package Stats.FetchSystem.Helpers;

public class GetInfo {

    public static String getAPIKey(){
        return "";
    }

    public static String getPUUID(){
        return "";
    }

    public static String getAccountID(){
        return "";
    }

    public static String getID(){
        return "";
    }
}
```

Above you will just fill out the information about your account your account. <br>
The only one you have to fill out is <span style="color:tan">getAPIKey() </span> but the others can be helpful when doing testing. If you do not have the above information you can get it from the following links.

APIKey : https://developer.riotgames.com/ <br>
IDS : https://developer.riotgames.com/apis#summoner-v4/GET_getBySummonerName

You will need to be signed into a league account get a api key and enter your summoner name in the summmonerName field to get your ids.

NOTE :  You will have to get a new API key every 24 hours as thats how long the keys last if you want a longer key you will have to apply to riot for one.