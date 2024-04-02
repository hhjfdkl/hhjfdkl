package Questions;
/*
    has a correct answer, sends a true or false option to the Operations.UI
 */
public class TrueFalse extends Question
{
    private final boolean answer;
    public TrueFalse(String presentedTerm, String prompt, boolean trueOrFalse)
    {
        super(presentedTerm, "True or False: " + prompt + " is " + presentedTerm +".");
        this.answer = trueOrFalse;
    }


    public boolean check()
    {
        return this.answer;
    }
}
