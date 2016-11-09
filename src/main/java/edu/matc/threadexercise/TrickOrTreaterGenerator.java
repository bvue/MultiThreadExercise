package edu.matc.threadexercise;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by bvue0 on 11/8/2016.
 */
public class TrickOrTreaterGenerator implements Runnable{
    Halloween getCandy;

    public TrickOrTreaterGenerator(Halloween getCandy)
    {
        this.getCandy = getCandy;
    }

    public void run()
    {
        while(true)
        {
            TrickOrTreaters kid = new TrickOrTreaters(getCandy);
            kid.setInTime(new Date());
            Thread th_kid = new Thread(kid);
            kid.setName("Kid Thread "+th_kid.getId());
            th_kid.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }
}
