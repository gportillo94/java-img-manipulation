public class Binarizacion extends OperacionesUnaMatriz
{
	public int [][] operacion (int matrix[][])
	{
		int bin[][]= new int [matrix.length][matrix[0].length];
		for(int i=0 ; i<matrix.length; i++)
		{
			for(int j=0; j<matrix[i].length; j++)
			{
				if(matrix[i][j]<128)
					bin[i][j]=0;
				else
					bin[i][j]=255;
			}
		}
		return bin;
	}
}
