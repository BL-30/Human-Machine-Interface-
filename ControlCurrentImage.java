package Control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;

import Abstraction.ImageLibrary;

public class ControlCurrentImage implements PropertyChangeListener {
	private JLabel imageCentre;
	private JLabel imageName;
	private ImageLibrary model;

	public ControlCurrentImage(ImageLibrary model, JLabel imageCentre, JLabel imageName) {
		this.model = model;
		this.imageCentre = imageCentre;
		this.imageName = imageName;
	}

	/**
	 * Abstraction -> Control
	 * le controleur de l'image courante (affichage du nom et de l'image) n'est pas
	 * interactive (elle ne reçoit pas d'évènements de Swing) cependant elle recoit
	 * les notifications de ImageLibrary via le PropertyChangeListener lorsque
	 * l'image courante doit changer !
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		// cas d'un changement de l'image courante (quelque soit son origine, boutons,
		// roll, list...)
		if (msg == ImageLibrary.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
			this.imageCentre.setIcon(model.getCurrentImage());
			this.imageName.setText("<html><h4>" + model.getCurrentImageName() + "</h4></html>");
		}

		// cas d'un changement de taille, on modifie la taille de l'image affichée
		else if (msg == ImageLibrary.MESSAGE_CHANGEMENT_TAILLE) {
			this.imageCentre.setSize(model.getCurrentImageSize());
			this.imageCentre.repaint();
		}

		// cas d'un changement de nom de l'image courante
		else if (msg == ImageLibrary.MESSAGE_CHANGEMENT_NOM) {
			this.imageName.setText("<html><h4>" + model.getCurrentImageName() + "</h4></html>");
		}

		else if (msg == ImageLibrary.MESSAGE_NOUVELLE_IMAGE) {
			// on ne fait rien dans le label central quand une nouvelle image est ajoutée
		}

	}

}
