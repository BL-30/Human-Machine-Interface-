package Control;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Abstraction.ImageLibrary;

public class ControlSlider implements ChangeListener, PropertyChangeListener {

	JSlider slider;
	ImageLibrary model;
	JLabel iteLab;

	public ControlSlider(JSlider slider, ImageLibrary model, JLabel iteLab) {
		super();
		this.slider = slider;
		this.model = model;
		this.iteLab = iteLab;
	}

	public static final int MAX_SLIDER = 300;
	public static final int MIN_SLIDER = 10;

	public ControlSlider(JSlider sli, ImageLibrary mod) {
		slider = sli;
		model = mod;
	}

	/*
	 * Presentation -> Control
	 * Le ChangeListener permet de recevoir le changement de position du curseur sur
	 * le JSlider
	 */
	public void stateChanged(ChangeEvent e) {
		// on demande au modèle de changer le facteur de zoom de l'image courante
		model.setCurrentScaleFactor(Math.max(ControlSlider.MIN_SLIDER, slider.getValue()));
		int i2= model.getCurrentImageScaleFactor() ;
		this.iteLab.setText("<html><h4>zoom :" + i2 + "% </h4></html>");
	}

	/*
	 * Abstraction -> Control
	 * Le PropertyChangeListener permet de recevoir les notifications du modèle (A)
	 */
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();

		if (msg == ImageLibrary.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
			// on met à jour la valeur du slider avec la valeur de zoom courant de l'image
			// affichée au centre (et qui vient de changer)
			slider.setValue(150);
			this.iteLab.setText("<html><h4>zoom :" + 150 + "% </h4></html>");
		}

		/*
		 * if (msg == ImageLibrary.MESSAGE_CHANGEMENT_TAILLE) { ControlSlider ne
		 * réagit au changement de taille car c'est elle-même qui a initié ce
		 * changement dans la méthode stateChanged() ci-dessus
		 * 
		 * on pourrait ici mettre à jour la position du slider si un autre widget 
		 * permettait de modifier le facteur de zoom, mais il n'y en a pas dans l'interface actuelle
		 * 
		 * }
		 */


	}

}
