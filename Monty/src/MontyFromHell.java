import java.awt.Font;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * @author hickshj
 *
 *         This is a program that that was created to simulate the infamous
 *         "Monty Hall" problem. A problem that seems so simple at first yet is
 *         so much deeper; even going so far as to stump the famous
 *         mathematician Paul Erdos.
 *
 */
public class MontyFromHell {
	private int doors = 3;
	private HashMap<Integer, Boolean> dMap;
	private int myDoor;
	private double wins = 0, losses = 0;

	/**
	 * @author hickshj
	 * 
	 *         Constructor for Monty.
	 * 
	 * @param N representing the number of trials to be performed.
	 */
	public MontyFromHell(int N, int doors) {
		for (int i = 0; i < N; i++) {
			this.doors = doors;
			this.dMap = assignDoors();
			this.myDoor = chooseDoor();
//			System.out.println(dMap);
//			System.out.println(myDoor);
//			System.out.println(badDoors());

			revealDoors(badDoors());

//			System.out.println(dMap);
			if (dMap.get(myDoor) == true) {
				switchDoor();
			}
//			System.out.println(myDoor);
			countWins();
		}

//		System.out.println("MONTY FROM HELL");
//		System.out.println((int) wins + " Wins " + (int) losses + " Losses");
//		System.out.println("Winning Approximately " + (double) ((wins / N) * 100) + "% of the time");
//		System.out.println("Losing Approximately " + (double) ((losses / N) * 100) + "% of the time");
//		System.out.println((int) wins + "/" + (int) losses + " = " + (wins / losses));

		JFrame results = new JFrame("Results");
		JLabel title = new JLabel("Results", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 50));

		JTextArea text = new JTextArea((int) wins + " Wins " + (int) losses + " Losses\r\n" + "       \r\n"
				+ "Winning Approximately " + (double) ((wins / N) * 100) + "% of the time\r\n" + "As opposed to "
				+ (double) (1 / (double) doors) * 100 + "% without Switching\r\n" + "       \r\n"
				+ "Losing Approximately " + (double) ((losses / N) * 100) + "% of the time\r\n" + "As opposed to "
				+ (double) (100 - (1 / (double) doors) * 100) + "% without Switching\r\n" + "       \r\n" + (int) wins
				+ "/" + (int) losses + " = " + (wins / losses));
		text.setFont(new Font("Arial", Font.PLAIN, 25));
		text.setEditable(false);
		text.setWrapStyleWord(true);
		text.setBackground(results.getBackground());

		results.add(title, SwingConstants.CENTER);
		results.add(text, SwingConstants.CENTER);
		results.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		results.pack();
		results.setVisible(true);

	}

	/**
	 * @author hickshj
	 * 
	 *         Assigns "doors" a random boolean representing either a "Shiny New
	 *         Car" (True) or a "Goat" (False).
	 * 
	 * @return A HashMap of "Doors" with Keys being integers and Entries being a
	 *         boolean representing either a "Shiny New Car" (True) or a "Goat"
	 *         (False)
	 */
	public HashMap<Integer, Boolean> assignDoors() {

		HashMap<Integer, Boolean> dMap = new HashMap<Integer, Boolean>();

		for (int i = 1; i <= doors; i++) {

			if (dMap.values().contains(true) && dMap.isEmpty() != true) {
				dMap.put(i, false);
			} else {
				if ((int) (Math.random() * 100) <= (int) (100 / doors)) {
					dMap.put(i, true);
				} else {
					dMap.put(i, false);
				}
			}

		}

		if (dMap.values().contains(true) != true) {
			dMap.put(dMap.size() - 1, true);
		}

		return dMap;

	}

	/**
	 * @author hickshj
	 * 
	 *         Chooses a random door from the HashMap of doors.
	 * 
	 * @return An int representing the contestant's randomly chosen door
	 */
	public int chooseDoor() {
//		int doorNum = (int) ((Math.random() * DOORS) + 1);

		int doorNum = (int) dMap.keySet().toArray()[new Random().nextInt(dMap.keySet().toArray().length)];

		return doorNum;
	}

	/**
	 * @author hickshj
	 * 
	 * @return A HashMap of doors that contain a "Goat" (False)
	 */
	public HashMap<Integer, Boolean> badDoors() {
		HashMap<Integer, Boolean> badDoors = new HashMap<Integer, Boolean>();
		for (int key : dMap.keySet()) {
			if (dMap.get(key) == false && myDoor != key) {
				badDoors.put(key, dMap.get(key));
			}
		}

		return badDoors;
	}

	/**
	 * @author hickshj
	 * 
	 *         Reveals one of the "Goat" (False) doors
	 * 
	 * @param badDoors
	 */
	public void revealDoors(HashMap<Integer, Boolean> badDoors) {

		Object key = badDoors.keySet().toArray()[new Random().nextInt(badDoors.keySet().toArray().length)];

		dMap.remove(key);

	}

	/**
	 * @author hickshj
	 * 
	 *         Switches to one of the other doors available
	 */
	public void switchDoor() {

//		for (int key : dMap.keySet()) {
//			if (key != myDoor) {
//				myDoor = key;
//				return;
//			}
//		}

		while (true) {
			Object key = dMap.keySet().toArray()[new Random().nextInt(dMap.keySet().toArray().length)];

			if ((int) key != myDoor) {
				myDoor = (int) key;
				return;
			}

		}

	}

	/**
	 * @author hickshj
	 * 
	 *         Counts the total wins and losses for all trials
	 */
	public void countWins() {

		if (dMap.get(myDoor) == true) {
			wins++;
		} else {
			losses++;
		}

	}

}
