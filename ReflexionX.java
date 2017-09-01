public class ReflexionX extends OperacionesUnaMatriz
{
	public int [][] operacion (int matrix[][])
	 {
        int temp, half=matrix[0].length/2;
        for(int row=0; row < matrix.length; row++)
            for(int col=0; col <=half; col++)
		{
			{
                temp=matrix[row][matrix[0].length-1-col];
                matrix[row][matrix[0].length-1-col]=matrix[row][col];
                matrix[row][col]=temp;
            }
        }
        return matrix;
	 }
}
	

