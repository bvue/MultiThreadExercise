package edu.matc.threadexercise;

import java.util.Date;

/**
 * Created by bvue0 on 11/8/2016.
 */
public class TrickOrTreaters implements Runnable{
    String name;
    Date inTime;

    Halloween getCandy;

    public TrickOrTreaters(Halloween getCandy) {
        this.getCandy = getCandy;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public void run() {
        goGetCandy();
    }

    private synchronized void goGetCandy() {
        getCandy.add(this);
    }
}
