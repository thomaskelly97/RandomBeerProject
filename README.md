# RandomBeerAPI
A simple web app that displays information about random beers. 

## Part 1 - The REST API <br />
###### MainApplicationClass.java
###### Controller.java 
###### beers.txt 
The implementation for the API is written in Java and uses Spring Boot. It consists of two main files, 
a MainApplicationClass.java and a Controller.java to listen to and manage incoming requests. <br />
A `beers.txt` file is used to mimic the presence of some sort of storage structure or database for the different beers. <br />
When the API receives a request, a random number is generated between 1 and the number of beers in the txt file which is then used 
to select a random beer. This is then returned to the client as a string. <br />

## Part 2 - User Interface <br />
###### client.html 
The client-side UI was built using HTML and Vue.js. 
Clicking the button will invoke the Fetch API which sends a HTTP GET request to the Beer API running on Spring Boot on port 8080. <br />
Upon successfully communicating with the server-side, this request will return a promise enabling access to the response to the GET request, which is then updated in the HTML DOM with Vue. <br />
<br />
<br />



