package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;

import Abstraction.ImageLibrary;

public class ControlBoutonPrevNext implements ActionListener, PropertyChangeListener {
	private ImageLibrary model;
	private JButton prev;
	private JButton next;

	public ControlBoutonPrevNext(ImageLibrary model, JButton prev, JButton next) {
		this.model = model;
		this.prev = prev;
		this.next = next;
	}

	/*
	 * Abstraction -> Control
	 * Le PropertyChangeListener permet de recevoir les modifications du modèle (A)
	 * - ici utiles pour (dés)activer les boutons quand on arrive en fin de liste
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		String msg = evt.getPropertyName();
		if (msg == ImageLibrary.MESSAGE_CHANGEMENT_IMAGE_COURANTE // on a changé d'image
				|| msg == ImageLibrary.MESSAGE_NOUVELLE_IMAGE) { // on a ajouté une image
			this.prev.setEnabled(this.model.getCurrentIndex() > 0);
			this.next.setEnabled(this.model.getCurrentIndex() < this.model.getSize() - 1);
		}
	}

	/*
	 * Presentation -> Control
	 * L'ActionListener permet de gérér simplement le clic sur les boutons en
	 * passant à l'image précédente ou suivante
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == prev) {
			this.model.getPrevImage();
		} else if (e.getSource() == next) {
			this.model.getNextImage();
		}
	}

}
