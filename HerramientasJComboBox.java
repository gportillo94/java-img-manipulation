import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HerramientasJComboBox extends JComboBox
{
	public HerramientasJComboBox()
	{
		this.addItem("Rotacion 90");
		this.addItem("Rotacion 180");
		this.addItem("Reflexion X");
		this.addItem("Reflexion Y");
		this.addItem("Binarizacion");
		this.addItem("Suma");
		this.addItem("Resta");
		this.addItem("Multiplicacion");
		this.addItem("And");
		this.addItem("Or");
		this.addItem("Xor");
		this.setSelectedIndex(0);
	}
}