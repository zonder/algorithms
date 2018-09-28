/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that illustrates RandomizedQueue data structure work.
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
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final int defaultCapacity = 10;
    private static final int capacityShrinkFactor = 4;

    private Item[] arr;

    private int hPointer;
    private int tPointer;

    public RandomizedQueue() {
        arr = (Item[]) new Object[defaultCapacity];
        hPointer = tPointer = getCapacity() / 2;
    }

    /**
     * Checks if the randomized queue is empty
     *
     * @return is the randomized queue empty?
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Return the number of items on the randomized queue
     *
     * @return number of items on the randomized queue
     */
    public int size() {
        return tPointer - hPointer;
    }

    /**
     * Adds the item
     *
     * @param item to add
     */
    public void enqueue(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();

        boolean isHead = getNextMode();
        if (isHead) {
            if (hPointer <= 0)
                extendArray();

            hPointer--;
            arr[hPointer] = item;

        } else {
            if (tPointer >= getCapacity())
                extendArray();

            arr[tPointer++] = item;
        }
    }

    /**
     * Removes and return a random item
     *
     * @return random item
     */
    public Item dequeue() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        Item value;
        boolean isHead = getNextMode();
        if (isHead) {
            value = arr[hPointer];
            arr[hPointer] = null;
            hPointer++;
        } else {
            tPointer--;
            value = arr[tPointer];
            arr[tPointer] = null;
        }

        if (getCapacity() > size() * capacityShrinkFactor)
            shrinkArray();

        return value;
    }

    /**
     * Returns a random item (but do not remove it)
     *
     * @return random item
     */
    public Item sample() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        int randomIndex = StdRandom.uniform(hPointer, tPointer);
        return arr[randomIndex];
    }

    /**
     * Generates mode
     *
     * @return how element should be added/removed
     */
    private boolean getNextMode() {
        return StdRandom.uniform(0, 2) == 0;
    }

    /**
     * Returns capacity
     *
     * @return capacity
     */
    private int getCapacity() {
        return arr.length;
    }

    /**
     * Double size of array
     */
    private void extendArray() {
        int newLength = getCapacity() * 2;
        Item[] copy = (Item[]) new Object[newLength];
        int offset = (newLength / 4) - 1;
        for (int i = 0, n = offset; i < getCapacity(); i++, n++)
            copy[n] = arr[i];

        hPointer += offset;
        tPointer += offset;
        arr = copy;
    }

    /**
     * Shrinks array
     */
    private void shrinkArray() {

        int offset = (getCapacity() / 2 + 1);
        if (hPointer > offset) {
            int newLength = getCapacity() / 2 + 1;
            Item[] copy = (Item[]) new Object[newLength];
            for (int i = offset, n = 0; i < getCapacity(); i++, n++)
                copy[n] = arr[i];

            hPointer -= offset;
            tPointer -= offset;
            arr = copy;
        } else if (tPointer < offset - size() - 1) {
            int newLength = getCapacity() / 2 + 1;
            Item[] copy = (Item[]) new Object[newLength];
            for (int i = 0; i < offset; i++)
                copy[i] = arr[i];

            arr = copy;
        }
    }

    /**
     * Returns an iterator over items in order from front to end
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            private int pointer = StdRandom.uniform(hPointer, tPointer);
            private int steps = size();

            @Override
            public boolean hasNext() {
                return steps > 0;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new java.util.NoSuchElementException();

                steps--;
                if (pointer >= hPointer && pointer < tPointer)
                    return arr[pointer++];
                else
                    return arr[hPointer + (pointer++ - tPointer)];
            }
        };
    }

    /**
     * unit testing (optional)
     *
     * @param args external arguments
     */
    public static void main(String[] args) {
        int index = 10;
        do {
            RandomizedQueue<String> randomQueue = new RandomizedQueue<>();
            StdOut.println(randomQueue.isEmpty());
            randomQueue.enqueue("a");
            randomQueue.enqueue("b");
            randomQueue.enqueue("c");
            randomQueue.enqueue("d");
            randomQueue.enqueue("e");
            randomQueue.enqueue("f");
            randomQueue.enqueue("g");
            randomQueue.enqueue("h");

            StdOut.println("Samples");
            StdOut.println(randomQueue.size());
            StdOut.println(randomQueue.sample());
            StdOut.println(randomQueue.sample());
            StdOut.println(randomQueue.size());

            StdOut.println("Dequeue");
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.dequeue());
            StdOut.println(randomQueue.size());

            StdOut.println("Iterators");
            for (String s : randomQueue) {
                StdOut.print(s + " ");
            }
            StdOut.println();
            for (String s : randomQueue) {
                StdOut.print(s + " ");
            }
            StdOut.println();
        } while (index-- > 0);

    }
}
