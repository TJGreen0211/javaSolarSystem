package edu.bsu.cs222;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SolarSystemMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private MultipleFramesContainer multipleFramesContainer;
	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
	private JButton button;
	private GridBagConstraints constraint;
	private JTextArea disclaimer;
	private ActionListener selectModeListener;

	public SolarSystemMainFrame() {
		initializeVariables();
		configureSolarSystemMainFrame();
		addChooseModeButton();
		addDisclaimer();
	}

	private void addDisclaimer() {
		setupGridBagConstraintsForDisclaimer();
		configureDisclaimer();
		add(disclaimer, constraint);
	}

	private void configureDisclaimer() {
		disclaimer
				.setText("The data of each planet is from: http://space-facts.com and the \n"
						+ "official site of NASA. The position of each planet is estimated \n"
						+ "and not accurate. The orbital period and size ratio are accurate.");
		disclaimer.setFont(disclaimer.getFont().deriveFont(18.0f));
		disclaimer.setOpaque(false);
		disclaimer.setForeground(Color.WHITE);
	}

	private void setupGridBagConstraintsForDisclaimer() {
		constraint.gridx = 0;
		constraint.gridy = 0;
		constraint.weighty = 1;
	}

	private void initializeVariables() {
		multipleFramesContainer = new MultipleFramesContainer();
		constraint = new GridBagConstraints();
		disclaimer = new JTextArea();
		button = new JButton("Go to SolarSystem Mode");
	}

	private void addChooseModeButton() {
		addSolarSystemModeButton();
	}

	private void setButtonSize() {
		button.setPreferredSize(new Dimension(250, 100));
	}

	private void addSolarSystemModeButton() {
		setupGridBagConstraintsForButton();
		setButtonSize();
		addButtonToFrame();
		initializeChooseToPlanetModeListener();
		addListenerToButton();
	}

	private void setupGridBagConstraintsForButton() {
		constraint.gridx = 0;
		constraint.gridy = 1;
	}

	private void addButtonToFrame() {
		add(button, constraint);
	}

	private void addListenerToButton() {
		button.addActionListener(selectModeListener);
	}

	private void initializeChooseToPlanetModeListener() {
		selectModeListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				chooseSolarSystemMode();
			}

			private void chooseSolarSystemMode() {
				button.setVisible(false);
				setContentPane(multipleFramesContainer);
				new InstructionFrame();
				multipleFramesContainer.setVisible(true);
			}

		};
	}

	private void configureSolarSystemMainFrame() {
		getContentPane().setBackground(Color.BLACK);
		setSize(screen.width, screen.height);
		setLayout(new GridBagLayout());
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}