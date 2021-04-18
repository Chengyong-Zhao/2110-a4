package a4;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

/** @author david gries */
public class CovidTreeTest {
	/*
	 * DISCUSSION OF TESTING Testing with trees is HARDER than testing in A1, A2, or
	 * even A3, with circular linked lists.
	 *
	 * We have provided some methods to help you test your methods that manipulate
	 * trees.
	 *
	 * 1. TESTING METHOD SIZE. To do test size adequately, you have to create a tree
	 * with lots of nodes and see whether size() returns the right value.
	 *
	 * METHOD makeTree1 CREATES A "LARGE" TREE! USE IT TO TEST METHOD size()!
	 *
	 *
	 * 2. TESTING METHOD CONTAINS. Look directly below at the static fields. There
	 * is an array of type Person and individual variables personA, ..., personL.
	 * Look below those declarations at method setup. It has the
	 * annotation @BeforeClass, which means that it will be called before methods
	 * that have @Test before them are called. Method setup initializes the fields
	 * just mentioned. Note this:
	 *
	 * personA has name "A" personB has name "B" ... personL has name "L"
	 *
	 * Further, array people contains the values (personA, personB, ..., personL).
	 * You can use these in testing. For example, look at method makeTree1. Its
	 * specification shows you the tree it constructs. For example, after executing
	 *
	 * CovidTree ct= makeTree1();
	 *
	 * you can test whether personA and personL are in it using
	 *
	 * assertEquals(true, ct.contains(personA)); assertEquals(false,
	 * ct.contains(personC));
	 */

	private static Network n;
	private static Person[] people;
	private static Person personA;
	private static Person personB;
	private static Person personC;
	private static Person personD;
	private static Person personE;
	private static Person personF;
	private static Person personG;
	private static Person personH;
	private static Person personI;
	private static Person personJ;
	private static Person personK;
	private static Person personL;

	/** */
	@BeforeClass
	public static void setup() {
		n = new Network();
		people = new Person[] { new Person("A", 0, n), new Person("B", 0, n), new Person("C", 0, n),
				new Person("D", 0, n), new Person("E", 0, n), new Person("F", 0, n), new Person("G", 0, n),
				new Person("H", 0, n), new Person("I", 0, n), new Person("J", 0, n), new Person("K", 0, n),
				new Person("L", 0, n) };
		personA = people[0];
		personB = people[1];
		personC = people[2];
		personD = people[3];
		personE = people[4];
		personF = people[5];
		personG = people[6];
		personH = people[7];
		personI = people[8];
		personJ = people[9];
		personK = people[10];
		personL = people[11];
	}

	/*
	 * TESTING METHOD DEPTH. Take a look at the tree produced by method makeTree1.
	 * We have: personA is at depth 0 personB is at depth 1 personC is at depth 1
	 * personD is at depth 2 and so on.
	 *
	 * Array people already contains personA, personB, personC, ..., personL What if
	 * you constructed an array
	 *
	 * int[] depths= {0, 1, 1, 2, ...}
	 *
	 * that contained the depth of each person in array people (including those that
	 * are not in it)? You could then write a loop in method test3Contains to test
	 * ALL of those people:
	 *
	 * for (int k= 0; k < people.length; k= k+1) { assertEquals(depths[k], a
	 * suitable call on contains, for you to do); }
	 *
	 * This is the work that has to go on to do adequate testing
	 */

	/** * */
	@Test
	public void testBuiltInGetters() {
		CovidTree st = new CovidTree(personB);
		assertEquals("B", toStringBrief(st));
	}

	/**
	 * Create a CovidTree with structure A[B[D E F[G[H[I] J]]] C] <br>
	 * This is the tree
	 *
	 * <pre>
	 *            A
	 *          /   \
	 *         B     C
	 *       / | \
	 *      D  E  F
	 *            |
	 *            G
	 *            | \
	 *            H  J
	 *            |
	 *            I
	 * </pre>
	 */
	private CovidTree makeTree1() {
		CovidTree dt = new CovidTree(personA); // A
		dt.insert(personA, personB); // A, B
		dt.insert(personA, personC); // A, C
		dt.insert(personB, personD); // B, D
		dt.insert(personB, personE); // B, E
		dt.insert(personB, personF); // B, F
		dt.insert(personF, personG); // F, G
		dt.insert(personG, personH); // G, H
		dt.insert(personH, personI); // H, I
		dt.insert(personG, personJ); // G, J
		return new CovidTree(dt);
	}

	/** test a call on makeTree1(). */
	@Test
	public void testMakeTree1() {
		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
	}

	/** */
	@Test
	public void test1Insert() {
		// TODO 1
		// Test insert in the root
		CovidTree st = new CovidTree(personB);
		CovidTree dtC = st.insert(personB, personC);
		assertEquals("B[C]", toStringBrief(st)); // test tree
		assertEquals(personC, dtC.person()); // test return value
		// System.out.println(st.toString());

	}

	/** */
	@Test
	public void test2size() {
		// TODO 2
		/*
		 * We provide ONE test case. YOU WRITE MORE. At this point, look at line 18
		 * (about) for a discussion of making a tree with which to test size.
		 */

		CovidTree st = new CovidTree(personC);
		assertEquals(1, st.size());
		CovidTree dtC = st.insert(personC, personB);
		assertEquals(2, st.size());
		// System.out.println(st.toString());
		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
		assertEquals(10, dt.size());

	}

	/** */
	@Test
	public void test3contains() {
		// TODO 3
		/*
		 * We give you ONE test case. You have to put more in. Look at about line 24 for
		 * a discussion of how to do this. You will learn a lot about how to prepare for
		 * testing complicated data structures.
		 */
		CovidTree st = new CovidTree(personC);
		assertEquals(true, st.contains(personC));
		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
		assertEquals(10, dt.size());
		assertEquals(true, dt.contains(personA));
		assertEquals(true, dt.contains(personB));
		assertEquals(true, dt.contains(personC));
		assertEquals(true, dt.contains(personD));
		assertEquals(true, dt.contains(personE));
		assertEquals(true, dt.contains(personF));
		assertEquals(true, dt.contains(personG));
		assertEquals(true, dt.contains(personH));
		assertEquals(true, dt.contains(personI));
	}

	/** */
	@Test
	public void test4depth() {
		// TODO 4
		/*
		 * We give you ONE test case. You have to put more in. Look at around line 89
		 * for a discussion of how to do this. You will learn a lot about how to prepare
		 * for testing complicated data structures.
		 */
//		CovidTree st = new CovidTree(personB);
//		st.insert(personB, personC);
//		st.insert(personC, personD);
//		assertEquals(0, st.depth(personB));

		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
//		assertEquals(10, dt.size());
//		assertEquals(0, dt.depth(personA));
//		assertEquals(1, dt.depth(personB));
//		assertEquals(1, dt.depth(personC));
//		assertEquals(2, dt.depth(personD));
//		assertEquals(2, dt.depth(personE));
//		assertEquals(2, dt.depth(personF));
//		assertEquals(3, dt.depth(personG));
//		assertEquals(4, dt.depth(personH));
		assertEquals(5, dt.depth(personI));

	}

	/** */
	@Test
	public void test5WidthAtDepth() {
		// TODO 5
		CovidTree st = new CovidTree(personB);
		assertEquals(1, st.widthAtDepth(0));

		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
		assertEquals(1, dt.widthAtDepth(0));
		assertEquals(2, dt.widthAtDepth(1));
		assertEquals(3, dt.widthAtDepth(2));
		assertEquals(1, dt.widthAtDepth(3));
		assertEquals(2, dt.widthAtDepth(4));
		assertEquals(1, dt.widthAtDepth(5));

	}

	/** */
	@Test
	public void test6CovidRouteTo() {
		// TODO 6
		/*
		 * The one testcase we give shows you how to use method getNames() to make
		 * testing a bit easier. Use it in developing more testcases.
		 */
		CovidTree st = new CovidTree(personB);
		List<Person> route = st.covidRouteTo(personB);
		assertEquals("[B]", getNames(route));

		CovidTree dt = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt));
		List<Person> route1 = dt.covidRouteTo(personF);
		// System.out.print(route1.toString());
		assertEquals("[A, B, F]", getNames(route1));
		List<Person> route2 = dt.covidRouteTo(personH);
		// System.out.print(route1.toString());
		assertEquals("[A, B, F, G, H]", getNames(route2));

	}

	/**
	 * Return the names of Persons in sp, separated by ", " and delimited by [ ].
	 * <br>
	 * Precondition: No name is the empty string.
	 */
	private String getNames(List<Person> sp) {
		String res = "[";
		for (Person p : sp) {
			if (res.length() > 1)
				res = res + ", ";
			res = res + p.name();
		}
		return res + "]";
	}

	/** */
	@Test
	public void test7commonAncestor() {
		// TODO 7
		CovidTree st = new CovidTree(personB);
		st.insert(personB, personC);
		Person p = st.commonAncestor(personC, personC);
		assertEquals(personC, p);

	}

	/**
	 * This is what makeTree1() produces
	 *
	 * <pre>
	 *            A
	 *          /   \
	 *         B     C
	 *       / | \
	 *      D  E  F
	 *            |
	 *            G
	 *            | \
	 *            H  J
	 *            |
	 *            I
	 * </pre>
	 */

	/** */
	@Test
	public void test8equals() {
		// TODO 8
		CovidTree treeB1 = new CovidTree(personB);
		CovidTree treeB2 = new CovidTree(personB);
		assertEquals(true, treeB1.equals(treeB1));
		assertEquals(true, treeB1.equals(treeB2));

		CovidTree dt1 = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt1));
		CovidTree dt2 = makeTree1();
		assertEquals("A[B[D E F[G[H[I] J]]] C]", toStringBrief(dt2));
		assertEquals(true, dt1.equals(dt2));

	}

	// ===================================
	// ==================================

	/**
	 * Return a representation of this tree. This representation is: <br>
	 * (1) the name of the Person at the root, followed by <br>
	 * (2) the representations of the children <br>
	 * . (in alphabetical order of the children's names). <br>
	 * . There are two cases concerning the children.
	 *
	 * . No children? Their representation is the empty string. <br>
	 * . Children? Their representation is the representation of each child, <br>
	 * . with a blank between adjacent ones and delimited by "[" and "]". <br>
	 * <br>
	 * Examples: One-node tree: "A" <br>
	 * root A with children B, C, D: "A[B C D]" <br>
	 * root A with children B, C, D and B has a child F: "A[B[F] C D]"
	 */
	public static String toStringBrief(CovidTree t) {
		String res = t.person().name();

		Object[] childs = t.copyOfChildren().toArray();
		if (childs.length == 0)
			return res;
		res = res + "[";
		selectionSort1(childs);

		for (int k = 0; k < childs.length; k = k + 1) {
			if (k > 0)
				res = res + " ";
			res = res + toStringBrief((CovidTree) childs[k]);
		}
		return res + "]";
	}

	/**
	 * Sort b --put its elements in ascending order. <br>
	 * Sort on the name of the Person at the root of each CovidTree.<br>
	 * Throw a cast-class exception if b's elements are not CovidTree
	 */
	public static void selectionSort1(Object[] b) {
		int j = 0;
		// {inv P: b[0..j-1] is sorted and b[0..j-1] <= b[j..]}
		// 0---------------j--------------- b.length
		// inv : b | sorted, <= | >= |
		// --------------------------------
		while (j != b.length) {
			// Put into p the index of smallest element in b[j..]
			int p = j;
			for (int i = j + 1; i != b.length; i++) {
				String bi = ((CovidTree) b[i]).person().name();
				String bp = ((CovidTree) b[p]).person().name();
				if (bi.compareTo(bp) < 0) {
					p = i;

				}
			}
			// Swap b[j] and b[p]
			Object t = b[j];
			b[j] = b[p];
			b[p] = t;
			j = j + 1;
		}
	}

}
