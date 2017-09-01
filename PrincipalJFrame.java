import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;

public class PrincipalJFrame extends JFrame
{
	private HerramientasJComboBox herramientas;
	private ImagenesJPanel panelImagnes;
	private ArchivosJFileChooser archivo;
	private JButton botonArchivo,botonArchivo2,hacer;
	private JPanel panelSup;
	private File archivoSeleccionado ,archivoSeleccionado2;
	private int entero,matrixTemp[][];
	private ImagenaMatriz iAm,iAm2;
	private MatrizaImagen mAi;
	private BufferedImage imageTemp;
	private OperacionesUnaMatriz opMatriz;
	private Operaciones2Matrices opMatrices;
	static JLabel labelExc;
	
	public PrincipalJFrame()
	{
		super("Proyecto 2");		
		botonArchivo = 	new JButton("Agregar/Modificar Imagen 1");
		botonArchivo2=	new JButton("Agregar/Modificar Imagen 2");
		panelSup= 		new JPanel();
		herramientas =	new HerramientasJComboBox();
		archivo = 		new ArchivosJFileChooser();
		hacer =			new JButton("Hacer");
		panelImagnes=	new ImagenesJPanel();

		mAi=			new MatrizaImagen();
		labelExc= 	new JLabel();
		iAm = 			new ImagenaMatriz(labelExc);
		iAm2=			new ImagenaMatriz(labelExc);

	}
	public void mostrar()
	{
		setSize(1000,600);
		
		panelSup.add(botonArchivo);
		panelSup.add(botonArchivo2);
		panelSup.add(herramientas);
		panelSup.add(hacer);
		add(panelSup,BorderLayout.NORTH);
		add(panelImagnes,BorderLayout.CENTER);
		add(labelExc,BorderLayout.SOUTH);
		
		botonArchivo.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				entero=archivo.showOpenDialog(PrincipalJFrame.this);
				archivoSeleccionado=archivo.getSelectedFile();
				System.out.println(archivoSeleccionado.getName());
				try{panelImagnes.setLabel1(ImageIO.read(archivoSeleccionado));}
				catch (IOException io) {}
			}	
		});
		
		botonArchivo2.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				entero=archivo.showOpenDialog(PrincipalJFrame.this);
				archivoSeleccionado2=archivo.getSelectedFile();
				System.out.println(archivoSeleccionado2.getName());
				try{panelImagnes.setLabel2(ImageIO.read(archivoSeleccionado2));}
				catch (IOException io) {}
			}	
		});
		
		hacer.addActionListener( new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println(herramientas.getSelectedIndex());
				switch (herramientas.getSelectedIndex())
				{
					case 0:
						iAm.setFile(archivoSeleccionado);
						opMatriz = new Rotacion90();
						imageTemp = new BufferedImage(iAm.getImagen().getHeight(),iAm.getImagen().getWidth(),BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(opMatriz.operacion(iAm.getMatriz()),iAm.getWritableRaster()));
					break;
					case 1:
						iAm.setFile(archivoSeleccionado);
						opMatriz = new Rotacion180();
						panelImagnes.setLabelres(mAi.getImagen(opMatriz.operacion(iAm.getMatriz()),iAm.getWritableRaster()));
					break;
					case 2:
						iAm.setFile(archivoSeleccionado);
						opMatriz = new ReflexionX();
						panelImagnes.setLabelres(mAi.getImagen(opMatriz.operacion(iAm.getMatriz()),iAm.getWritableRaster()));
					break;
					case 3:
						iAm.setFile(archivoSeleccionado);
						opMatriz = new ReflexionY();
						panelImagnes.setLabelres(mAi.getImagen(opMatriz.operacion(iAm.getMatriz()),iAm.getWritableRaster()));
					break;
					case 4:
						iAm.setFile(archivoSeleccionado);
						opMatriz = new Binarizacion();
						panelImagnes.setLabelres(mAi.getImagen(opMatriz.operacion(iAm.getMatriz()),iAm.getWritableRaster()));
					break;
					case 5:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new Suma();
						matrixTemp = opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
					case 6:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new Resta();
						matrixTemp = opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
					case 7:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new Mult();
						matrixTemp = opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
					case 8:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new And();
						matrixTemp= opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
					case 9:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new Or();
						matrixTemp = opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
					case 10:
						iAm.setFile(archivoSeleccionado);
						iAm2.setFile(archivoSeleccionado2);
						opMatrices = new Xor();
						matrixTemp = opMatrices.operacion(iAm.getMatriz(),iAm2.getMatriz());
						imageTemp = new BufferedImage(matrixTemp.length,matrixTemp[0].length,BufferedImage.TYPE_BYTE_GRAY);
						iAm.setwrRaster(imageTemp.getRaster());
						panelImagnes.setLabelres(mAi.getImagen(matrixTemp,iAm.getWritableRaster()));
					break;
				}
			}	
		});
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}
	public static void main (String args[])
	{
		PrincipalJFrame principal = new PrincipalJFrame();
		principal.mostrar();
	}
}