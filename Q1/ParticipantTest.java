package Q1;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParticipantTest {
    private Riddle[] riddles;
    private Participant participant;

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
    }

    @Test(timeout=1000)
    public void testSolveRiddle1() throws RiddleException {
        participant.solveRiddle("An echo", 0);
        assertTrue(participant.getState() instanceof InProgressState);
        assertTrue(participant.getRiddle(0).isSolved());
    }

    @Test(timeout=1000)
    public void testSolveRiddle2() throws RiddleException {
        participant.solveRiddle("Wrong answer", 0);
        assertTrue(participant.getState() instanceof InProgressState);
        assertFalse(participant.getRiddle(0).isSolved());
    }

    @Test(timeout=1000)
    public void testAskForHelp() throws RiddleException {
        participant.askForHelp();
        assertTrue(participant.getState() instanceof HelpState);
        participant.solveRiddle("Wrong answer", 1);
        assertTrue(participant.getState() instanceof InProgressState);
        assertTrue(participant.getRiddle(1).isSolved());
    }

    @Test
    public void testSolveAllRiddles() throws RiddleException {
        for (int i = 0; i < riddles.length; i++) {
            participant.solveRiddle(riddles[i].getAnswer(), i);
            assertTrue(participant.getRiddle(i).isSolved());
        }
        assertTrue(participant.getState() instanceof EscapedState);
    }

    @Test(expected = RiddleException.class)
    public void testCannotSolveRiddleAfterEscape() throws RiddleException {
        for (int i = 0; i < riddles.length; i++) {
            participant.solveRiddle(riddles[i].getAnswer(), i);
            assertTrue(participant.getRiddle(i).isSolved());
        }
        participant.solveRiddle("Any Answer", 0);
    }
}
