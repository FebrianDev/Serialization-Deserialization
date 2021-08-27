import java.io.*;
import java.util.Scanner;

public class Program {

    private static Player player;
    private static String nickname;
    private static Integer length;
    private static Integer rank;
    private static boolean isAlive;

    public static void main(String[] args) {
        input();
        if(fileExist() != null){
            deserialize(fileExist());
        }
    }

    public static void input(){
        player = new Player();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input Nickname : ");
        nickname = sc.nextLine();
        player.setNickname(nickname);
        System.out.print("Input Length : ");
        length = sc.nextInt();
        player.setLength(length);
        System.out.print("Input Rank : ");
        rank = sc.nextInt();
        player.setRank(rank);
        isAlive = true;
        player.setAlive(isAlive);
        serialize(player);
    }

    public static Player getPlayer(){
        return player;
    }

    public static Player PrintData(Player player){
        System.out.println();
        System.out.println("Result");
        System.out.println("Nickname "+ player.getNickname());
        System.out.println("Length "+ player.getLength());
        System.out.println("Rank "+player.getRank());
        System.out.println("Is ALive "+player.isAlive());

        return player;
    }

    public static boolean serialize(Player p) {
        try {
            //Creating stream and writing the object
            FileOutputStream fout = new FileOutputStream("file.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(p);
            out.flush();
            //closing the stream
            out.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage().toString());
            return false;
        }
    }

    public static boolean deserialize(FileInputStream s) {
        try {
            //Creating stream to read the object
            ObjectInputStream in = new ObjectInputStream(s);
            //closing the stream
            PrintData((Player)in.readObject());
            in.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static FileInputStream fileExist() {
        try {
            return new FileInputStream("file.txt");
        } catch (FileNotFoundException e) {
            return null;
        }
    }

}

