package edu.matc.threadexercise;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by bvue0 on 11/8/2016.
 */
public class Halloween {
    int maxKids;
    List<TrickOrTreaters> listKid;
    private final Logger logger = Logger.getLogger(this.getClass());

    public Halloween() {
        maxKids = 10;
        listKid = new LinkedList<TrickOrTreaters>();
    }


    /**
     * The process of Riley giving out candy
     */
    public void candyTime() {

        TrickOrTreaters kid;

        synchronized (listKid) {

            while(listKid.size()==0)
            {
                logger.info("Riley is watching TV.");
                try
                {
                    listKid.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            logger.info("Riley hears the doorbell and answers the door.");
            kid = (TrickOrTreaters)((LinkedList<?>)listKid).poll();
        }

        long duration=0;
        try {
            logger.info("Giving candy to: "+kid.getName());
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        logger.info("Done giving candy to: "+kid.getName() + " in "+duration+ " seconds.");
    }





    public void add(TrickOrTreaters kid)
    {
        logger.info("Kid : "+kid.getName()+ " rings the door bell.");

        synchronized (listKid)
        {
            if(listKid.size() == maxKids)
            {
                logger.info("Kid, "+kid.getName()+ ", moves on because there are more than 10 trick or treaters at Rileys door.");
                return ;
            }
            ((LinkedList<TrickOrTreaters>)listKid).offer(kid);
            logger.info("Kid : "+kid.getName()+ " gets candy.");
            if(listKid.size()==1)
                listKid.notify();
        }
    }
}
