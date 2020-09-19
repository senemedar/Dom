package com.company;

import com.company.enums.Enums;
import com.company.enums.Enums.Levels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class House {
//	private ArrayList<Room> rooms = new ArrayList<>();	// lista pokoi
	private ArrayList<Window> windows = new ArrayList<>();	// lista okien
	private double width;
	private double heigth;
	private double length;
	private final HashMap<Levels, ArrayList<Room>> listOfLevels = new HashMap<>();
	
	public House(double width, double length, double heigth, int noOflevels, boolean hasBasement, boolean hasAttic) {
		this.width = width;
		this.length = length;
		this.heigth = heigth;
		
		for (int i = 0; i < noOflevels; i++) {
			if (i <= Levels.values().length - 2) {
				listOfLevels.put(Levels.values()[i], new ArrayList<>());
			}
		}
		
		if (hasBasement) {
			// jeżeli dom ma piwnicę, do automatycznie dodajemy ją do listy jako garaż zajmujący całą jej powierzchnię
			listOfLevels.put(Levels.PIWNICA,
					new ArrayList<>(Collections.singletonList(
							new Room(Enums.TypesOfRoom.GARAŻ, new Floor(Enums.TypesOfFloors.KAMIENNA), length, width))));
//			listOfLevels.get(Levels.PIWNICA).add(new Room(Enums.TypesOfRoom.GARAŻ, length, width));
		}
		if (hasAttic) {
			// jeżeli dom ma poddasze, to analogicznie jak z piwnicą
			listOfLevels.put(Levels.PODDASZE,
					new ArrayList<>(Collections.singletonList(
							new Room(Enums.TypesOfRoom.POKÓJ, new Floor(Enums.TypesOfFloors.PARKIET), length, width))));
//			listOfLevels.get(Levels.PODDASZE).add(new Room(Enums.TypesOfRoom.POKÓJ, length, width));
		}
	}
	
	public void addRoom (Room room, Levels level) {
		// getting the list of rooms first, so I can add a room to it
		listOfLevels.get(level).add(room);
	}
	
	public void removeRoom (Room room, Levels level) {
		listOfLevels.get(level).remove(room);
	}
	
	public double getHeigth() {
		return heigth;
	}
	
	public double getLength() {
		return length;
	}
	
	public void listRooms(Levels level) {
		System.out.println("Pokoje, które znajdują się na piętrze " + level + ":");
		for (Room room : listOfLevels.get(level)) {
			System.out.println(room.getRoomType());
		}
	}
}
