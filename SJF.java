import java.util.*;
import java.io.*;
public class SJF
{
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }


    public static void main(String[] args)
    {
        HashMap<String, Integer> hashmap = new HashMap<>();
        try
        {
            File myObj = new File("Jobs.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String name = myReader.nextLine();
                String data = myReader.nextLine();
                hashmap.put(name, Integer.parseInt(data));
            }

            myReader.close();

        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Map<String, Integer> map = sortByValue(hashmap);
        System.out.println(map);
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