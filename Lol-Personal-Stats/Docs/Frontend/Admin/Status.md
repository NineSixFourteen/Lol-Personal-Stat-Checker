# Add Panel 

This panel tells you if the server is currently running and if the riot api key is working. The text will be green if its working and red if it is not

Documentation about this [file](../../../frontend/src/Admin/OtherPanel.js)

There is also a refresh button to recheck the server and key

## Server Running 

It send a fetch to /ping and if the response is pong then we know the server is running anything else and it is not

## Riot Api Key 

It sends a fetch to add/test which will test the current api key on riots api if it succedes we know the key is working if it fails the key is not
