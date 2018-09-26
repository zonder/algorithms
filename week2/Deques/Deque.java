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

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
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
    return false;
  }

  /**
   * Returns the number of items on the deque
   *
   * @return he number of items on the deque
   */
  public int size() {

  }

  /**
   * Adds the item to the front
   *
   * @param item to add at the top
   */
  public void addFirst(Item item) {
    if (item == null)
      throw new java.lang.IllegalArgumentException();
  }

  /**
   * Adds the item to the end
   *
   * @param item to add at the end
   */
  public void addLast(Item item) {
    if (item == null)
      throw new java.lang.IllegalArgumentException();

  }

  /**
   * Removes and return the item from the front
   *
   * @return removed item
   */
  public Item removeFirst() {
    if (isEmpty())
      throw new java.util.NoSuchElementException();

    return null;
  }

  /**
   * Removes and return the item from the end
   *
   * @return removed item
   */
  public Item removeLast() {
    if (isEmpty())
      throw new java.util.NoSuchElementException();

    return null;
  }

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
        // throw new java.util.NoSuchElementException();
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
    System.out.println("Deque");
  }
}
