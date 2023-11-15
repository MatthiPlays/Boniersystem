package com.zeindler.boniersystem.server;

import com.zeindler.boniersystem.veranstaltung.Kellner;
import com.zeindler.boniersystem.veranstaltung.Veranstaltung;

public class Connector {

    //Connector zum Webserver
    //Am Webserver sind natürlich mehrere Veranstaltungen gespeichert, der Webserver entscheidet welche die aktuelle ist

    public Connector(){

    }

    public static Veranstaltung getVeranstaltung(){
        //TODO: importieren vom Webserver

        return new Veranstaltung("FF-Heuriger Unterretzbach");
    }

    public static Kellner[] getKellner(){
        //TODO: Kellner importieren
        Kellner[] kellner = new Kellner[12];
        kellner[0]=new Kellner(0,"Katrin");
        kellner[1]=new Kellner(1,"Florian");
        kellner[2]=new Kellner(2,"Jennifer");
        kellner[3]=new Kellner(3,"Reinhard");
        kellner[4]=new Kellner(0,"Katrin");
        kellner[5]=new Kellner(1,"Florian");
        kellner[6]=new Kellner(2,"Jennifer");
        kellner[7]=new Kellner(3,"Reinhard");
        kellner[8]=new Kellner(0,"Katrin");
        kellner[9]=new Kellner(1,"Florian");
        kellner[10]=new Kellner(2,"Jennifer");
        kellner[11]=new Kellner(3,"Reinhard");

        return kellner;
    }
}
