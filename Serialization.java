import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String args[]) {
        try {
            //Creating the object
            Player s1 = new Player("febrian", 100,1, true);
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("file.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            //closing the stream
            out.close();
            System.out.println("success serialization data");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
