package saves;
import view.*;

import history.*;
import model.*;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;	

public class GameSave {
	private static final String way = "/home/vadim/Labs/game/gomoku/saves/";
	private static final String extension = ".ser";
	public static final void save(Gomoku game, String name) throws IOException{
		String filename = way + name + extension;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		oos.writeObject(game);
		oos.close();
	}
}