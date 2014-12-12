public class ArrayMethods
{
    private int[] values;
    
    public ArrayMethods(int[] initialValues) 
    {
        values = initialValues;
        
    }
    public void swapFirstAndLast()
    {
        int num1 = values[values.length-1];
        values[values.length-1] = values[0];
        values[0] = num1;
    }
    public String toString()
    {
        String list = new String();
        for (int num2 : values)
        {
            list += (num2 + " ");
        }
        return list;
    }
    public void shiftRight()
    {
        int last = values.length - 1;
        int temp = values[last];
        
        for (int i = last; i>0; i--)
        {
             values[i] = values[i-1];
            }
            values[0] = temp;

    }
    public void zeroReplace()
    {
        for (int i = 0; i<values.length; i++)
        {
            int num3 = values[i];
            int check = num3%2;
            if (check == 0)
            {
                values[i] = 0;
            }
        }
    }
    public void bigReplace()
    {
        int num4 = values.length - 1;
        for (int i =1; i<num4; i++)
        {
            if (values[i-1] > values[i+1])
            {
                values[i] = values[i-1];
            }
            else
            {
                values[i] = values[i+1];
            }
        }
    }
            
            
}
