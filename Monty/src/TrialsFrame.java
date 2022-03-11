import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TrialsFrame {

	private JFrame frame;
	private JTextField trials;
	private JTextField doors;

	public TrialsFrame(int gameType) {
		frame = new JFrame("Custom Game");

		JPanel organizer = new JPanel();
		JButton start = new JButton("Start Game");
		trials = new JTextField("TRIALS");
		doors = new JTextField("DOORS");

		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (gameType == 1) {
					int trial = Integer.parseInt(trials.getText().toString());
					int door = Integer.parseInt(doors.getText().toString());
					new Monty(trial, door);
				}
				if (gameType == 2) {
					int trial = Integer.parseInt(trials.getText().toString());
					int door = Integer.parseInt(doors.getText().toString());
					new MontyFromHell(trial, door);
				}
				if (gameType == 3) {
					int trial = Integer.parseInt(trials.getText().toString());
					int door = Integer.parseInt(doors.getText().toString());
					new AngelicMonty(trial, door);
				}

				frame.dispose();

			}

		});

		organizer.add(trials);
		organizer.add(doors);
		organizer.add(start);
		frame.add(organizer);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

	}

}
