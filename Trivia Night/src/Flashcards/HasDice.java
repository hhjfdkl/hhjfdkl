package Flashcards;

import java.util.Random;

public interface HasDice {

    default int roll(int max)
    {
        if(max==1)
            return 0;
        return new Random().nextInt(max-1);
    }
}
