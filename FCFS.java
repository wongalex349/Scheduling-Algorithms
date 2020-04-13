import java.util.*;
import java.io.*;
public class FCFS
{
    public static void main(String[] args)
    {
        TreeMap<String, Integer> map = new TreeMap<>();
        try
        {
            File myObj = new File("Jobs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                String data = myReader.nextLine();
                map.put(name, Integer.parseInt(data));
            }
            System.out.println(map);
            myReader.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int array[] = new int[map.size()];
        int count = 0;
        int x = 0;
        for(String i: map.keySet())
        {
            System.out.println("\t" + count);
            System.out.println(i);
            count = count + map.get(i);
            array[x++] = count;
        }
        System.out.println("\t" + count);
        double sum = 0;
        System.out.print("_______________\n( ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            sum = sum + array[i];
            String z = (i == array.length-1) ? "" : "+";
            System.out.print(" " + z + " ");
        }
        System.out.println(") / " + array.length  + " = " + (sum/array.length));


    }

}