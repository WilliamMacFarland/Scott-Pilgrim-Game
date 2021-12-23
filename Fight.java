import java.util.Random;
import java.util.Scanner;
/**
 * This class simulates a fight between an evil ex and scott
 * @author williammacfarland
 *@version 12/23/21
 */

//Can choose between certain types of attacks that could deal more damage, but may be risker (miss percentage 50%).
//punch, kick, dodge or reason

public class Fight {
	private Character evilEx;
	private Character scott;
	private Random rand = new Random();
	
	public Fight(Character e, Character s) {
		this.evilEx = e;
		this.scott = s;
		attack();
	}
	
	public double punch() {
		int num = rand.nextInt(4);
		if(num == 3) {
			return 0;
		}
		else {
			return 1.2;
		}
	}
	
	public double kick() {
		int num = rand.nextInt(5);
		if(num == 3 || num == 4) {
			return 0;
		}
		else {
			return 1.5;
		}
	}
	
	public boolean reason() {
		int num = rand.nextInt(30);
		if(num == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean dodge() {
		int num = rand.nextInt(2);
		if(num == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//simulates an attack from an evilEx
	public void evilExHit() {
		if(evilEx.isAlive()) {
			int hit = (int) (Math.random() * (evilEx.getHpHigh() - evilEx.getHpLow())) + evilEx.getHpLow();
			System.out.println("" + evilEx.getFirstName()+ "'s Hit: " + hit);
			scott.reduceHealth(hit);
			System.out.println("" + evilEx.getFirstName()+ "'s Health: " + evilEx.getHealth());
		}
	}
	
	public void rankOneAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (10 - 5)) + 5;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (10 - 5)) + 5;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	public void rankTwoAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (12 - 7)) + 7;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (12 - 7)) + 7;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	public void rankThreeAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (16 - 11)) + 11;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (16 - 11)) + 11;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	public void rankFourAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (18 - 13)) + 13;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (18 - 13)) + 13;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	public void rankFiveAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (20 - 15)) + 15;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (20 - 15)) + 15;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	public void rankSixAttack(String ans) {
		if (ans.equals("p")) {
			int hp = (int) (Math.random() * (22 - 17)) + 17;
			double punchHp = Math.round(hp*punch()*10.0)/10.0;
			if (punchHp == 0) {
				System.out.println("(Q'-')=O");
				System.out.println("~~~WIFF~~~");
				System.out.println("");
				System.out.println("Your Punch Missed!");
			}
			else {
				System.out.println("(Q'-')=O");
				System.out.println("***BAM***");
				System.out.println("");
				System.out.println("Your Punch Hit!");
			}
			System.out.println("");
			System.out.println("Scott's Hit: " + punchHp);
			evilEx.reduceHealth(punchHp);
			evilExHit();
			System.out.println("Scott's Health: " + scott.getHealth());
		}
		if (ans.equals("k")) {
			int hp = (int) (Math.random() * (22 - 17)) + 17;
			if (hp*kick() == 0) {
				System.out.println("You Missed!");
			}
			System.out.println("Scott's hit: " + hp*kick());
			evilEx.reduceHealth(hp);
			evilExHit();
		}
		if (ans.equals("d")) {
			if (dodge()) {
				System.out.println("NICE! You Dodged Successfully!");
			}
			else {
				System.out.println("UH OH! You Dodged Unsuccessfully!");
				evilExHit();
			}
		}
		if (ans.equals("r")) {
			if (reason()) {
				System.out.println("WOWZA! You Reasoned Like a Pro!");
				System.out.println("The REASON hit: " + evilEx.getHealth());
				evilEx.reduceHealth(evilEx.getHealth());
			}
			else {
				System.out.println("UH OH! You Reasoned Unsuccessfully!");
				evilExHit();
			}
		}
	}
	
	//"press a to attack!"
	//scott always gets first hit
	public boolean attack() {
		if (evilEx.isAlive() && scott.isAlive()) {
			System.out.print("\n");
			System.out.println("It's Time To Attack!");
			System.out.println("(ง •̀_•́)ง");
			System.out.println("---------------------");
			System.out.println("Punch: p");
			System.out.println("Kick: k");
			System.out.println("Dodge: d");
			System.out.println("Reason: r");
			System.out.println("---------------------");
			Scanner input = new Scanner(System.in);
			String response = input.nextLine();
			String ans = response.toLowerCase();
			
			while (ans.equals("p") || ans.equals("k") || ans.equals("d") || ans.equals("r")) {
				//----RANK 1 ATTACK SIMULATION-----------------------//
				if(scott.getRank() == 1 && scott.isAlive()) {
					rankOneAttack(ans);
				}
				//----RANK 2 ATTACK SIMULATION-----------------------//
				else if(scott.getRank() == 2 && scott.isAlive()) {
					rankTwoAttack(ans);
				}
				//----RANK 3 ATTACK SIMULATION-----------------------//
				else if(scott.getRank() == 3 && scott.isAlive()) {
					rankThreeAttack(ans);
				}
				//----RANK 4 ATTACK SIMULATION-----------------------//
				else if(scott.getRank() == 4 && scott.isAlive()) {
					rankFourAttack(ans);
				}
				//----RANK 5 ATTACK SIMULATION-----------------------//
				else if(scott.getRank() == 5 && scott.isAlive()) {
					rankFiveAttack(ans);
				}
				//----RANK 6 ATTACK SIMULATION-----------------------//
				else if(scott.getRank() == 6 && scott.isAlive()) {
					rankSixAttack(ans);
				}
				if (!evilEx.isAlive() || !scott.isAlive()) {
					break;
				}
				System.out.println("");
				System.out.println(evilEx.getFirstName() + " is still alive! Hit them again!");
				System.out.println("---------------------");
				System.out.println("Punch: p");
				System.out.println("Kick: k");
				System.out.println("Dodge: d");
				System.out.println("Reason: r");
				System.out.println("---------------------");
				response = input.nextLine();
				ans = response.toLowerCase();
			}
		}
		if(scott.isAlive()) {
			scott.rankUp();
			scott.restoreHealth();
			return true;
		}
		else {
			return false;
		}
	}

	public String printWinner() {
		if (attack()) {
			return "Scott";
		}
		else {
			return evilEx.getFirstName();
		}
	}

}
