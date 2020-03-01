package rodents;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Dmitriy on 03.12.2019.
 */
public class RodentMain {
    public static void main(String[] args) {
        Rodent r[] = new Rodent[6];
        RandomRodentGeneration rg = new RandomRodentGeneration();
        for(int i=0; i < r.length; i++) {
            r[i] = rg.gen();
        }
        for(int i=0; i < r.length; i++) {
            System.out.println(r[i]);
            r[i].eat();
            r[i].run();
            System.out.println("------");
        }

        System.out.println("***");
        ArrayList<Rodent> rodents = new ArrayList<Rodent>();
        for(int i=0; i<10; i++)
            rodents.add(rg.gen());
        Iterator<Rodent> it = rodents.iterator();
        while(it.hasNext()) {
            Rodent rodent = it.next();
            System.out.println(rodent);
        }

    }
}
