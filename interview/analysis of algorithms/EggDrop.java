/**
 * Egg drop. Suppose that you have an n-story building (with floors 1 through n) 
 * and plenty of eggs. An egg breaks if it is dropped from floor T or higher and 
 * does not break otherwise. Your goal is to devise a strategy to determine the 
 * value of T given the following limitations on the number of eggs and tosses:

Version 0: 1 egg, ≤T tosses.
Version 1: ∼1lgn eggs and ∼1lgn tosses.
Version 2: ∼lgT eggs and ∼2lgT tosses.
Version 3: 2 eggs and ∼2n√ tosses.
Version 4: 2 eggs and ≤cT−−√ tosses for some fixed constant c.
 */

public class EggDrop {
    public int VersionZero(int n) {
        for (int i = 1; i <= n; i++)
        //until the egg breaks. T = i;
    }
    public int VersionOne(int n) {
        //perform binary search
    }
    public int VersionTwo(int n) {
        //2^t t = 0, 1, 2 .....until the egg breaks.
        //so the breaking-floor is between 2^(t-1) and 2^t.
        //Then perform the binary search between 2^(t-1) and 2^t;
    }
    public int VersionThree(int n) {
        //i = 1, sqrt(n), 2sqrt(n) ......until the egg breaks;
        //if egg breaks on floor t;
        //start at floor t-1 and toss the eggs on each floor until the egg breaks,
        //then we get T. 
    }
    public int VersionFour(int n) {
        //i = 1, 1+2, 1+2+3, ......
        //
    }

}