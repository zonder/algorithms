/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that illustrates Deque data structure work.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 Deque.java
 *  % java-algs4 Deque
 *  226/400
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    /**
     * Returns an iterator over items in order from front to end
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new java.util.NoSuchElementException();
                return null;
            }
        };
    }

    /**
     * unit testing (optional)
     *
     * @param args external arguments
     */
    public static void main(String[] args) {
        StdOut.println("-------------");
    }
}
