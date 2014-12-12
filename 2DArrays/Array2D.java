public class Array2D
{
    private int[][] table=
        {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
        };
    public Array2D()
    {
        
    }
    
    public String toString()
    {
        String str = " ";
        for(int row = 0; row < table.length; row++)
        {
            for(int col = 0; col < table[0].length; col++)
            {
                str += table[row][col] + "\t";
            }
            str += "\n";
        }

        return str;
    }
    
    public String getRow(int row)
    {
        String str2 = "";
        for(int col = 0; col <table[row].length; col++)
        {
            str2 += table[row][col] + "\t";
        }
        for (int val : table[row])
        {
            str2 += val + "\t";
        }
        return str2;
    }
    
    public String getCol(int col)
    {
        String str = " ";
        for (int row = 0; row < table.length; row++)
        {
            str += table[row][col] + "\t";
        }
        return str;
    }
    public static void main(String[] args)
    {
        Array2D table = new Array2D();
        System.out.println(table.toString());
        System.out.println(table.getRow(2));
    }
}
