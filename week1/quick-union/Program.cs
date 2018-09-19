using System;

namespace quick_union
{
  class Program
  {
    static void Main(string[] args)
    {
       var quickFinder = new QuickUnion(10);
      quickFinder.Union(1, 3);
      /*0 3 2 3 4 5 6 7 8 9 */
      quickFinder.Union(3, 8);
      /*0 3 2 8 4 5 6 7 8 9 */
      quickFinder.Union(7, 4);
      /*0 3 2 8 4 5 6 4 8 9 */
      quickFinder.Union(5, 8);
      /*0 3 2 8 4 8 6 4 8 9 */
      quickFinder.Union(0, 5);
      /*8 3 2 8 4 8 6 4 8 9 */

      Console.WriteLine(quickFinder.Find(1, 5));

      quickFinder.Print();

      // -----------------------------
       var quickFinderWeighted = new QuickUnionWeighted(10);
      quickFinderWeighted.Union(1, 3);
      quickFinderWeighted.Union(3, 8);
      quickFinderWeighted.Union(7, 4);
      quickFinderWeighted.Union(5, 8);
      quickFinderWeighted.Union(0, 5);
      /*3 3 2 3 4 3 6 4 3 9 */

      Console.WriteLine(quickFinderWeighted.Find(1, 5));

      quickFinderWeighted.Print();
    }
  }
}
