package org.primefaces.material.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringsTest {

	private static final String EMPTY_STRING = "";

	@Test
	public void testIsEmpty() {
		assertTrue(Strings.isEmpty(EMPTY_STRING));
		assertTrue(Strings.isEmpty(null));
	}
	
	@Test
	public void testIsNotEmptyWithEmptyString() {
		assertFalse(Strings.isNotEmpty(EMPTY_STRING));
		assertFalse(Strings.isNotEmpty(null));
	}

}
