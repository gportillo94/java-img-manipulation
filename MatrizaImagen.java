import java.awt.image.*;

public class MatrizaImagen
{	
	private BufferedImage image;
	public MatrizaImagen()
	{
		
	}
	public BufferedImage getImagen(int matrix[][],WritableRaster wrRaster)
	{
		for(int i=0 ; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[i].length; j++)
			{
				wrRaster.setSample(i,j,0,matrix[i][j]);
			}
		}	
		image= new BufferedImage(wrRaster.getWidth(),wrRaster.getHeight(),BufferedImage.TYPE_BYTE_GRAY);
		image.setData(wrRaster);
		return image;
	}
}