package a04;

public class Board {

	private int size;
	private int N;
	private int[][] block;

	public Board(int[][] blocks) {
		if (blocks == null)
			throw new NullPointerException();
		size = blocks.length;
		N = size * size;

		this.block = new int[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				this.block[i][j] = blocks[i][j];

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
		return ham;

	}// number of blocks out of place

	public int manhattan() {// need to look up Manhattan and implement {
		int distance = 0;
		for (int x = 0; x < size; x++)
			for (int y = 0; y < size; y++) {
				int value = block[x][y];
				if (value != 0) {
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

	public boolean isSolvable() {
		return false;
	}// is this board solvable?

	public boolean equals(Object y) {
		if(y == null) return false;
		if(y == this) return true;
		if(y.getClass()!= this.getClass()) return false;
		Board board = (Board)y;
		if(this.size() != board.size()) return false;
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				if(this.block[i][j] != board.block[i][j])
					return false;
		return true;
	}// does this board equal y?

	public Iterable<Board> neighbors() {
		return null;
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

		Board test1 = new Board(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } });
		// System.out.print(test1.toString());
		// System.out.print(test1.hamming());
		System.out.print(test1.isGoal());
	}// unit tests (not graded)
}
