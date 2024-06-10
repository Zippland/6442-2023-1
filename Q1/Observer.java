package Q1;


/**
 *  Observer Interface for Escape Room GameMasters,
 *  provided and no changes should be made in this class.
 */
public interface Observer {
    void updateHelp(Participant p);
    void updateEscape(Participant p);
    boolean hasAskedForHelp(Participant p);
    boolean hasEscaped(Participant p);
}
