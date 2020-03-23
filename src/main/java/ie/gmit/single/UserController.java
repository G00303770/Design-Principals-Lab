package ie.gmit.single;


/*
Author: Stephen Kilgannon
Student Number: G00303770
Description: Class with one responsibility to crate user
*/

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public class UserController {


    //Handles incoming JSON requests that work on User resource/entity
        //Store used by controller
        private Validate Validate = new Validate();
        private StoreUser storeUser = new StoreUser();
       // private Validate isValidUser = new Validate();

        //Create a new user
        public String createUser(String userJson) throws IOException {
            ObjectMapper mapper = new ObjectMapper();

            User user = mapper.readValue(userJson, User.class);

            if(!Validate.isValidUser(user)) {
                return "ERROR";
            }

            // should storage be happening here
            storeUser.StoreUser(user);

            return "SUCCESS";
        }




}

