package org.primefaces.material.util;


public class Strings {
	public static final String EMPTY = "";

	private Strings(){}
	
	public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
	
	public static boolean isNotEmpty(final CharSequence cs) {
        return !Strings.isEmpty(cs);
    }
}
