package rodents;

import java.util.Random;

/**
 * Created by Dmitriy on 03.12.2019.
 */
class RandomRodentGeneration {
    private Random rand = new Random(47);
    public Rodent gen() {
        switch (rand.nextInt(2)) {
            default:
            case 0: return new Mouse();
            case 1: return new Hamster();
        }
    }
}
