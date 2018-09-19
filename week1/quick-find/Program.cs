using System;

namespace quick_find
{
  class Program
  {
    static void Main(string[] args)
    {
      var quickFinder = new QuickFinder(10);
      quickFinder.Union(1, 3);
      /*0 3 2 3 4 5 6 7 8 9 */
      quickFinder.Union(3, 8);
      /*0 8 2 8 4 5 6 7 8 9 */
      quickFinder.Union(7, 4);
      /*0 8 2 8 4 5 6 4 8 9 */
      quickFinder.Union(5, 8);
      /*0 8 2 8 4 8 6 4 8 9 */

      Console.WriteLine(quickFinder.Find(1, 5));

      quickFinder.Print();
    }
  }
}
