package Q1;

public class Participant {
    private ParticipantState state;
    private Riddle[] riddleList;

    //You may use this part to implement other required instructions
    //TODO - Your Code Starts here



    //TODO - Your Code Ends here


    public Participant(Riddle[] riddleList) {
        //TODO - Your Code Starts here



        //TODO - Your Code Ends here
    }

    public void askForHelp() {
        // this.state = new HelpState();  // Uncomment this line for part 2a. You should not change the code content of this line

        //TODO - Your Code Starts here



        //TODO - Your Code Ends here
    }



    public void solveRiddle(String input, int whichRiddle) throws RiddleException {
        this.state = this.state.solveRiddle(input, riddleList, whichRiddle);

        // TODO  - Your Code Starts here



        //TODO - Your Code Ends here
    }



    public ParticipantState getState() {
        return state;
    }

    public Riddle getRiddle(int whichRiddle) {
        return riddleList[whichRiddle];
    }



}