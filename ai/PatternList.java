package ai;

import java.io.IOException;

public class PatternList {
	
	public static final char cross = 'X';
	private static final int crossOffset = 0;
	
	public static final char zero = 'O';
	private static final int zeroOffset = 18;

	public static final int size = 18;

	public static Pattern[] patterns = {
		new Pattern("XXXXX", 99999),
		new Pattern(" XXXX ", 7000),
		new Pattern(" XXXX", 4000),
		new Pattern("XXXX ", 4000),
		new Pattern(" X XXX", 2000),
		new Pattern(" XX XX", 2000),
		new Pattern(" XXX X", 2000),
		new Pattern("XXX X ", 2000),
		new Pattern("XX XX ", 2000),
		new Pattern("X XXX ", 2000),
		new Pattern(" XXX ", 3000),
		new Pattern(" XXX", 1500),
		new Pattern("XXX ", 1500),
		new Pattern(" XX X", 800),
		new Pattern(" X XX", 800),
		new Pattern("XX X ", 800),
		new Pattern("X XX ", 800),
		new Pattern(" XX ", 200),
		
		new Pattern("OOOOO", 99999),
		new Pattern(" OOOO ", 7000),
		new Pattern(" OOOO", 4000),
		new Pattern("OOOO ", 4000),
		new Pattern(" O OOO", 2000),
		new Pattern(" OO OO", 2000),
		new Pattern(" OOO O", 2000),
		new Pattern("OOO O ", 2000),
		new Pattern("OO OO ", 2000),
		new Pattern("O OOO ", 2000),
		new Pattern(" OOO ", 3000),
		new Pattern(" OOO", 1500),
		new Pattern("OOO ", 1500),
		new Pattern(" OO O", 800),
		new Pattern(" O OO", 800),
		new Pattern("OO O ", 800),
		new Pattern("O OO ", 800),
		new Pattern(" OO ", 200)
	};

	public static Pattern getPattern(int i, char player) throws IOException{
		if(i > 17 || i < 0)
			throw new IOException("OutOfMemoryError");
		if(player != 'X' && player != 'O')
			throw new IOException("Player Char is wrong");

		if(player == cross){
			i += crossOffset;
		} else {
			i += zeroOffset;
		}

		return patterns[i];
	}
}