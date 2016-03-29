package a04;

public class Board {
	
	private int size;
	private int[][] block;
	
	public Board(int[][] blocks) {
		if(blocks == null)
			throw new NullPointerException();
		size = blocks.length;
		this.block = new int[size][size];
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				this.block[i][j] = blocks[i][j];
		
	}// construct a board from an N-by-N array of blocks
	
	// (where blocks[i][j] = block in row i, column j)
	public int size() {
		return size;
	}

	// board size N//Need to look up hamming and how to implement
	public int hamming() {
		int moves;
		for(int i = 0; i < size * size; i++)
			if(block)
	}// number of blocks out of place

	public int manhattan()//need to look up Manhattan and implement {
		return 0;
	}// sum of Manhattan distances between blocks and goal
	// if hamming = 0 there should be 0 moves left to make
	public boolean isGoal() {
		if(hamming() == 0)
			return true;
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
	Board test = new Board(new int[][]{{1,2,3},{3,4,5},{5,6,7}});
	System.out.print(test.toString());
	}// unit tests (not graded)
}
