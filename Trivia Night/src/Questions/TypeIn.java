package Questions;

import Operations.CardType;

/*
    gets user input from the Operations.UI and compares what is put in against correct answer
 */
public class TypeIn extends Question
{

    public TypeIn(String correctAnswer, String prompt)
    {
        super(correctAnswer, "What is " + prompt.substring(0,1).toLowerCase() +
                prompt.substring(1) + "?");

    }

    @Override
    public CardType getCardType()
    {
        return CardType.TYPE_IN;
    }
}
