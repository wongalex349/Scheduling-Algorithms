import java.util.*;
import java.io.*;
public class RoundRobin2
{
    public static void main(String[] args)
    {
        final int robin = 2;
        TreeMap<String, Integer> map = new TreeMap<>();
        try
        {
            File myObj = new File("Jobs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
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
        int count = 0;
        for(String i: map.keySet())
        {
            count += map.get(i);
        }
        int x = 0;
        int array[] = new int[map.size()];
        int z = 0;
        while(x < count)
        {
            for(String i: map.keySet())
            {
                if(map.get(i) <= 0)
                    continue;
                else
                {
                    System.out.println("\t" + x);
                    System.out.println(i);
                    if(map.get(i) < robin)
                    {
                        x += map.get(i);
                        array[z++] = x;
                        map.replace(i, 0);
                    }
                    else
                    {
                        x += robin;
                        if(map.get(i) == robin)
                            array[z++] = x;
                        map.replace(i, map.get(i) - robin);
                    }
                }
            }
        }
        System.out.println("\t" + x);
        double sum = 0;
        System.out.print("_______________\n( ");
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
            sum = sum + array[i];
            String q = (i == array.length-1) ? "" : "+";
            System.out.print(" " + q + " ");
        }
        System.out.println(") / " + array.length  + " = " + (sum/array.length));
    }

}