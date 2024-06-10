## Note
Please note that certain IDEs may not be equipped with a markdown renderer, 
which could result in incorrect display of all the information. 
To ensure accurate viewing, we recommend accessing the markdown content directly from GitLab 
using your web browser.


## Q1 - Escape the COMP2100 Exam if you can

<h3> Part 1) Java and Software Testing </h3>

The Escape Room software manages different types of riddles:
1. TextRiddle: The answer is a string (non-case-sensitive)
2. NumericRiddle: The answer is a number
3. AnagramRiddle: The answer is an anagram of a word/string

The following classes have been provided to you.
- `RiddleType`: An enumeration representing different types of riddles (TEXT_RIDDLE, NUMERIC_RIDDLE, and ANAGRAM_RIDDLE).
- `Riddle`: Represents a riddle. It has a `question` (String), an `answer` (String), `isSolved` (boolean), and a `type` (RiddleType) attribute.

Your task is to achieve branch complete with the minimal set of test cases for the `checkAnswer` method of the `Riddle` class
- Create the test cases within the `tests` method of the `RiddleCheckAnswerTest` class
  <br><br>

  

<h3> Part 2) State and Observer </h3>

The structure of the key classes is illustrated in the UML diagram: <br>
<img src="UML.png" style="max-width: 850px;" alt="UML showing some information of the main classes in Q1 (find `URL.png` in the folder if it is not shown)." >
<br>
- To avoid redundancy, methods and exceptions in an interface are not shown in the concrete classes.
- Some classes have been provided to you, others have to be created/implemented by you (in accordance with the UML and the definitions below).
<br><br>

Part 2a) Use the State Design Pattern to model the distinct states of a participant in the Escape Room.
Each participant can be in one of the three states, and the behavior of the `solveRiddle` method will vary depending on the current state of the participant.
Here are the possible states:

1. `InProgressState`: This is the initial state of the participant, and participants remain in this while they are solving the riddles.
   - Within this state, `solveRiddle` checks whether the input solves the current riddle.
2. `HelpState`: This state is entered when the participant requests help by calling the `askForHelp` method.
   - In this state, `solveRiddle` will solve the riddle regardless of the input provided.
   - After that, the participant will be transitioned back to `InProgressState` if there are remaining riddles to solve, otherwise they will be transitioned to `EscapedState`. 
3. `EscapedState`: If a participant successfully solves all riddles, they will be transitioned to the `EscapedState`.
   - In this state, `RiddleException` should be thrown if `solveRiddle` is called.

Note: 

1. If a riddle has been solved but passed as an argument to `solveRiddle` again, a `RiddleException` should be thrown.

2. A participant can choose any riddle to solve at a time. The argument `whichRiddle` of the `solveRiddle` method indicates to which riddle he/she submits an input in the `riddleList`.

**Your task:**
1. Implement the `InProgressState`, `HelpState`, and `EscapedState` classes, and make any changes needed in accordance with the UML 
   (You may need to make changes to complete the class signature, but are not allowed to change the name of the class).
3. Uncomment the provided line `this.state = new HelpState()` in the `solveRiddle` method of the `Participant` class.

Some basic tests have been provided in the `ParticipantTest` class. You can use them to clarify your understanding and increase your confidence that your solution is correct.
<br><br>


Part 2b) Implement the Observer Design Pattern in the context of the Escape Room.
The goal is to create a system where an observer is notified when a participant either asks for help or escapes successfully. 
Additionally, the observer should be able to provide information on whether a specific participant has asked for help or escaped.

In the provided `Observer` interface,
- methods `updateHelp` and `updateEscape` will be called when a participant asks for help and has escaped, respectively.
- methods `hasAskedForHelp` and `hasEscaped` checks whether a **specific** participant has asked for help or escaped, respectively.

**Your tasks:**
1. Create and implement the `GameMaster` class according to the UML Diagram.
    - The class must have a package header of `package Q1;` in the **first line** of the code file.
2. Modify the `Participant` class:
   - Create the missing attribute and method shown in the `Participant` class described in the UML diagram, and
   - Update the `askForHelp` method: notify all the observers when a specific participant asks for help.
   - Update the `solveRiddle` method: notify all the observers when a specific participant escapes.

- Some basic tests have been provided in the `ObserverTest` class. You can use them to clarify your understanding and increase your confidence that your solution is correct.
   - Uncomment the following two lines in the `ObserverTest` class. 
     ```
     observer = new GameMaster();
     participant.registerObserver(observer);
     ```
     <br><br>


***

#### You are expected to update the following files and push them (and only them) to GitLab:
* `RiddleCheckAnswerTest.java`
* `InProgressState.java`
* `HelpState.java`
* `EscapedState.java`
* `GameMaster.java`
* `Participant.java`

