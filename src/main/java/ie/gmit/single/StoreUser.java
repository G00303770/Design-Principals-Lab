package ie.gmit.single;

/*
Author: Stephen Kilgannon
Description: Class with one responsibility to store the user
Student Number: G00303770
*/

public class StoreUser {
    private Store store = new Store();

    public StoreUser (String user){
        //store.Store(user);

    }

    public StoreUser() {
        // default constructor
    }

    public void StoreUser(User user) {
       store.store(user);
        System.out.println("User = "+user );
    }
}
