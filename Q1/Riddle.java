package Q1;

import java.util.Arrays;

public class Riddle {
    public enum RiddleType {
        TEXT_RIDDLE,
        NUMERIC_RIDDLE,
        ANAGRAM_RIDDLE;
    }

    private String question;
    private String answer;
    private boolean isSolved;
    private RiddleType type;

    public Riddle(String question, String answer, RiddleType type) {
        this.question = question;
        this.answer = answer;
        this.isSolved = false;
        this.type = type;
    }

    public String askQuestion() {
		return this.question;
    }

    public boolean checkAnswer(String input) {
        boolean isCorrect = false;

        if (type == RiddleType.TEXT_RIDDLE) {
            if (input.equalsIgnoreCase(answer)) {
                isCorrect = true;
            }
        } else if (type == RiddleType.NUMERIC_RIDDLE) {
            if (input.matches("\\d+") && Integer.parseInt(input) == Integer.parseInt(answer)) {
                isCorrect = true;
            }
        } else if (type == RiddleType.ANAGRAM_RIDDLE) {
            char[] inputChars = input.toLowerCase().toCharArray();
            char[] answerChars = answer.toLowerCase().toCharArray();
            Arrays.sort(inputChars);
            Arrays.sort(answerChars);
            if (Arrays.equals(inputChars, answerChars)) {
                isCorrect = true;
            }
        }

        if (isCorrect) {
            isSolved = true;
        }
        return isCorrect;
    }

    public boolean isSolved() {
		return isSolved;
    }

    public void setSolved() { isSolved = true; }

    public String getAnswer() {
        return answer;
    }
}