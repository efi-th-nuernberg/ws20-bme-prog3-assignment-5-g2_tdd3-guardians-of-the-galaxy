import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
    
        Life living = new Life();
        living.setAlive(5, 0);
        living.setAlive(5, 1);
        ILife nextGen = living.nextGeneration(); assertTrue(!nextGen.isAlive(5, 1));
    }


    @Test
    public void keepAliveCell() {

        Life living = new Life();
        living.setAlive(5, 0);
        living.setAlive(5, 1);
        living.setAlive(5, 2);
        ILife nextGen = living.nextGeneration();assertTrue(nextGen.isAlive(5, 1));
    }


    @Test
    public void destroyCrowdedCell() {
      
        Life living = new Life();
        living.setAlive(5, 0);
        living.setAlive(5, 1);
        living.setAlive(5, 2);
        living.setAlive(6, 0);
        living.setAlive(6, 1);
        ILife nextGen = living.nextGeneration();assertTrue(!nextGen.isAlive(5, 1));
    }


}
