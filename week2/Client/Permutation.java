/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Client.
 *
 *  Written:       09/23/2018
 *  Last updated:  09/25/2018
 *
 *  % javac-algs4 Permutation.java
 *  % java-algs4 Permutation
 *  226/400
 *
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;


public class Permutation {

    /**
     * Run client
     *
     * @param args external arguments
     */
    public static void main(String[] args) {

        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomQueue = new RandomizedQueue<>();
        while (StdIn.hasNextLine()) {
            String input = StdIn.readString();
            if (!input.isEmpty()) {
                randomQueue.enqueue(input);
            }
        }


        for (String s : randomQueue) {
            if (k-- == 0)
                break;

            StdOut.println(s);
        }
    }
}
