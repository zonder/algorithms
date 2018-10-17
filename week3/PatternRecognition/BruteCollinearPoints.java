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

  private ArrayList<LineSegment> allSegments;

  /**
   * Finds all line segments containing 4 points
   *
   * @param points all points
   */
  public BruteCollinearPoints(Point[] points) {

    Arrays.sort(points);

    if (points == null)
      throw new java.lang.IllegalArgumentException("Null points were passed");

    allSegments = new ArrayList<>();
    ArrayList<Double> slopes = new ArrayList<>();

    for (int i = 0; i < points.length; i++) {
      if (points[i] == null)
        throw new java.lang.IllegalArgumentException("Null point exist");

      Point p = points[i];
      for (int n = i + 1; n < points.length; n++) {

        boolean isFound = false;

        if (p.compareTo(points[n]) == 0)
          throw new java.lang.IllegalArgumentException("Duplicated point");

        double slope1 = p.slopeTo(points[n]);

        for (int j = n + 1; j < points.length; j++) {

          if (points[n].compareTo(points[j]) == 0)
            throw new java.lang.IllegalArgumentException("Duplicated point");
          double slope2 = p.slopeTo(points[j]);
          if (slope2 != slope1)
            continue;

          for (int z = points.length - 1; z > j; z--) {

            if (points[j].compareTo(points[z]) == 0)
              throw new java.lang.IllegalArgumentException("Duplicated point");

            if (points[z] == null)
              throw new java.lang.IllegalArgumentException("Null point exist");

            double slope3 = p.slopeTo(points[z]);
            if (slope1 == slope2 && slope2 == slope3) {
              boolean b = false;
              /*for (int a = 0; a < slopes.size(); a++) {
                if (slopes.get(a) == slope3)
                // b = true;
              }
              if (b)
                break;*/

              allSegments.add(new LineSegment(points[i], points[z]));
              slopes.add(slope3);
              isFound = true;
              break;
            }
          }
          if (isFound)
            break;
        }

        if (isFound)
          break;
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
  }

}
