package com.company;

import com.company.enums.Enums.TypesOfFloors;
import com.company.enums.Enums.Decorations;
import java.util.ArrayList;

public class Floor {
	private TypesOfFloors type;
	private ArrayList<Decorations> decorations;
	
	public Floor(TypesOfFloors type) {
		this.type = type;
		// lista, bo może być więcej niż jedna dekoracja
		this.decorations = new ArrayList<>();
	}
	
	public String getFloorType() {
		return this.type.name();
	}
	public void decorateRoom(Decorations decor) {
		this.decorations.add(decor);
	}
	
	public String getFloorDescription() {
		StringBuilder descr = new StringBuilder();
		descr.append("Podłoga to: ").append(this.type.name());
		if (decorations.size() != 0) {
			descr.append("\nNa (w) podłodze znajdują się:\n");
			for (Decorations decor : decorations) {
				descr.append(decor.name()).append("\n");
			}
		} else {
			descr.append("\nNa podłodze nie stoją żadne mebli.\n");
		}
		
		return descr.toString();
	}
}
