package Questions;

import Operations.CardType;

/*
    has a correct answer, sends a true or false option to the Operations.UI
 */
public class TrueFalse extends Question
{
    private final boolean answer;
    public TrueFalse(String presentedTerm, String prompt, boolean trueOrFalse)
    {
        super(presentedTerm, "True or False: " + presentedTerm + " is " +
                prompt.substring(0,1).toLowerCase() +
                prompt.substring(1) + ".");
        this.answer = trueOrFalse;
    }

    @Override
    public CardType getCardType()
    {
        return CardType.TRUE_OR_FALSE;
    }

    public boolean check()
    {
        return this.answer;
    }
}
