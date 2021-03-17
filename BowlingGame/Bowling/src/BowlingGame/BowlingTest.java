package BowlingGame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingTest {

    private Game g;

    @Before
    public void setUp() throws Exception {
        g = new Game();
    }

    private void rollMany(int rolls, int pinsHit) {
        for (int i = 0; i < rolls; i++) {
            g.roll(pinsHit);
        }
    }

    @Test
    public void canRoll() {
        g.roll(0);
    }

    @Test
    public void gutterGame() {
        rollMany(20, 0);

        assertEquals(0, g.score());
    }

    @Test
    public void allOnes() {
        rollMany(20, 1);

        assertEquals(20, g.score());
    }

    @Test
    public void oneSpare() {
        g.roll(5);
        g.roll(5);
        g.roll(3);
        rollMany(17, 0);

        assertEquals(16, g.score());
    }

    @Test
    public void oneStrike() {
        g.roll(10);
        g.roll(3);
        g.roll(4);
        rollMany(16, 0);

        assertEquals(24, g.score());
    }

    @Test
    public void perfectGame() {
        rollMany(12, 10);
        assertEquals(300, g.score());
    }
}
