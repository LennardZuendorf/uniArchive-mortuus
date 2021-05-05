package de.htwberlin.prog1.sose20.zombies.model;

import java.util.UUID;

/**
 * 
 * @version 1.1
 * @since 01.07.2020 - Abschluss der Entwicklung
 * 05.07.2020 - finaler Checl + Abschluss der Dokumentation
 * @author Lennard Z�ndorf, E-Mail: s0568383@htw-berlin.de
 * Beschreibung: Die Klasse ZombieHunter beschreibt einen ZombieHunter als Bestandteil des ZombieSpieles, genauer seine Attribute & Operationen
 */
public class ZombieHunter {
	
	//Attribute
	private String id;
	String name;
	private int experiencePoints;
	private int healthPointsCurrent;
	
	//Konstruktor
	
	/**
	 * Methode ZombieHunter
	 * Beschreibung: Konstruktor der Klasse ZombieHunter, in dem grundlegende Attribute festgelegt werden
	 * @param name �bernimmt den Names, den der ZombieHunter erhalten soll
	 */
	public ZombieHunter(String name){
		this.setId(UUID.randomUUID().toString());//zuf�llige ID-Erstellung
		this.name=name;//�bernahme des Names
		this.setExperiencePoints(0);//immer gleiche ExperiencePoints
		this.healthPointsCurrent=1000;//immer gleiche Lebenspunkte
	}

	//Operationen
	
	/**
	 * Methode attack
	 * Beschreibung: Die Methode f�hrt einen Angriff des ZombiesHunter auf einen Zombie durch
	 * @param Target �bernimmt das Ziel des Angriffes vom Typ Zombie
	 */
	public void attack(Zombie Target) {
		if((int)(Math.random() *2)+1==1) { //Test ob 50% Chance erf�llt, wenn nicht ist Angriff nicht erfolgreich
			System.out.println("Der ZombieHunter "+this.getName()+" hat erfolgreich angegriffen!");
			Target.takeDamage(5);//ZombieHunter macht immer 5 Schaden, wenn erfolreich, ausf�hrung der takeDamage-Methode des Ziels
		}else {//Ausgabe wenn Angriff nicht erfolgreich
			System.out.println("Der ZombieHunter "+this.getName()+" hat nicht getroffen!");
		}
	}
	
	/**
	 * Methode attackSuperZombie
	 * Beschreibung: Die Methode f�hrt einen Angriff des ZombiesHunter auf einen Zombie durch, analog zur Methode attack
	 * @param Target �bernimmt das Ziel des Angriffes vom Typ SuperZombie
	 */
	public void attackSuperZombie(SuperZombie Target) {//Die Methode ist prinzipiell gleich wie die attack-Methode, deswegen keine Kommentare
		if((int)(Math.random() *2)+1==1) {
			System.out.println("Der ZombieHunter "+this.getName()+" hat erfolgreich angegriffen!");
			Target.takeDamage(5);
		}else {
			System.out.println("Der ZombieHunter "+this.getName()+" hat nicht getroffen!");
		}
	}
	
	/**
	 * Methode takeDamage
	 * Beschreibung: Die Methode verbucht den Schaden der einem ZombieHunter zugef�gt wurde
	 * @param Damage �bernimmt den Schaden, der dem ZombieHunter hinzugef�gt werden soll
	 */
	public  void takeDamage(int Damage) {
		this.healthPointsCurrent=this.healthPointsCurrent-Damage;//"verbuchen" des Schadens
		System.out.println("Der ZombieHunter "+this.getName()+" hat "+Damage+" Schaden erlitten.");
	}
	
	/**
	 * Methode flee
	 * Beschreibung: Die Methode gibt lediglich aus, das ein ZombieHunter nicht flieht
	 */
	public void flee() {
		System.out.println("Ein ZombieHunter flieht nicht!");
	}
	
	/**
	 * Methode alive
	 * Beschreibung: Die Methode gibt aus ob der ZombieHunter am leben ist (solange er mehr als 0 Lebenspunkte hat)
	 * @return gibt true aus wenn der ZombieHunter lebt und false wenn nicht
	 */
	public boolean alive() {
		if (this.healthPointsCurrent>0) {//�berpr�fung ob der ZombieHunter mehr als 0 Lebenspunkte hat
			return true; // Ausgabe wenn der ZombieHunter noch lebt
		}else {
			return false;// Ausgabe wenn der ZombieHunter nicht mehr lebt
		}
	}

	//Getter & Setter
	
	/**
	 * Methode getId
	 * Beschreibung: Die Methode gibt die ID des ZombieHunters aus
	 * @return gibt den wert des Parameters id aus
	 */
	public String getId() {
		return id;
	}

	/**
	 * Methode setId
	 * Beschreibung: Die Methode legt die ID des ZombieHunters fest
	 * @param id �bernimmt den Wert, der als id festgelegt werden soll
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Methode getName
	 * Beschreibung: Die Methode gibt den Names des ZombieHunters aus
	 * @return gibt den Wert des Parameters name aus
	 */
	public String getName() {
		return name;
	}

	/**
	 * Methode getExperiencePoints
	 * Beschreibung: Die Methode gibt die Erfahrung (experiencePoints) des ZombieHunters aus
	 * @return
	 */
	public int getExperiencePoints() {
		return experiencePoints;
	}

	/**
	 * Methode setExperiencePoints
	 * Beschreibung:Die Methode legt die Erfahrung des ZombieHunter fest
	 * @param experiencePoints �bernimmt den neuen Wert der in den Parameter experiencePoints eingetragen wird
	 */
	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}
	
	/**
	 * Methode getHealthPointsCurrent
	 * Beschreibung: Die Methode gibt die Lebenspunkte (HealthPointsCurrent) des ZombieHunters aus
	 * @return gibt den Wert des Parameters healthPointsCurrent aus
	 */
	public int getHealthPointsCurrent() {
		return healthPointsCurrent;
	}

	/**
	 * Methode setHealthPointsCurrent
	 * Beschreibung: Die Methode legt die Lebenspunkte (HealthPointsCurrent) des ZombieHunters fest
	 * @param HealthPoints �bernimmt den neuen Wert, der als Lebenspunkte (HealthPointsCurrent) eingetragen werden soll
	 */
	public void setHealthPointsCurrent(int HealthPoints) {
		this.healthPointsCurrent = HealthPoints;
	}
	

}

