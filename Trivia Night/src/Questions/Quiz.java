package Questions;

/*
    multiple choice answer. One flashcard is drawn and either a term or definition are shown.
    Then three other terms/definitions are taken from the deck and assigned to the wrong answers.
 */

import Operations.CardType;
import org.jetbrains.annotations.NotNull;

public class Quiz  extends Question
{
    private final String a;
    private final String b;
    private final String c;
    private final String d;


    public String getA()
    {
        return a;
    }
    public String getB()
    {
        return b;
    }
    public String getC()
    {
        return c;
    }
    public String getD()
    {
        return d;
    }

    public Quiz(String correctAnswer, String prompt, String answer1, String answer2, String answer3, String answer4)
    {
        super(correctAnswer, "What is " + prompt.substring(0,1).toLowerCase() +
                prompt.substring(1) + "?");

        this.a = answer1;
        this.b = answer2;
        this.c = answer3;
        this.d = answer4;
    }

    @Override
    public CardType getCardType()
    {
        return CardType.QUIZ;
    }

}
