package PartIV;

import javax.swing.JFrame;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RollDice extends JFrame {

	private ImagePanel dice1, dice2;
	private JLabel sumLabel;
    private JButton rollButton;
	
	public RollDice() {

		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
 		Box b2 = Box.createVerticalBox();

		dice1 = new ImagePanel("Assignment7/die1.png");
		dice2 = new ImagePanel("Assignment7/die1.png");

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
			}
		);

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
		// int times = (int) (Math.random() * 5) + 1;
		int times = 3;
		for (int i = 0; i < times; i++) {
			int roll = (int) (Math.random() * 6) + 1;
			dice.setNum(roll);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		updateSum();
	}

	private void updateSum() {
		int sum = dice1.getNum() + dice2.getNum();
		sumLabel.setText("Result: " + sum);
	}

	public static void main(String[] args) {
		RollDice rollDice = new RollDice();
	}
}
