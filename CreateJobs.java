import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.*;

public class CreateJobs{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            FileWriter myWriter = new FileWriter("Jobs.txt");
            System.out.print("How many jobs do you want? ");
            int num = scan.nextInt();
            Random rand = new Random();
            int a = 65;
            for(int i = 0; i < num; i++)
            {
                int random = rand.nextInt(50);
                myWriter.write((char)a++ + "\n");
                myWriter.write(random + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}