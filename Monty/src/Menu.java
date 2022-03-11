import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
	private JFrame menu;

	public Menu() {

		this.menu = new JFrame("Monty Hall");

		JButton standard = new JButton("Standard Monty");
		JButton hell = new JButton("Monty From Hell");
		JButton angel = new JButton("Angelic Monty");
		JPanel options = new JPanel();

		JLabel title = new JLabel("The Monty Hall Problem", SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 50));

		JTextArea text = new JTextArea(
				"This is a game show where there are three doors – behind a uniformly randomly chosen door is a shiny\r\n"
						+ "new car, and behind each of the other two, an old goat. The contestant chooses a door but does not\r\n"
						+ "open it; the host (who knows what’s behind all of the doors) then opens one of the other two doors\r\n"
						+ "to reveal a goat (this is always possible, since at least one of the doors which is not chosen by the\r\n"
						+ "contestant must have a goat behind it). The contestant then has the option to switch and pick the\r\n"
						+ "other closed door, or stick with his current door. He ends up winning what’s behind the door which he\r\n"
						+ "ultimately goes with. Should he switch to the other closed door?\r\n"
						+ "**Standard Monty** is the usual game with no change to Monty's behavior.\r\n"
						+ "**Monty From Hell** is a variant where Monty only offers to switch if your first guess was the door with the car.\r\n"
						+ "This leads to an expected but reasonable result. Worry not, dear friend, all code is present despite the simple result\r\n"
						+ "**Angelic Monty** is a variant where Monty only offers to switch if you've chosen a goat door.\r\n"
						+ "This leads to the exact opposite of Monty From Hell.\r\n"
						+ "After Selecting a game, you will be presented with two text boxes. The first box allows you to input the amount\r\n"
						+ "trials that will be performed.\r\n"
						+ "The second box is for the number of doors to use in those trials.");
		text.setFont(new Font("Arial", Font.PLAIN, 25));
		text.setEditable(false);
		text.setWrapStyleWord(true);
		text.setBackground(menu.getBackground());

		standard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				new Monty(10000, 3);

				new TrialsFrame(1);

				menu.dispose();
			}

		});

		hell.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TrialsFrame(2);
				menu.dispose();
			}

		});

		angel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new TrialsFrame(3);
				menu.dispose();
			}

		});

		options.add(standard);
		options.add(hell);
		options.add(angel);
		menu.add(title, BorderLayout.NORTH);
		menu.add(text);
		menu.add(options, BorderLayout.SOUTH);

		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.pack();
		menu.setVisible(true);
	}

}