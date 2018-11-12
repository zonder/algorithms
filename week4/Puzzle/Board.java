/* *****************************************************************************
 *  Name:    Alexander Masalov
 *  Description:  Board class
 *
 *  Written:       11/13/2018
 *  Last updated:  11/13/2018
 *
 *  % javac-algs4 Board.java
 *  % java-algs4 Board
 *
 **************************************************************************** */

public class Board {
    /**
     * Constructs a board from an n-by-n array of blocks
     * (where blocks[i][j] = block in row i, column j)
     *
     * @param blocks
     */
    public Board(int[][] blocks) {

    }

    /**
     * Returns board dimension n
     *
     * @return board dimension n
     */
    public int dimension() {
        return 0;
    }

    /**
     * Returns number of blocks out of place
     *
     * @return number of blocks out of place
     */
    public int hamming() {
        return 0;
    }

    /**
     * Returns sum of Manhattan distances between blocks and goal
     *
     * @return sum of Manhattan distances between blocks and goal
     */
    public int manhattan() {
        return 0;
    }

    /**
     * Returns if this board is the goal board?
     *
     * @return if this board is the goal board?
     */

    public boolean isGoal() {
        return false;
    }

    /**
     * Returns a board that is obtained by exchanging any pair of blocks
     *
     * @return a board that is obtained by exchanging any pair of blocks
     */
    public Board twin() {
        return null;
    }

    /**
     * Returns does this board equal y?
     *
     * @param y equal to another board
     * @return does this board equal y?
     */
    public boolean equals(Object y) {
        return false;
    }

    /**
     * Returns all neighboring boards
     *
     * @return all neighboring boards
     */
    public Iterable<Board> neighbors() {
        return null;
    }

    /**
     * Returns string representation of this board (in the output format specified below)
     *
     * @return
     */
    public String toString() {
        return "";
    }

    /**
     * Unit tests
     *
     * @param args arguments
     */
    public static void main(String[] args) {

    }
}
