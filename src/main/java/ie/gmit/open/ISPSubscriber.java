package ie.gmit.open;

/*
Author: Stephen Kilgannon
Student Number: G00303770
Description: A class that extends the super class Subscriber
 */

import java.util.List;

public class ISPSubscriber extends Subscriber {



    private long freeUsage;

    public ISPSubscriber() {
        super ();

    }

    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(getSubscriberId());
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*getBaseRate()/100;
    }


    /**
     * @return the freeUsage
     */
    public long getFreeUsage() {
        return freeUsage;
    }

    /**
     * @param freeUsage the freeUsage to set
     */
    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    
}