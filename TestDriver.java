import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A TEST driver that can be modified to your choosing
 * @author williammacfarland
 *
 */
public class TestDriver {
	private static ArrayList<Character> characterList = new ArrayList<Character>();
	private static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//READ IN CHARACTERS
		try {
			Scanner charFile = new Scanner(new File("characters.txt"));
			String loop1 = charFile.nextLine();
			for(int i=0; i<Integer.parseInt(loop1); i++) {
				Character newCharacter = new Character(charFile.nextLine(), 
						                               charFile.nextLine(), 
						                               Integer.parseInt(charFile.nextLine()), 
						                               Boolean.getBoolean(charFile.nextLine()), 
						                               Boolean.getBoolean(charFile.nextLine()), 
						                               charFile.nextLine(), 
						                               Integer.parseInt(charFile.nextLine()), 
						                               Integer.parseInt(charFile.nextLine()), 
						                               Integer.parseInt(charFile.nextLine()));
				characterList.add(newCharacter);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("The character file was not found");
		}	
		System.out.println("										SCOTT PILGRIM VS. THE WORLD");
		System.out.println("										---------------------------");
		System.out.println("											 Version 1");
		System.out.println("");
		System.out.println("");
		System.out.println("										    Press 'S' to start!");
		Scanner input = new Scanner(System.in);
		String play = input.nextLine();
		String ans = "";
		while(play.equals("s") || play.equals("r")) {
			DecisionTree tree = new DecisionTree("story.txt");
			tree.reset();
			while(!tree.isResult()) {
				if (tree.isFightNode()) {
					Fight simFight = new Fight(characterList.get(count), characterList.get(0));
					boolean fightResult = simFight.attack();
					count++;
					if(!fightResult) {
						System.out.println("");
						System.out.println("You died fighting " + simFight.printWinner());
						break;
					}
				}
				System.out.print(tree.getCurrentText());
				ans = input.nextLine();
				try {
					tree.nextQuestion(ans);
				}
				catch (NoSuchElementException e) {
					System.out.println("Invalid response");
				}
			}
			System.out.println("");
			System.out.println("Press 'R' to restart");
			play = input.nextLine();
			
		}
		

	}
}
