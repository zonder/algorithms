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

import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints {

  private final ArrayList<LineSegment> allSegments;

  /**
   * Finds all line segments containing 4 points
   *
   * @param points all points
   */
  public FastCollinearPoints(Point[] points) {

    if (points == null)
      throw new java.lang.IllegalArgumentException("Null points were passed");

    allSegments = new ArrayList<>();

    for (int x = 0; x < points.length; x++) {
      if (points[x] == null)
        throw new java.lang.IllegalArgumentException("Null points were passed");
    }
    if (points.length < 3)
      return;

    Point[] original = points.clone();

    Point[] pt = original.clone();
    //ArrayList<Integer>[] checks = new ArrayList<Integer>[] ();

    for (int i = 0; i < pt.length; i++) {
      if (pt[i] == null)
        throw new java.lang.IllegalArgumentException("Null point exist");

      Point p = pt[i];
      Arrays.sort(original, p.slopeOrder());

      int countInRow = 1;
      double prevSlope = p.slopeTo(original[1]);
      if (p.compareTo(original[1]) == 0)
        throw new java.lang.IllegalArgumentException("Duplicated item");

      for (int n = 2; n < original.length; n++) {

        if (p.compareTo(original[n]) == 0)
          throw new java.lang.IllegalArgumentException("Duplicated item");

        double slope = p.slopeTo(original[n]);
        if (slope != prevSlope || n == original.length - 1) {

          if (countInRow >= 3) {
            allSegments.add(new LineSegment(p, original[n - 1]));
          }

          countInRow = 1;
        } else
          countInRow++;

        prevSlope = slope;
      }

    }
  }


  /**
   * Returns the number of line segments
   *
   * @return the number of line segments
   */
  public int numberOfSegments() {
    return allSegments.size();
  }

  /**
   * Returns the line segments
   *
   * @return the line segments
   */
  public LineSegment[] segments() {
    LineSegment[] segmentsResult = new LineSegment[allSegments.size()];
    return allSegments.toArray(segmentsResult);
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
