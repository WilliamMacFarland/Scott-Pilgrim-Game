/**
 * This class implements the basic functionalities of a character in our story
 * @author williammacfarland
 * @version 12/23/21
 *
 */

public class Character {
	private String firstName;
	private String lastName;
	private int health;
	private boolean extraLife;
	private boolean weapon;
	private String backStory;
	private boolean alive = true;
	private int rank = 1;
	private int hpHigh;
	private int hpLow;
	
	public Character(String f, String l, int h, boolean e, boolean w, String b, int r, int hpH, int hpL) {
		this.firstName = f;
		this.lastName = l;
		this.health = h;
		this.extraLife = e;
		this.weapon = w;
		this.backStory = b;
		this.rank=r;
		this.hpHigh = hpH;
		this.hpLow = hpL;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getBackstory() {
		return this.backStory;
	}
	
	public int getHealth() {
		if (health<0) {
			this.health=0;
		}
		return this.health;
	}
	
	public boolean hasWeapon() {
		return this.weapon;
	}
	
	public boolean hasExtraLife() {
		return this.extraLife;
	}
	
	public void giveWeapon() {
		this.weapon = true;
	}
	
	public void giveExtraLife() {
		this.extraLife = true;
	}
	
	public void reduceHealth(double hp) {
		this.health -= hp;
	}
	
	public int getRank() {
		return this.rank;
	}
	
	public int getHpHigh() {
		return this.hpHigh;
	}
	
	public int getHpLow() {
		return this.hpLow;
	}
	
	public void restoreHealth() {
		if(rank == 1) {
			this.health = 100;
		}
		if(rank == 2) {
			this.health = 110;
		}
		if(rank == 3) {
			this.health = 150;
		}
		if(rank == 4) {
			this.health = 170;
		}
		if(rank == 5) {
			this.health = 190;
		}
		if(rank == 6) {
			this.health = 200;
		}
	}
	
	//exclusively just used for scott
	public void rankUp() {
		this.rank++;
		if(getRank() > 3) {
			giveWeapon();
		}
	}
	
	//must check if alive every time the character is hit!
	public boolean isAlive() {
		if(health<=0 && !hasExtraLife()) {
			this.alive = false;
			return this.alive;
		}
		else if (health<= 0 && hasExtraLife()){
			//use extra life
			this.extraLife = false;
			restoreHealth();
			return this.alive;
		}
		else {
			return this.alive;
		}
	}

}
