public class MagicSquares
{
    public static void main(String[]args)
    {
        int[][] grid = new int[4][4];
        Scanner arin = new Scanner(System.in);
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                System.out.println("Enter value: ");
                arin.nextInt();
            }
        }
    }
}