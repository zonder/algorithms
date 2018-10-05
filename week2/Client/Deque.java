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


public class Deque<Item> implements Iterable<Item> {

    /**
     * @param <Item>
     */
    private class Node<Item> {
        public Item value;
        public Node<Item> next;
        public Node<Item> prev;
    }

    private int count = 0;
    private Node<Item> first;
    private Node<Item> last;

    /**
     * Constructs an empty deque
     */
    public Deque() {

    }

    /**
     * Checks is the deque empty?
     *
     * @return if the deque is empty?
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Returns the number of items on the deque
     *
     * @return he number of items on the deque
     */
    public int size() {
        return count;
    }

    /**
     * Adds the item to the front
     *
     * @param item to add at the top
     */
    public void addFirst(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();

        Node<Item> node = new Node<>();
        node.value = item;
        node.next = first;
        node.prev = null;

        if (first != null)
            first.prev = node;

        first = node;
        if (last == null)
            last = node;

        count++;
    }

    /**
     * Adds the item to the end
     *
     * @param item to add at the end
     */
    public void addLast(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException();

        Node<Item> node = new Node<>();
        node.value = item;
        node.next = null;

        if (last != null)
            last.next = node;

        node.prev = last;

        last = node;
        if (first == null)
            first = node;

        count++;
    }

    /**
     * Removes and return the item from the front
     *
     * @return removed item
     */
    public Item removeFirst() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        Item value = first.value;
        if (first.next == null) {
            first = null;
            last = null;
            count = 0;
        } else {
            first = first.next;
            first.prev = null;
            count--;
        }
        return value;

    }

    /**
     * Removes and return the item from the end
     *
     * @return removed item
     */
    public Item removeLast() {
        if (isEmpty())
            throw new java.util.NoSuchElementException();

        Item value = last.value;
        if (last.prev == null) {
            first = null;
            last = null;
            count = 0;
        } else {
            last = last.prev;
            last.next = null;
            count--;
        }
        return value;
    }

    /**
     * Returns an iterator over items in order from front to end
     *
     * @return iterator
     */
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {
            private Node<Item> current = first;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public void remove() {
                throw new java.lang.UnsupportedOperationException();
            }

            @Override
            public Item next() {
                if (!hasNext())
                    throw new java.util.NoSuchElementException();

                Item value = current.value;
                current = current.next;
                return value;
            }
        };
    }

    /**
     * unit testing (optional)
     *
     * @param args external arguments
     */
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        StdOut.println(deque.isEmpty());
        deque.addFirst("to");
        deque.addFirst("be");
        deque.addFirst("q");
        deque.addFirst("qq");
        deque.addFirst("qqq");
        /*deque.addLast("or");
        deque.addLast("not");*/
        StdOut.println(deque.isEmpty());
        StdOut.println(deque.size());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.removeLast());
        StdOut.println(deque.isEmpty());
        StdOut.println("-------------");

        for (String s : deque) {
            StdOut.print(s + " ");
        }
    }
}
