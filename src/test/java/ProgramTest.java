import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    private Player player;

   ProgramTest(){
       player = new Player();
       player.setNickname("Febrian");
       player.setLength(100);
       player.setRank(1);
       player.setAlive(true);
   }

    @Test
    public void serialize() {
        assertTrue(Program.serialize(player));
    }

    @Test
    public void fileExist() {
        assertNotNull(Program.fileExist());
    }

    @Test
    public void deserialize() {
        assertTrue(Program.deserialize(Program.fileExist()));
    }

    @Test
    public void match() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
            Player p = (Player) in.readObject();
            assertEquals(p.getNickname(), player.getNickname());
            assertEquals(p.getLength(), player.getLength());
            assertEquals(p.getRank(), player.getRank());
            assertEquals(p.isAlive(), player.isAlive());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}