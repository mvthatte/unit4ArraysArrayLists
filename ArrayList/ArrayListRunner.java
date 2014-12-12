import java.util.ArrayList;

public class ArrayListRunner
{
   public static void main(String[] args)
   {
       ArrayList<String> names = new ArrayList();
       names.add("Alice");
       names.add("Bob");
       names.add("Connie");
       names.add("David");
       names.add("Edward");
       names.add("Fran");
       names.add("Gomez");
       names.add("Harry");
       System.out.println(names.get(0));
       System.out.println(names.get(names.size()-1));
       System.out.println(names);
       System.out.println(names.set(0, "Alice B. Toklas"));
       System.out.println(names);
   }
} 