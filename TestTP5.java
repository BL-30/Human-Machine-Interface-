package Main;

import java.awt.Dimension;

import Abstraction.ImageLibrary;
import Presentation.IhmTp5;

public class TestTP5 {
	public static void main(String args[]) {

		// ImageLibrary est l'abstraction
		ImageLibrary imageLibrary = new ImageLibrary();

		// L'interface principale 
		IhmTp5 f = new IhmTp5(imageLibrary);

		f.setLocation(80, 50);
		f.setPreferredSize(new Dimension(800, 700));
		f.pack();
		f.setVisible(true);

	}

}
