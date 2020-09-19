package com.company;

enum TypesOfWindows {
	DACHOWE,
	BOCZNE,
	BAROWE
}

enum DecorationsOfWindows {
	ZWYKŁE,
	DYMIONE,
	KOLOROWE,
	ZBITE
}

public class Window {
	private double width;
	private double heigth;
	private TypesOfWindows type;
	private DecorationsOfWindows decorations;
	
	public Window(TypesOfWindows type, double width, double heigth ) {
		this.width = width;
		this.heigth = heigth;
		this.type = type;
	}
	
	public void breakWindow() {
		this.decorations = DecorationsOfWindows.ZBITE;
		System.out.println("Gratulacje! Właśnie zbiłeś okno...");
	}
	
}
