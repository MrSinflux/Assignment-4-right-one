package a04;

import edu.princeton.cs.algs4.Stack;
//test
public class Board {

	private int size;
	private int N;
	private int[][] block;
	private int x;// x of initial 0
	private int y;// y of initial 0

	public Board(int[][] blocks) {
		if (blocks == null)
			throw new NullPointerException();
		size = blocks.length;
		N = size * size;

		this.block = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (blocks[i][j] == 0) {
					x = i;
					y = j;
				}
				this.block[i][j] = blocks[i][j];
			}
		}
	}// construct a board from an N-by-N array of blocks

	// (where blocks[i][j] = block in row i, column j)
	public int size() {
		return size;
	}

	// board size N//Need to look up hamming and how to implement
	public int hamming() {

		int ham = 0;
		for (int i = 0; i < this.size; i++)
			for (int j = 0; j < this.size; j++)
				if (block[i][j] != 0 && block[i][j] != (i * size + j + 1))
					ham++;
		//if (ham == 0)
			//return ham;
		return ham;

	}// number of blocks out of place

	public int manhattan() {// need to look up Manhattan and implement {
		int distance = 0;
		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++) {
				int value = block[x][y];
				if (value != 0 && this.hamming() != 0) {
					distance += Math.abs(x - ((value - 1) / size)) + Math.abs(y - ((value - 1) % size));
				}

			}
		return distance;
	}// sum of Manhattan distances between blocks and goal
		// if hamming = 0 there should be 0 moves left to make

	public boolean isGoal() {
		if (hamming() == 0)
			return true;
		return false;
	}// is this board the goal board?
	/*
	 * private swap method
	 */

	private void swap(int[][] array, int x1, int y1, int x2, int y2) {
		int t = array[x1][y1];
		array[x1][y1] = array[x2][y2];
		array[x2][y2] = t;
	}

	/*
	 * Private array coppy method
	 */
	private int[][] copy() {
		int[][] copy = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				copy[i][j] = block[i][j];
		return copy;
	}

	public boolean isSolvable() {
		/**if (size % 2 != 0 && this.hamming() % 2 != 0)
			return false;
		if (size % 2 == 0 && (this.hamming() + x) % 2 != 0)
			return false;**/
		//need to rethink logic
		return true;
	}// is this board solvable?

	public boolean equals(Object y) {
		if (y == null)
			return false;
		if (y == this)
			return true;
		if (y.getClass() != this.getClass())
			return false;
		Board board = (Board) y;
		if (this.size() != board.size())
			return false;
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (this.block[i][j] != board.block[i][j])
					return false;
		return true;
	}// does this board equal y?

	public Iterable<Board> neighbors() { // checks corner cases and takes the
											// new neighbor board and pushes it
											// to stack
		Stack<Board> s = new Stack<Board>();
		int[][] t = copy(); // copies new array for a temp
		if (x < size - 1) {
			swap(t, x, y, x + 1, y); // swaps right neighbor
			s.push(new Board(t)); // pushes new board
			swap(t, x + 1, y, x, y); // returns to original
		}
		if (x > 0) { // swaps left neighbor
			swap(t, x - 1, y, x, y);
			s.push(new Board(t)); // new board
			swap(t, x, y, x - 1, y); // returns to original
		}
		if (y < size - 1) {
			swap(t, x, y, x, y + 1);// swaps bottom neighbor
			s.push(new Board(t)); // pushes new board
			swap(t, x, y + 1, x, y);// returns to normal
		}
		if (y > 0) {
			swap(t, x, y - 1, x, y); // swaps bottom neighbor
			s.push(new Board(t)); // pushes new board
			swap(t, x, y, x, y - 1);// returns to normal
		}

		return s;
	}// all neighboring boards

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(size + "\n");
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				s.append(String.format("%2d ", block[i][j]));
			}
			s.append("\n");
		}
		return s.toString();
	}
	// string representation of this board (in the output format specified
	// below)

	public static void main(String[] args) {

		Board test1 = new Board(new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 8, 0, 7 } });
		Board test4 = new Board(new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 0 } });
		Board test6 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 0,6,8 }, { 9, 10, 7,11 },{ 13, 14, 15,12 } });
		Board test2 = new Board(new int[][] { { 1, 2, 3, }, { 0, 7, 6 }, { 4, 5, 8 } });
		Board test13 = new Board(new int[][] { { 8, 1, 3, }, { 4, 0, 2 }, { 7, 6, 5 } });
		Board test67 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 6,7,8 }, { 9, 10,11,12},{ 13, 14, 15,0} });
		System.out.println(test1.toString());
		System.out.println("hamming " + test13.hamming());
		System.out.println("goal " + test13.isGoal());       
		System.out.println("size " + test13.size);
		System.out.println("solvable " + test13.isSolvable());
		System.out.println("block row " + test13.x);
		System.out.println("Manhattan " + test13.manhattan());

	}// unit tests (not graded)
}
