package ua.kpi.tef.ti71.lab6;

import lombok.ToString;
import ua.kpi.tef.ti71.lab6.entity.Test;

import java.util.Random;

public class CheckTest {

    private Test test;
    private Integer rightAnswers;
    private static final Random RANDOM = new Random();

    public CheckTest(Test test) {
        this.test = test;
        this.rightAnswers = RANDOM.nextInt(100) % (test.getQuestionQuantity() + 1);
        System.out.println("Checking test...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getMarkOutOf12() {
        var result = (int) ((double) getRightAnswersQuantity() / (double) test.getQuestionQuantity() * 12);
        return result == 0 ? 1 : result;
    }

    public int getRightAnswersQuantity() {

        return rightAnswers;
    }

    public String getfullResult() {
        return "Your result of the " + test.getClass().getSimpleName() + ":\nQuestions quantity: " + test.getQuestionQuantity() +
                "\nRight answers: " + rightAnswers + "\nYour mark: " + getMarkOutOf12();
    }


}
