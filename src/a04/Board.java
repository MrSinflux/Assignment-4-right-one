package a04;

public class Board {
	public Board(int[][] blocks) {
	}// construct a board from an N-by-N array of blocks

	// (where blocks[i][j] = block in row i, column j)
	public int size() {
		return 0;
	}

	// board size N
	public int hamming() {
		return 0;
	}// number of blocks out of place

	public int manhattan() {
		return 0;
	}// sum of Manhattan distances between blocks and goal

	public boolean isGoal() {
		return false;
	}// is this board the goal board?

	public boolean isSolvable() {
		return false;
	}// is this board solvable?

	public boolean equals(Object y) {
		return false;
	}// does this board equal y?

	public Iterable<Board> neighbors() {
		return null;
	}// all neighboring boards

	public String toString() {
		return null;
	}// string representation of this board (in the output format specified
		// below)

	public static void main(String[] args) {
	
	}// unit tests (not graded)
}