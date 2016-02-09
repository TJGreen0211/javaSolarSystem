package edu.bsu.cs222;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanetActionListener implements ActionListener {
	
	public static PlanetActionListenerBuilder planetInformation(String planetInformation){
		return new PlanetActionListenerBuilder(planetInformation);
	}
	
	public static final class PlanetActionListenerBuilder{
		private String planetInformation;
		private MultipleFramesContainer multipleFramesContainer;
		private PlanetActionListenerBuilder(String planetInformation){
			this.planetInformation = planetInformation;
		}
		
		public PlanetActionListener andMultipleFramesContainer(MultipleFramesContainer multipleFramesContainer){
			this.multipleFramesContainer = multipleFramesContainer;
			return new PlanetActionListener(this);
		}
	}
	
	private String planeInformation;
	private MultipleFramesContainer multipleFramesContainer;
    private PlanetActionListener(PlanetActionListenerBuilder builder) {
        this.planeInformation = builder.planetInformation;
		this.multipleFramesContainer = builder.multipleFramesContainer;
    }

    public void actionPerformed(ActionEvent e) {
        multipleFramesContainer.addInternalFrames(planeInformation);
    }
}

