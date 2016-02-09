package edu.bsu.cs222;

import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class MultipleFramesContainer extends JDesktopPane {
	private static final long serialVersionUID = -2478222277779363537L;
	private SpeedSlider slider;
	private JTextField dateTextField;
	private SolarSystemMode solarSystemMode;
	private FunctionalFrame frame;
	private BottomFrame informationFrame;
	private PlanetDescriptionFrame desc;
	private JButton button;
	private JLabel label;
	private JTextField inputTextField;
	private SolarSystemFactory solarSystemFactory;

	public MultipleFramesContainer() {
		super();
		initializeComponents();
		configureSolarSystemBoard();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				configureFrame();
			}
		});
		addComponents();
	}

	private void configureFrame() {
		frame.addSpeedSlider(slider);
		frame.addDateTextField(dateTextField);
		frame.addJLabel(label);
		frame.addDateTextField(inputTextField);
		frame.addButton(button);
	}

	private void configureSolarSystemBoard() {
		solarSystemMode = new SolarSystemMode(solarSystemFactory);
		solarSystemMode.registerSpeedBar(slider);
		solarSystemMode.registerTextField(dateTextField);
		solarSystemMode.registerInputField(inputTextField);
		solarSystemMode.registerTimeButton(button);
	}

	private void addComponents() {
		add(informationFrame);
		add(frame);
		add(solarSystemMode);
	}

	public void addInternalFrames(String planetInformation) {
		desc = new PlanetDescriptionFrame(planetInformation);
		remove(desc);
		add(desc);
		moveToFront(desc);
		validate();
	}

	private void initializeComponents() {
		button = new JButton("Move to date");
		slider = new SpeedSlider();
		solarSystemFactory = SolarSystemFactory
				.centralLocationX(
						Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2)
				.andCentralLocationY(
						Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
		inputTextField = new JTextField(15);
		label = new JLabel("Input a time below:");
		dateTextField = new JTextField(15);
		frame = new FunctionalFrame();
		informationFrame = BottomFrame
				.multipleFramesContainer(this).andPlanetInformation(
						solarSystemFactory);
	}

}
