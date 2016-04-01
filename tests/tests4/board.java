package tests4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import a04.Board;

public class board {
	Board test1 = new Board(new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 8, 0, 7 } });
	Board test2 = new Board(new int[][] { { 1, 2, 3, }, { 0, 7, 6 }, { 4, 5, 8 } });
	Board test3 = new Board(new int[][] { { 1, 2, 3, }, { 0, 7, 6 }, { 4, 5, 8 } });
	Board test4 = new Board(new int[][] { { 1, 2, 3, }, { 4, 5, 6 }, { 7, 8, 0 } });
	Board test5 = new Board(new int[][] { { 1, 2, 3, }, { 4, 0, 6 }, { 7,8 , 5 } });
	Board test6 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 0,6,8 }, { 9, 10, 7,11 },{ 13, 14, 15,12 } });
	Board test7 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 0,6,8 }, { 9, 10, 7,11 },{ 13, 14, 15,12 } });
	Board test8 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 6,7,8 }, { 9, 10, 11,12 },{ 13, 14, 15,0 } });
	Board test9 = new Board(new int[][] { { 1, 2, 3,4 }, {5, 0,6,8 }, { 9, 10, 7,11 },{ 13, 14, 15,12 } });

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize3() {

		assertEquals(3, test1.size());
	}
	public void testSize4() {

		assertEquals(4, test6.size());
	}
	@Test
	public void testHamming3() {

		assertEquals(1, test5.hamming());
	}
	public void testHamming4() {

		assertEquals(6, test6.hamming());
	}

	@Test
	public void testManhattanTrue3() {

		assertEquals(5, test2.manhattan());
	}
	@Test
	public void testManhattanTrue4() {
			assertEquals(4,test6.manhattan());
		
	}

	@Test
	public void testEquals3() {

		assertEquals(test2, test3);
	}
	@Test
	public void testEquals4() {

		assertEquals(test6, test7);
	}

	@Test
	public void testGoalTrue3() {

		assertEquals(true, test4.isGoal());
	}
	@Test
	public void testGoalTru4() {

		assertEquals(true, test8.isGoal());
	}

	@Test
	public void testGoalFalse() {

		assertEquals(false, test3.isGoal());
	}
	@Test
	public void testGoalFalse4() {

		assertEquals(false, test7.isGoal());
	}

	@Test
	public void testSolvableFalse3() {

		assertEquals(false, test5.isSolvable());
	}
	@Test
	public void testSolvableFalse4() {

		assertEquals(false, test9.isSolvable());
	}
	@Test
	public void testSolvableTrue4() {

		assertEquals(true, test7.isSolvable());
	}

	@Test
	public void testSolvableTrue3() {

		assertEquals(true, test4.isSolvable());
	}
}
