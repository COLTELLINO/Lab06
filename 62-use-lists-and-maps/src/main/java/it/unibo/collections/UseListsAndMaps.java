package it.unibo.collections;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            al.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> ll = new LinkedList<>(); 
        ll.addAll(al);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int first = al.get(0);
        int last = al.get(al.size() - 1);
        al.set(0, last);
        al.set(al.size() - 1, first);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (int e : al) {
            System.out.println("" + e);            
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for(int i = 0; i < 100000; i++) {
            al.addFirst(0);
        }
        for(int i = 0; i < 100000; i++) {
            ll.addFirst(0);
            }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println("Time required to insert 100.000 first elements in both lists: " + millis + " ms");
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        long time2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            al.get(al.size()/2);
            al.get(ll.size()/2);
        }
        time2 = System.nanoTime() - time2;
        System.out.println("Time required to read the central element 1000 times in both lists: " + time2 + " ns");
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String, Integer> map = new HashMap<>();
        map.put("Africa", 1110635000);
        map.put("Americas", 972005000);
        map.put("Antartica", 0);
        map.put("Asia", 429872300);
        map.put("Europe", 742452000);
        map.put("Oceania", 38304000);
        /*
         * 8) Compute the population of the world
         */
        long worldPopulation = 0;
        for (int population : map.values()) {
            worldPopulation += population;
        }
        System.out.println("World Population: " + worldPopulation);
    }
}