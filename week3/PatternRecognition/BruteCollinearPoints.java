/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Program that recognizes line patterns in a given set of points.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 BruteCollinearPoints.java
 *  % java-algs4 BruteCollinearPoints
 *  226/400
 *
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

  private final ArrayList<LineSegment> allSegments;

  /**
   * Finds all line segments containing 4 points
   *
   * @param points all points
   */
  public BruteCollinearPoints(Point[] points) {

    if (points == null)
      throw new java.lang.IllegalArgumentException("Null points were passed");

    for (int x = 0; x < points.length; x++) {
      if (points[x] == null)
        throw new java.lang.IllegalArgumentException("Null points were passed");
    }

    Point[] pt = points.clone();


    Arrays.sort(pt);

    allSegments = new ArrayList<>();

    double prevSlope = Double.NEGATIVE_INFINITY;
    for (int i = 0; i < pt.length; i++) {
      if (pt[i] == null)
        throw new java.lang.IllegalArgumentException("Null point exist");

      Point p = pt[i];
      for (int n = i + 1; n < pt.length; n++) {
        if (pt[n] == null)
          throw new java.lang.IllegalArgumentException("Null point exist");

        boolean lineProcessed = false;
        if (p.compareTo(pt[n]) == 0)
          throw new java.lang.IllegalArgumentException("Duplicated point");

        double slope1 = p.slopeTo(pt[n]);
        if (Double.compare(slope1, prevSlope) == 0)
          continue;

        prevSlope = slope1;

        for (int j = n + 1; j < pt.length; j++) {

          if (pt[j] == null)
            throw new java.lang.IllegalArgumentException("Null point exist");

          if (pt[n].compareTo(pt[j]) == 0)
            throw new java.lang.IllegalArgumentException("Duplicated point");
          double slope2 = p.slopeTo(pt[j]);
          if (slope2 != slope1)
            continue;

          for (int z = pt.length - 1; z > j; z--) {

            if (pt[j].compareTo(pt[z]) == 0)
              throw new java.lang.IllegalArgumentException("Duplicated point");

            if (pt[z] == null)
              throw new java.lang.IllegalArgumentException("Null point exist");

            double slope3 = p.slopeTo(pt[z]);
            if (slope1 == slope2 && slope2 == slope3) {
              allSegments.add(new LineSegment(pt[i], pt[z]));
              lineProcessed = true;
              break;
            }
          }
          if (lineProcessed)
            break;
        }
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
}
