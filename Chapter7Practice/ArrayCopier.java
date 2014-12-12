public class ArrayCopier {
   public static void main(String[] args) {
      int [] scores = { 10,9,7,4,5};
      int [] values = new int[5];
      for (int i = 0; i<5; i++)
      {
         values[i] = scores[i];
      }
      System.out.println(values);
      System.out.println(scores);
      
   }
}