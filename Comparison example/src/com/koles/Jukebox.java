package com.koles;

import java.io.*;
import java.util.*;



public class Jukebox {
	
	ArrayList<Song> songList = new ArrayList<Song>();
	public void go() {
		getSong();
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
	}
	
	private void getSong() {
		try {
			File file = new File("SongList.txt");
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = null;
			while((line = reader.readLine()) != null) {
				addSong(line);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void addSong(String lineToParse) {
		String[] tokens = lineToParse.split("/");
		Song nextSong = new Song(tokens[0], tokens[1], tokens[2], tokens[3]);
		songList.add(nextSong);
	}

}
