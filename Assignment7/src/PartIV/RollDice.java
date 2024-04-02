package PartIV;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RollDice extends JFrame {

	private ImagePanel dice1, dice2;
	private JLabel sumLabel;
	private JButton rollButton;
	private int delay = 200;

	public RollDice() {

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createVerticalBox();

		dice1 = new ImagePanel("die1.png");
		dice2 = new ImagePanel("die1.png");

		dice1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				roll(dice1);
			}
		});
		dice2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				roll(dice2);
			}
		});

		sumLabel = new JLabel("Result: " + 2);

		rollButton = new JButton("Roll Dice");
		rollButton.addActionListener(e -> {
			roll(dice1);
			roll(dice2);
		});

		b1.add(dice1);
		b1.add(Box.createHorizontalStrut(30));
		b1.add(dice2);
		JPanel p1 = new JPanel();
		p1.add(b1);

		JPanel p21 = new JPanel();
		p21.add(sumLabel);
		b2.add(p21);
		b2.add(Box.createVerticalStrut(20));
		JPanel p22 = new JPanel();
		p22.add(rollButton);
		b2.add(p22);

		JPanel p2 = new JPanel();
		p2.add(b2);

		b.add(p1);
		b.add(Box.createVerticalStrut(20));
		b.add(p2);

		setContentPane(b);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setVisible(true);
	}

	private void roll(ImagePanel dice) {
		int times = (int) (Math.random() * 3) + 3;
		ActionListener taskPerformer = new ActionListener() {
			int counter = 0;

			@Override
			public void actionPerformed(ActionEvent evt) {
				if (counter < times) {
					int roll = (int) (Math.random() * 6) + 1;
					dice.setNum(roll);
					counter++;
				} else {
					((Timer) evt.getSource()).stop();
					updateSum();
				}
			}
		};
		new Timer(delay, taskPerformer).start();
	}

	private void updateSum() {
		int sum = dice1.getNum() + dice2.getNum();
		sumLabel.setText("Result: " + sum);
	}

	public static void main(String[] args) {
		new RollDice();
	}
}
