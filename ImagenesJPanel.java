import javax.swing.*;
import java.awt.*;
import java.awt.image.*;

public class ImagenesJPanel extends JPanel
{
	private JLabel label1,label2,labelres;
	private BufferedImage img;
	public ImagenesJPanel()
	{
		setLayout(new GridLayout(1,3));
		
		label1=  new JLabel ("Imagen 1");
		label2 = new JLabel("Imagen 2");
		labelres = new JLabel("Imagen Resultado");
		
		add(label1);
		add(label2);
		add(labelres);
	}
	public void setLabel1(BufferedImage img)
	{
		System.out.println("Display image 1");
		label1.setIcon(new ImageIcon(img));
	}
	public void setLabel2(BufferedImage img)
	{
		System.out.println("Display image 1");
		label2.setIcon(new ImageIcon(img));
	}
	public void setLabelres(BufferedImage img)
	{
		System.out.println("Display result image");
		labelres.setIcon(new ImageIcon(img));
	}
}