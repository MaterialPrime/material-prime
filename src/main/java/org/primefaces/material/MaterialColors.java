package org.primefaces.material;

import java.util.Random;

public enum MaterialColors {
	RED("red"),
	PINK("pink"),
	PURPLE("purple"),
	DEEP_PURPLE("deep-purple"),
	INDIGO("indigo"),
	BLUE("blue"),
	LIGHT_BLUE("light-blue"),
	CYAN("cyan"),
	TEAL("teal"),
	GREEN("green"),
	LIGHT_GREEN("light-green"),
	LIME("lime"),
	YELLOW("yellow"),
	AMBER("amber"),
	ORANGE("orange"),
	DEEP_ORANGE("deep-orange"),
	BROWN("brown"),
	GREY("grey"),
	BLUE_GREY("blue-grey");
	
	
	private String colorName;
	private static Random random = new Random();
	
	private MaterialColors(String name){
		this.colorName = name;
	}
	
	public String getColorName(){
		return this.colorName;
	}
	
	public static MaterialColors random(){
		return MaterialColors.values()[random.nextInt(MaterialColors.values().length)];
	}
	
}
