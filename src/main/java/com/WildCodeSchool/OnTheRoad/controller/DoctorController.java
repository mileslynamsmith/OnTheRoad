package com.WildCodeSchool.OnTheRoad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.core.sym.Name;

@Controller
public class DoctorController {
    String [] name = { "n/a", "William Hartnell", "Patrick Troughton","Jon Pertwee","Tom Baker",
    "Peter Davison","Colin Baker", "Sylvester McCoy","Paul McGann","Christopher Eccleston", "David Tennant",
    "Matt Smith","Peter Capaldi","Jodie Whittaker"};
    // create route for /doctor/number (this is the url!!!)
    @RequestMapping("/doctor/{number}")
    @ResponseBody
    // request parametre for number 
    public String getDoctorWho(@PathVariable Integer number) {
        // if the number is between 1 and 8 then return a 303 status
        if (number > 0 || number < 9){
            throw new ResponseStatusException(HttpStatus.SEE_OTHER, "303 See other. Impossible to retrieve the incarnation number" + number);
        } 
        // if the number is not between 1 and 13 then return 404
        if  (number > 8 && number < 14){
            //what does the the below means and where is this syntax shown in the quest
            // Format to return: { "number": 13, "name": "Jodie Whittaker" }
            return "{ \"number\": " + number + ", \"name\": \"" + name[number] + "\" }";
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 Not found.");
    }

}

// x > y        x larger than y
// x < y        x smaller than y