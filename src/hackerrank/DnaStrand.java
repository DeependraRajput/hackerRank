package hackerrank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DnaStrand {

	public static String dnaComplement2(String dna) {
		return dna.replaceAll("T", "x").replaceAll("A", "T").replaceAll("x", "A").replaceAll("G", "x")
				.replaceAll("C", "G").replaceAll("x", "C");
	}

	public static String dnaComplement(String dna) {
		StringBuilder sb = new StringBuilder();
		for (char c : dna.toCharArray()) {
			char x = 'x';
			switch (c) {
			case 'A':
				x = 'T';
				break;
			case 'T':
				x = 'A';
				break;
			case 'C':
				x = 'G';
				break;
			case 'G':
				x = 'C';
				break;
			default:
				break; // As per question this will never occur.
			}
			sb.append(x);
		}
		return sb.toString();
	}

	@Test
	public void shouldWorkForASingleA() {
		assertEquals("T", dnaComplement("A"));
	}

	@Test
	public void shouldWorkForASingleT() {
		assertEquals("A", dnaComplement("T"));
	}

	@Test
	public void shouldWorkForASingleC() {
		assertEquals("G", dnaComplement("C"));
	}

	@Test
	public void shouldWorkForASingleG() {
		assertEquals("C", dnaComplement("G"));
	}

	@Test
	public void shouldWorkForAAttgc() {
		assertEquals("TAACG", dnaComplement("ATTGC"));
	}

	@Test
	public void shouldWorkForAGtacat() {
		assertEquals("CATGTA", dnaComplement("GTACAT"));
	}

	@Test
	public void shouldWorkForACgcg() {
		assertEquals("GCGC", dnaComplement("CGCG"));
	}

	@Test
	public void shouldWorkForAVeryLongInput() {
		assertEquals("CATAGCTAGCTAGCTAGCTAATATAAAAGCTGCTCTAAATTTATATATATATATGCTCTCTTATGTCTATCTGTCTAAT",
				dnaComplement("GTATCGATCGATCGATCGATTATATTTTCGACGAGATTTAAATATATATATATACGAGAGAATACAGATAGACAGATTA"));
	}
}
