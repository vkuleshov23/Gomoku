package saves;

import history.*;
import model.*;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;	
import java.lang.ClassNotFoundException;

public class LoadGame {
	private static final String filename = "/home/vadim/Labs/game/gomoku/saves/game_saves.ser";
	public static final Gomoku load() throws IOException, ClassNotFoundException{
		FileInputStream gameSaves = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(gameSaves);
		Gomoku game = (Gomoku) ois.readObject();
		ois.close();
		return game;
	}
}