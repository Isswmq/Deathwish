package com.client.util.font;
import org.lwjgl.util.Color;

public class ChatColor {
	private String color;

	public static final ChatColor RED = new ChatColor("ff0000");

	public static final ChatColor GREEN = new ChatColor("00ff00");

	public static final ChatColor BLUE = new ChatColor("0000ff");

	public static final ChatColor WHITE = new ChatColor("ffffff");

	public static final ChatColor BLACK = new ChatColor("000000");
	
	//TODO
	public static ChatColor mix(String c1, String c2) {
		
		String[] a = c1.split("(?<=\\G.{2})");
		String[] b = c2.split("(?<=\\G.{2})");
		
		System.out.println(c1);
		System.out.println(c2);
		
		String ret = "";
		for (int i = 0; i < a.length; i++) {
			if (Integer.parseInt(a[i]) >= Integer.parseInt(b[i])) {
				ret += a[i];
			} else {
				ret += b[i];
			}
		}
		System.out.println(ret);
		return new ChatColor(ret);
	}
	
	public ChatColor(String colorCode) {
		this.color = colorCode;
	}
	
	public int getRGB() {
		return Integer.parseInt("0x" + color);
	}
	
	public String getRGBString() {
		return color;
	}
}
