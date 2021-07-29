package saves;

import history.*;
import model.*;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;	
import java.lang.ClassNotFoundException;

public class LoadGame {
	private static final String way = "/home/vadim/Labs/game/gomoku/saves/";
	private static final String extension = ".ser";
	public static final Gomoku load(String name) throws IOException, ClassNotFoundException{
		String filename = way + name + extension;
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Gomoku game = (Gomoku) ois.readObject();
		ois.close();
		return game;
	}
}