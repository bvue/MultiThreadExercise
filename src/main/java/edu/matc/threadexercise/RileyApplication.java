package edu.matc.threadexercise;

/**
 * Created by bvue0 on 11/8/2016.
 */
public class RileyApplication {
    public static void main(String a[]) {
        Halloween getCandy = new Halloween();

        Riley riley = new Riley(getCandy);
        TrickOrTreaterGenerator tt = new TrickOrTreaterGenerator(getCandy);

        Thread thbarber = new Thread(riley);
        Thread thcg = new Thread(tt);
        thcg.start();
        thbarber.start();
    }

}
