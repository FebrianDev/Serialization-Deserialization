import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String args[]) {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
            Player p = (Player) in.readObject();
            //printing the data of the serialized object
            System.out.println("Nickname :  " + p.getNickname());
            System.out.println("Length : " + p.getLength());
            System.out.println("Rank : "+p.getRank());
            System.out.println("Is Alive " + p.isAlive());
            //closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
