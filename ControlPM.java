package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSlider;

import Abstraction.ImageLibrary;

public class ControlPM implements ActionListener, PropertyChangeListener{

	private ImageLibrary model;
	private JButton plus;
	private JButton moins;
	//private Vector<Integer> iterateur ;
	private int iterateur; 
	private JSlider slider;
	private JLabel iteLab;
	
	
	

	



	



	public ControlPM(ImageLibrary model, JButton plus, JButton moins, int iterateur, JSlider slider, JLabel iteLab) {
		super();
		this.model = model;
		this.plus = plus;
		this.moins = moins;
		this.iterateur = iterateur;
		this.slider = slider;
		this.iteLab = iteLab;
	}



	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		String msg = evt.getPropertyName();
		if (msg == ImageLibrary.MESSAGE_CHANGEMENT_TAILLE) { 
			this.plus.setEnabled(this.model.getCurrentImageScaleFactor() < 300); //3c
			this.moins.setEnabled(this.model.getCurrentImageScaleFactor() > 10); //3c
			slider.setValue(model.getCurrentImageScaleFactor()); //3a
			iterateur = model.getCurrentImageScaleFactor() +1;
			this.iteLab.repaint();
			
		}
		if (msg == ImageLibrary.MESSAGE_CHANGEMENT_IMAGE_COURANTE) {
			// on met à jour la valeur du slider avec la valeur de zoom courant de l'image
			// affichée au centre (et qui vient de changer)
			//iterateur = 150; 
			slider.setValue(150); //3b
			this.iteLab.setText("<html><h4>zoom :" + model.getCurrentImageScaleFactor() + "% </h4></html>");
			this.iteLab.repaint();
		}
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == moins) {
			this.model.setCurrentScaleFactor(model.getCurrentImageScaleFactor() -1);
			int i1= model.getCurrentImageScaleFactor() -1;
			this.iteLab.setText("<html><h4>zoom :" + i1 + "% </h4></html>");
		} else if (e.getSource() == plus) {
			this.model.setCurrentScaleFactor(model.getCurrentImageScaleFactor()+1);
			int i2= model.getCurrentImageScaleFactor() +1;
			this.iteLab.setText("<html><h4>zoom :" + i2 + "% </h4></html>");
		}
		else if (e.getSource() == slider) {
			
			int i2= model.getCurrentImageScaleFactor() ;
			this.iteLab.setText("<html><h4>zoom :" + i2 + "% </h4></html>");
		}
	}

}
