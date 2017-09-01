import java.awt.image.*;
import javax.imageio.ImageIO;
import java.io.*;
import javax.swing.*;
	
public class ImagenaMatriz
{
	private BufferedImage image;
	private Raster raster;
	private WritableRaster wrRaster;
	private int matrix[][];
	private JLabel labelExc;
	public ImagenaMatriz(JLabel labelExc)
	{
		this.labelExc= labelExc;
	}
	public void setFile(File archivo)
	{
		try
		{
			image = ImageIO.read(archivo);
			PrincipalJFrame.labelExc.setText("");
		}
		catch(IOException  e){}
		catch(IllegalArgumentException f)
		{
			PrincipalJFrame.labelExc.setText("Falta imagen(es)");
		}
		raster= image.getData();
		wrRaster=image.getRaster();
		
		matrix = new int [image.getWidth()][image.getHeight()];
		
		for(int x=0 ; x<image.getWidth(); x=x+1)
		{
			for(int y=0; y<image.getHeight(); y=y+1)
			{
				matrix[x][y]=raster.getSample(x,y,0);
			}
		}			  
	}
	public BufferedImage getImagen()
	{
		return image;
	}
	public void setwrRaster(WritableRaster wrRaster)
	{
		this.wrRaster=wrRaster;
	}
	public int [][] getMatriz()
	{
		return matrix;
	}
	public WritableRaster getWritableRaster()
	{
		return wrRaster;
	}
}