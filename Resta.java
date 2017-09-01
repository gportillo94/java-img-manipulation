public class Resta extends Operaciones2Matrices
{
	public int [][] operacion (int matrix1[][],int matrix2[][])
	{
		int w,h;   
		w=Math.min(matrix1.length,matrix2.length);
		h=Math.min(matrix1[0].length,matrix2[0].length);
		int[][] ret = new int[w][h];

		for (int i = 0; i < w; ++i) 
		{
			for (int j = 0; j < h; ++j) 
			{
				ret[i][j]=Math.abs(matrix1[i][j]-matrix2[i][j]);
			}
		}
		return ret;
	}
}

