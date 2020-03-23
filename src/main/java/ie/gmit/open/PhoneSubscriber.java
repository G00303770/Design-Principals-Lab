package ie.gmit.open;

/*
Author: Stephen Kilgannon
Student Number: G00303770
Description: A class that extends the super class Subscriber
*/


import java.util.List;

public class PhoneSubscriber extends Subscriber  {



    public double calculateBill() {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(getSubscriberId());
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*getBaseRate()/100;
    }



}