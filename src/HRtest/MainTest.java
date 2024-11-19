package HRtest;

import HR.*;
import org.junit.Test;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import static org.junit.Assert.*;



public class MainTest {

    private final int amount = 10000;

    @Test
    public void testCustomSortOrderValidity() {
        Random RANDOM = new Random();
        Integer[] array = new Integer[amount];

        for (int i = 0; i < amount; i++) {
            array[i] = RANDOM.nextInt();
        }

        array = Main.customSort(array);

        for (int i = 1; i < amount; i++) {
            assertTrue(array[i - 1] <= array[i]);
        }
    }

    @Test
    public void testCustomSortItemsValidity() {
        class Pair implements Comparable<Pair> {
            private final int uniqueID, value;

            public Pair(int ID, int value) { uniqueID = ID; this.value = value; }
            public int getUniqueID() { return uniqueID; }
            public int getValue() { return value; }
            @Override
            public int compareTo(Pair other) { return Integer.compare(value, other.getValue()); }
        }

        Random random = new Random();
        Pair[] array = new Pair[amount];
        Set<Pair> hashset = new HashSet<>();

        for (int i = 0; i < amount; i++) {
            array[i] = new Pair(i, random.nextInt());
            hashset.add(array[i]);
        }

        array = Main.customSort(array);

        for (int i = 0; i < amount; i++) {
            assertTrue(hashset.contains(array[i]));
        }
    }
}

