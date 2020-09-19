package com.company;
import com.company.enums.Enums.TypesOfRoom;

import java.util.ArrayList;

public class Room {
	// private variables
	private double height;
	private double width;
	private double length;
	private int level;
	private TypesOfRoom type;
	private Floor floor;
	
	private ArrayList<Window> windows = new ArrayList<>();	// pokoje mogą mieć okna
	
	// constructors
	public Room(TypesOfRoom type, Floor floor, double width, double length, double... height) {
		if (height.length > 0) {
			this.height = height[0];
		} else {
			this.height = 2.4;
		}
		this.width = width;
		this.length = length;
		this.type = type;
		this.floor = floor;
	}
	
	public void addWindow(Window window) {
		windows.add(window);
	}
	
	public void removeWindow(Window window) {
		windows.remove(window);
	}
	
	public int getNumberOfWindows() {
		return windows.size();
	}
	
	public double getSurface() {
		return this.width * this.length;
	}
	
	public String getRoomType() {
		return this.type.name();
	}
	
	public String getFloorType() {
		return this.floor.getFloorType();
	}
	
	public String describeRoom() {
		StringBuilder descr = new StringBuilder();
		descr.append("-------\n")
				.append("Pokój: ").append(getRoomType())
				.append(".\nJego całkowita powierzchnia to: ").append(getSurface())
				.append(" m\u00B2.\n")
				.append(this.floor.getFloorDescription());
		
		// ile mamy okien?
		int windowsNo = getNumberOfWindows();
		if (windowsNo != 0) {
			descr.append("Pokój posiada: ").append(windowsNo);
			if (windowsNo == 1) {
				descr.append(" okno.");
			} else if (windowsNo > 1 && windowsNo < 5 ) {
				descr.append(" okna.");
			} else {
				descr.append(" okien.");
			}
		} else {
			descr.append("Pokój nie posiada okien");
		}
		
		return descr.toString();
	}
}
