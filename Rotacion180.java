public class Rotacion180 extends OperacionesUnaMatriz
{
	public int [][] operacion (int matrix[][])
	{
 
		int ret[][]= new int [matrix.length][matrix[0].length];
		int ip,jp;
		for (int i = 0; i < matrix.length; ++i) 
		{
			ip=(matrix.length-1)-i;
			for (int j = 0; j < matrix[0].length; ++j) 
			{
				jp=(matrix[0].length-1)-j;
				ret[i][j] = matrix[ip][jp];
			}
		}
		return ret;
    }	
}
