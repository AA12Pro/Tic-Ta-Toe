package tk.aa12mc.Tic_Tac_Toe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Settings implements ActionListener {

	private JFrame frame = new JFrame("Settings");
	private JButton done = new JButton();
	private JButton register = new JButton();
	private JComboBox<String> box = new JComboBox<String>(Constants.SETTINGS_OPTIONS);
	private String name1, name2;
	private int level;
	private JRadioButton[] option = new JRadioButton[3];
	private ButtonGroup group = new ButtonGroup();
	private JLabel names = new JLabel();
	private JLabel name = new JLabel();
	private JLabel nameX = new JLabel();
	private JLabel nameO = new JLabel();
	private JLabel password = new JLabel();
	private JLabel passwordX = new JLabel();
	private JLabel passwordO = new JLabel();
	private JLabel difficulty = new JLabel();
	private JTextField player = new JTextField();
	private JTextField playerX = new JTextField();
	private JTextField playerO = new JTextField();
	private JTextField pass = new JTextField();
	private JTextField passX = new JTextField();
	private JTextField passO = new JTextField();

	public Settings() {

		for (int i = 0; i < 3; i++) {
			option[i] = new JRadioButton();
			option[i].setSize(50, 50);
			group.add(option[i]);
			frame.add(option[i]);
		}

		frame.setIconImage(Constants.SETTINGSFRAME_ICON.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(235, 320);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);

		frame.add(playerX);
		frame.add(playerO);

		done.setText("Done");
		done.setBounds(77, 162, 80, 70);
		done.addActionListener(this);
		
		register.setText("Sign up");
		register.setBounds(67, 242, 100, 20);
		register.addActionListener(this);
		
		name.setText("Player:");
		name.setBounds(30, 50, 100, 20);

		player.setBounds(105, 52, 100, 20);
		
		password.setText("Password:");
		password.setBounds(30, 70, 100, 20);
		
		pass.setBounds(105, 72, 100, 20);

		names.setText("Put your names bellow:");
		names.setBounds(30, 20, 200, 50);

		nameX.setText("Player X:");
		nameX.setBounds(30, 50, 200, 50);

		playerX.setBounds(105, 65, 100, 20);
		
		passwordX.setText("Password:");
		passwordX.setBounds(30, 85, 100, 20);
		
		passX.setBounds(105, 87, 100, 20);

		nameO.setText("Player 0:");
		nameO.setBounds(30, 100, 200, 50);

		playerO.setBounds(105, 115, 100, 20);
		
		passwordO.setText("Password:");
		passwordO.setBounds(30, 135, 100, 20);
		
		passO.setBounds(105, 137, 100, 20);

		difficulty.setText("Select a difficulty:");
		difficulty.setBounds(30, 80, 200, 50);

		option[0].setText("Easy");
		option[0].setBounds(240, 50, 100, 20);
		option[0].setSelected(true);
		option[1].setText("Medium");
		option[1].setBounds(240, 70, 100, 20);
		option[2].setText("Hard");
		option[2].setBounds(240, 90, 100, 20);

		box.setBounds(0, 0, 235, 20);
		box.addActionListener(this);

		frame.add(box);
		frame.add(register);
		frame.add(done);
		frame.add(names);
		frame.add(nameX);
		frame.add(playerX);
		frame.add(passwordX);
		frame.add(passX);
		frame.add(nameO);
		frame.add(playerO);
		frame.add(passwordO);
		frame.add(passO);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int s = box.getSelectedIndex();

		if (e.getSource() == done) {
			frame.dispose();
			switch (s) {
			case 0:
				name1 = playerX.getText();
				name2 = playerO.getText();
				level = -1;
				break;
			case 1:
				name1 = player.getText();
				name2 = "Computer";
				if (option[0].isSelected()) {
					level = 0;
				} else if (option[1].isSelected()) {
					level = 1;
				} else if (option[2].isSelected()) {
					level = 2;
				}
			}
			new Game(this);
		} else if (e.getSource() == register) {
			new Register();
		}

		switch (s) {
		case 0:
			box.setBounds(0, 0, 235, 20);
			done.setBounds(77, 162, 80, 70);
			register.setBounds(67, 242, 100, 20);
			frame.setSize(235, 320);
			frame.setLocationRelativeTo(null);
			frame.remove(name);
			frame.remove(player);
			frame.remove(password);
			frame.remove(pass);
			for (int i = 0; i < 3; i++) {
				frame.remove(option[i]);
			}
			frame.add(names);
			frame.add(nameX);
			frame.add(playerX);
			frame.add(passwordX);
			frame.add(passX);
			frame.add(nameO);
			frame.add(playerO);
			frame.add(passwordO);
			frame.add(passO);
			frame.repaint();
			break;
		case 1:
			box.setBounds(0, 0, 435, 20);
			done.setBounds(350, 45, 80, 70);
			register.setBounds(60, 95, 100, 20);
			frame.setSize(435, 175);
			frame.setLocationRelativeTo(null);
			frame.remove(names);
			frame.remove(nameX);
			frame.remove(playerX);
			frame.remove(passwordX);
			frame.remove(passX);
			frame.remove(nameO);
			frame.remove(playerO);
			frame.remove(passwordO);
			frame.remove(passO);
			frame.add(name);
			frame.add(player);
			frame.add(password);
			frame.add(pass);
			for (int i = 0; i < 3; i++) {
				frame.add(option[i]);
			}
			frame.repaint();
			break;

		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public String getName2() {
		return name2;
	}

	public void setName2(String name2) {
		this.name2 = name2;
	}

}