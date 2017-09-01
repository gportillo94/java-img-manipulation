public class ReflexionY extends OperacionesUnaMatriz
{
	public int [][] operacion (int matrix[][])
	{
		int ret[][] = new int [matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++)
		{
			for(int j=0;j<matrix[0].length;j++)
			{
				ret[i][j]=matrix[matrix.length-i-1][j];
			}
		}
        return ret;
	}
}
	

