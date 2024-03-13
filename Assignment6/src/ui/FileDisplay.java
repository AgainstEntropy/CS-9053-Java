package ui;

import java.awt.BorderLayout;

import javax.swing.*;

import encode.Encoder;
import files.FileUtils;

public class FileDisplay extends JFrame {

	JTextArea textArea;

	public FileDisplay() {

		setSize(500, 500);
		createMenu();
		createControlPanel();
		createDataPanel();

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem open = new JMenuItem("Open File");
		JMenuItem save = new JMenuItem("Save File");
		JMenuItem exit = new JMenuItem("Exit");

		open.addActionListener(e -> load(""));
		save.addActionListener(e -> save(""));
		exit.addActionListener(e -> System.exit(0));

		fileMenu.add(save);
		fileMenu.add(open);
		fileMenu.add(exit);
		menuBar.add(fileMenu);

		setJMenuBar(menuBar);
	}

	private void createControlPanel() {
		JPanel controlPanel = new JPanel();

		JLabel prompt = new JLabel("Encoding Method");
		JComboBox<String> methods = new JComboBox<>();
		methods.addItem("ROT13");
		methods.addItem("Numeric");

		JButton encode = new JButton("Encode");

		encode.addActionListener(e -> {
			String method = (String) methods.getSelectedItem();
			String encoded = Encoder.encode(textArea.getText(), method);
			textArea.setText(encoded);
		});

		controlPanel.add(prompt);
		controlPanel.add(methods);
		controlPanel.add(encode);

		add(controlPanel, BorderLayout.NORTH);
	}

	private void createDataPanel() {

		JPanel dataPanel = new JPanel();

		final int ROWS = 20;
		final int COLUMNS = 40;
		textArea = new JTextArea(ROWS, COLUMNS);
		textArea.setEditable(false);

		dataPanel.add(textArea);

		add(dataPanel, BorderLayout.CENTER);
	}

	private void save(String dir) {
		JFileChooser j = new JFileChooser(dir);
		int r = j.showSaveDialog(this);

		// if the user selects a file
		if (r == JFileChooser.APPROVE_OPTION) {
			String fileName = j.getSelectedFile().getAbsolutePath();
			String data = textArea.getText();
			FileUtils.saveFile(fileName, data);
		}
	}

	private void load(String dir) {
		JFileChooser j = new JFileChooser(dir);
		int r = j.showOpenDialog(this);

		// if the user selects a file
		if (r == JFileChooser.APPROVE_OPTION) {
			String fileName = j.getSelectedFile().getAbsolutePath();
			String data = FileUtils.readFile(fileName);
			textArea.setText(data);
		}
	}

	public static void main(String[] args) {
		new FileDisplay();

	}
}
