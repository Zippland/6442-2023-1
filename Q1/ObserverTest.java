package Q1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ObserverTest {
    private Participant participant;
    private Riddle[] riddles;
    private Observer observer;

    @Before
    public void setup() {
        riddles = new Riddle[]{
                new Riddle("I speak without a mouth and hear without ears. I have no body, but I come alive with the wind. What am I?", "An echo", Riddle.RiddleType.TEXT_RIDDLE),
                new Riddle("I can be cracked, made, told, and played. What am I?", "A joke", Riddle.RiddleType.TEXT_RIDDLE),
                new Riddle("I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?", "Fire", Riddle.RiddleType.TEXT_RIDDLE),
                new Riddle("I have cities, but no houses. I have mountains, but no trees. I have water, but no fish. What am I?", "A map", Riddle.RiddleType.TEXT_RIDDLE),
                new Riddle("I have keys, but no locks. I have a space, but no room. You can enter, but can't go outside. What am I?", "A keyboard", Riddle.RiddleType.TEXT_RIDDLE)
        };
        participant = new Participant(riddles);

        // TODO - Uncomment this for part 2b
//        observer = new GameMaster();
//        participant.registerObserver(observer);
    }

    @Test(timeout=1000)
    public void testObserverNotifiedWhenAskingForHelp() {
        participant.askForHelp();
        assertTrue(observer.hasAskedForHelp(participant));
        assertFalse(observer.hasAskedForHelp(new Participant(riddles)));
    }

    @Test(timeout=1000)
    public void testObserverNotNotifiedBeforeEscape() {
        assertFalse(observer.hasEscaped(participant));
    }

    @Test(timeout=1000)
    public void testObserverNotifiedAfterEscape() throws RiddleException {
        for (int i = 0; i < riddles.length; i++) {
            participant.solveRiddle(riddles[i].getAnswer(), i);
        }
        assertTrue(observer.hasEscaped(participant));
        assertFalse(observer.hasEscaped(new Participant(riddles)));
    }
}