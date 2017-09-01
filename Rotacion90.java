public class Rotacion90 extends OperacionesUnaMatriz
{
	public int [][] operacion (int matrix[][])
	{
		int w = matrix.length;
		int h = matrix[0].length;   
		int[][] ret = new int[h][w];
		for (int i = 0; i < h; ++i) 
		{
			for (int j = 0; j < w; ++j) 
			{
				ret[i][j] = matrix[j][h - i - 1];
			}
		}
		return ret;
    }
}
