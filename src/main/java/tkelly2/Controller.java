package tkelly2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.*;

import java.io.File;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.FileReader;
import java.io.BufferedReader;


import java.io.IOException;

@RestController
public class Controller {

    @CrossOrigin(origins = "http://localhost:8080/beer")
    @RequestMapping("/beer")
    public String index() throws IOException {
        //I use a randomly generated integer to select a corresponding random beer
        double x = Math.round((Math.random()*((6-1))+1)); // use this as an index to fetch the random beer
        String line, data="";

        int count = 1; //initialise a loop counter

        System.out.println("Random index selector: " + x);
        //SECTION TO OPEN BEER DATA FILE
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        //System.out.println("Current relative path is: " + s);
        s = s + "/src/main/java/tkelly2/beers.txt";
        //now s stores the path to current directory
        File file = new File(s);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        //Loop through each line of the txt file
        while((line = br.readLine()) != null){
            //if we reach the line corresponding to the auto-generated random number
            //select this line or beer as the random beer to be returned
            if(count == x){
                System.out.println(line);
                data = data + line + "\n";
                break;
            }
            count++; //increase loop counter
        }
        //at this point, 's' holds the path to the txt file
        //and 'data' holds the beer data pulled from it
        System.out.println("Returning data to client application..." + data);
        return data;
    }
}
