package saves;

import history.*;
import model.*;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;	

public class GameSave {
	private static final String filename = "/home/vadim/Labs/game/gomoku/saves/game_saves.ser";
	public static final void save(Gomoku game) throws IOException{
		FileOutputStream gameSaves = new FileOutputStream(filename);
		ObjectOutputStream oos = new ObjectOutputStream(gameSaves);
		oos.writeObject(game);
		oos.close();
	}
}