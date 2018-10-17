/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that recognizes line patterns in a given set of points.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 FastCollinearPoints.java
 *  % java-algs4 FastCollinearPoints
 *  226/400
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class FastCollinearPoints {

  /**
   * Finds all line segments containing 4 points
   *
   * @param points all points
   */
  public FastCollinearPoints(Point[] points) {
    if (points == null)
      throw new java.lang.IllegalArgumentException("Null points were passed");
  }

  /**
   * Returns the number of line segments
   *
   * @return the number of line segments
   */
  public int numberOfSegments() {
    return 0;
  }

  /**
   * Returns the line segments
   *
   * @return the line segments
   */
  public LineSegment[] segments() {
    return null;
  }


  /**
   * unit testing (optional)
   *
   * @param args external arguments
   */
  public static void main(String[] args) {
    StdOut.println("FastCollinearPoints");
  }
}
