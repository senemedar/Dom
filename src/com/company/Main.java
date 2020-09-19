package com.company;

import com.company.enums.Enums.*;

//3. Zaprojektować strukturę obiektów dla domu.
// Potworzyć różne klasy w stylu Room, Media, Floor, zostawiam to do własnej interpretacji.
// Chodzi mi głównie o przeanalizowanie struktury czegoś poza-programistycznego w sposób obiektowy.
// Niech program na przykład tworzy obiekty klasy dom i wyświetla informacje na temat tego domu.

public class Main {

    public static void main(String[] args) {
        // budujemy nowy dom
        House domek = new House(10, 6, 7.5, 3, false, true);
        
        // rozstawiamy pokoje
        Room kuchnia = new Room(TypesOfRoom.KUCHNIA, new Floor(TypesOfFloors.LINOLEUM), 3, 2.5);
        kuchnia.addWindow(new Window(TypesOfWindows.BAROWE, 1.5, 1));
        
        Room holGlowny = new Room(TypesOfRoom.KORYTARZ, new Floor(TypesOfFloors.PARKIET), 1, 6);
        
        domek.addRoom(kuchnia, Levels.PARTER);
        
        domek.listRooms(Levels.PARTER);
        domek.listRooms(Levels.PODDASZE);
        System.out.println(kuchnia.describeRoom());
    }
}
