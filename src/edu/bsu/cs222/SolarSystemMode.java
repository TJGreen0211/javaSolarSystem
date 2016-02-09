package edu.bsu.cs222;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class SolarSystemMode extends JPanel implements Runnable {

	private static final long serialVersionUID = -8144746765217474414L;
	private SolarSystemView solarSystemView;
	private final DateTimeFormatter FORMATTER = DateTimeFormat
			.forPattern("YYYY/MM/dd/HH:mm:ss");
	private Dimension screen;
	private Boolean init;
	private ZoomAndPanListener zoomAndPanListener;
	private Image offScreenBufferImage;
	private Graphics offScreenBufferGraphics;
	private SpeedSlider slider;
	private final DateTime INITIAL_DATE = new DateTime(2000, 1, 1, 0, 0, 0);
	private Thread thread;
	private Period period;
	private DateTime dateTime;
	private URL bgLocation;
	private Image background;
	private JTextField textField;
	private JTextField inputField;

	public SolarSystemMode(SolarSystemFactory solarSystemFactory) {
		initializeVariables(solarSystemFactory);
		startThread();
		configureBoard();
		addZommAndPanListener();
	}

	private void startThread() {
		thread.start();
	}

	private void configureBoard() {
		setLayout(new BorderLayout());
		setBounds(0, 0, screen.width, screen.height);
	}

	private void initializeVariables(SolarSystemFactory solarSystemFactory) {
		init = true;
		bgLocation = this.getClass().getResource("images/starfield.jpg");
		background = new ImageIcon(bgLocation).getImage();
		dateTime = INITIAL_DATE;
		period = Period.seconds(1);
		thread = new Thread(this);
		screen = Toolkit.getDefaultToolkit().getScreenSize();
		solarSystemView = new SolarSystemView(solarSystemFactory);
		zoomAndPanListener = new ZoomAndPanListener(this);
	}

	private void addZommAndPanListener() {
		addMouseListener(zoomAndPanListener);
		addMouseMotionListener(zoomAndPanListener);
		addMouseWheelListener(zoomAndPanListener);
	}

	@Override
	public void update(Graphics graphics) {
		createOffScreenBufferImage();
		createOffScreenBufferGraphics();
		clearExposedArea();
		transferOffScreenImageToFrame(graphics);
	}

	private void transferOffScreenImageToFrame(Graphics graphics) {
		graphics.drawImage(offScreenBufferImage, 0, 0, this);
	}

	private void createOffScreenBufferGraphics() {
		offScreenBufferGraphics = offScreenBufferImage.getGraphics();
	}

	private void clearExposedArea() {
		offScreenBufferGraphics.setColor(getBackground());
		offScreenBufferGraphics.setColor(getForeground());
	}

	private void createOffScreenBufferImage() {
		offScreenBufferImage = createImage(screen.width, screen.height);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawBackgroundImage(g2d);
		initializeZoomInAndZoomOutFunction(g2d);
		drawSun(g2d);
		drawPlanetPaths(g2d);
		drawPlanets(g2d);
	}

	private void drawPlanetPaths(Graphics2D g2d) {
		g2d.setColor(Color.WHITE);
		solarSystemView.drawPlanetPaths(g2d);
	}

	private void drawSun(Graphics2D g2d) {
		solarSystemView.drawSun(g2d);
	}

	private void drawPlanets(Graphics2D g2d) {
		solarSystemView.drawPlanets(g2d);
	}

	private void drawBackgroundImage(Graphics2D g2d) {
		g2d.drawImage(background, 0, 0, (int) screen.getWidth(),
				(int) screen.getHeight(), null);
	}

	private void initializeZoomInAndZoomOutFunction(Graphics2D g2d) {
		if (isFirstLaungch()) {
			hasLaunched();
			TranslateCameraToSun(g2d);

		} else {
			transformCamera(g2d);
		}
	}

	private void transformCamera(Graphics2D g2d) {
		g2d.setTransform(zoomAndPanListener.getCoordTransform());
	}

	private void TranslateCameraToSun(Graphics2D g2d) {
		int xc = 0;
		int yc = screen.height;
		g2d.translate(xc, yc);
		g2d.scale(1, -1);
		zoomAndPanListener.setCoordTransform(g2d.getTransform());
	}

	private void hasLaunched() {
		init = false;
	}

	private boolean isFirstLaungch() {
		return init;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(30);
			} catch (Exception e) {
				e.printStackTrace();
			}
			showTime();
			makePlanetsMoving();
			repaint();
		}
	}

	private void showTime() {
		textField.setText(FORMATTER.print(dateTime));
	}

	private void makePlanetsMoving() {
		moveToDate();
		changeDate();
	}

	private void changeDate() {
		dateTime = dateTime.plus(period);
	}

	private void moveToDate() {
		solarSystemView.inputDateToMovePlanet(dateTime);
	}

	public void registerSpeedBar(final SpeedSlider slider) {
		this.slider = slider;
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				period = Period.seconds(slider.getValue());
			}

		});
	}

	public void registerTextField(JTextField textField) {
		this.textField = textField;
		this.textField.setBorder(null);
		this.textField.setEditable(false);
		this.textField.setOpaque(false);
		;
		this.textField.setBackground(null);
	}

	public void registerTimeButton(final JButton timeButton) {
		timeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					setSpeedToZero();
					updateDate();
				} catch (Exception exception) {
					inputField.setText("YYYY/MM/dd");
				}
			}

		});
	}

	protected void setSpeedToZero() {
		slider.setValue(0);
	}

	protected void updateDate() {
		dateTime = FORMATTER.parseDateTime(inputField.getText() + "/00:00:00");
	}

	public void registerInputField(JTextField inputTextField) {
		this.inputField = inputTextField;
		inputField.setText("YYYY/MM/dd");
		this.inputField.setBorder(null);
	}
}
