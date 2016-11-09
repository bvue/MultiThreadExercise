package edu.matc.threadexercise;

import org.apache.log4j.Logger;

/**
 * Created by bvue0 on 11/8/2016.
 */
public class Riley implements Runnable{
    private final Logger logger = Logger.getLogger(this.getClass());

    Halloween getCandy;

    public Riley(Halloween getCandy) {
        this.getCandy = getCandy;
    }
    public void run() {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        logger.info("Trick or treating has begun!");
        while(true)
        {
            getCandy.candyTime();
        }
    }

}
