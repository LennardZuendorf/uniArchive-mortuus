package de.htwberlin.prog1.sose20.zombies.app;

import java.util.Scanner;

/**
 * 
 * @version 1.2
 * @since 15.06.2020 - �bernahme aus Moodle
 * 01.07.2020 - Abschlus der Entwicklung
 * 05.07.2020 - finaler Check + Abschluss der Dokumentation
 * @author Prof. Dr. Verena Majuntke
 * Angepasst durch Lennard Z�ndorf, E-Mail: s0568383@htw-berlin.de
 * Beschreibung: Die Klasse Streifzug f�hrt den Konsolendialog Streifzug durch die Nacht aus
 */

public class Streifzug {
	
	//Attribute
	private static Scanner scanner = new Scanner(System.in);

	/**
	 * Methode main
	 * Beschreibung: main Methode der Klasse, bildet das Framework 
	 */
	public static void main() {
	
		while (true) {
			showMenu();
			int choice = readUserInput();
			handle(choice);
			System.out.println("\n\n====================");
		}
	}
	
	/**
	 * Methode: showMenu
	 * Beschreibung: Die Methode gibt die einzellnen Men�-Optionen des Konsolendialoges auf der Konsole aus
	 */
	private static void showMenu() {
		String menuItems[] = { "", "(1)\t Erkunden ","(2)\t Tanzen","(3)\t Streifzug beenden"};
		System.out.println("\nStreifzug durch die Nacht\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}
	}
	
	/**
	 * Methode handle
	 * Beschreibung: Die Methode f�hrt je nach Eingabe des Nutzer andere Befehle aus (1-6)
	 * @param choice �bernimmt die Auswahl der Nutzers (choice), die von der Methode readUserInput zur Verf�gung gestellt wurde
	 */
	private static void handle(int choice) {
		switch (choice) {
			case 1://Erkundung
				Action.main();//f�hrt die Klasse Action aus, die den Konsolendialog Erkundung abbildet
				System.out.println("\n\n====================");
				break;
			case 2://Tanzen
				int zufall = (int)(Math.random()*5)+1;//W�hlt zuf�llig aus, wer tanzen soll, 20% Wahrscheinlichkeit f�r jede Option
				if (zufall==1) {//Option 1
					System.out.println("Die gesamte Gruppe f�ngt an zu tanzen.");
					ZombiesApp.Alpha.dance();//Ausf�hrung der dance-Methode des SuperZombies
				}else if(zufall==2&&ZombiesApp.Alpha.ZombieGroup[0]!=null) {//Option 2 (inkl. Kontrolle ob Zombie noch besteht, um NullPointerException zu verhindern)
					ZombiesApp.Alpha.ZombieGroup[0].dance();//1. Anh�nger tanzt..
				}else if(zufall==3&&ZombiesApp.Alpha.ZombieGroup[1]!=null) {//Option 3 (inkl. Kontrolle ob Zombie noch besteht, um NullPointerException zu verhindern)
					ZombiesApp.Alpha.ZombieGroup[1].dance();//...
				}else if(zufall==4&&ZombiesApp.Alpha.ZombieGroup[2]!=null) {//Option 4 (inkl. Kontrolle ob Zombie noch besteht, um NullPointerException zu verhindern)
					ZombiesApp.Alpha.ZombieGroup[2].dance();
				}else if(zufall==5&&ZombiesApp.Alpha!=null) {//Option 5 (inkl. Kontrolle ob Zombie noch besteht, um NullPointerException zu verhindern)
					ZombiesApp.Alpha.dance();
				} else {//Auffang-Option, falls es keine Anh�nger (mehr) gibt 
					ZombiesApp.Alpha.dance();
				}
				break;
			case 3://Streifzug beendet
				System.out.println("\n\n====================");
				ZombiesApp.main(null);//f�hrt die Klasse ZombiesApp aus, kehrt zum Hauptmen� zur�ck
				break;
			default: {//Abfang-Methode bei falscher Eingabe (z.B. falsche Zahl)
				System.out.println("\nUngueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
				showMenu();
			}
		}
	}
	
	/**
	 * Methode: readUserInput
	 * Beschreibung: lie�t die Eingabe des Nutzer auf der Konsole ein und gibt diese aus
	 * @return choiceInternal Ausgabe der Eingabe des Nutzer auf der Konsole
	 */
	private static int readUserInput() {
		System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein:\t");
		int choiceInternal = scanner.nextInt();
		return choiceInternal;
	}
}

	