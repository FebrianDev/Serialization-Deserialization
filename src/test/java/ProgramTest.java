import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @Test
    public void serialize(){
        assertTrue(Program.serialize(Program.getPlayer()));
    }

    @Test
    public void fileExist(){
       assertNotNull(Program.fileExist());
    }

    @Test
    public void deserialize(){
        assertTrue(Program.deserialize(Program.fileExist()));
    }

    @Test
    public void match(){
        try {
           ObjectInputStream in = new ObjectInputStream(new FileInputStream("file.txt"));
           Player p = (Player) in.readObject();
            assertEquals(p.getNickname(), "1");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //closing the stream
    }
}