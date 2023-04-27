package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.Solution2;

public class SolutionTest2 {

	private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final static ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final static PrintStream originalOut = System.out;
	private final static PrintStream originalErr = System.err;

	@BeforeAll
	public static void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@AfterAll
	public static void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	@Test
	void checkOutput5() {
		assertEquals("    *\n"
				+ "   ***\n"
				+ "  *****\n"
				+ " *******\n"
				+ "*********\n"
				+ "***   ***\n"
				+ "***   ***\n"
				+ "***   ***\n", Solution2.calculate(5));
	}
	
	@Test
	void checkOutput7() {
		assertEquals("      *\n"
				+ "     ***\n"
				+ "    *****\n"
				+ "   *******\n"
				+ "  *********\n"
				+ " ***********\n"
				+ "*************\n"
				+ "***       ***\n"
				+ "***       ***\n"
				+ "***       ***\n", Solution2.calculate(7));
	}
}
