package Flashcards;/*
    This is the core of this program.
    For now, it's a simple object with three String variables: term, definition, example.
    I will likely either add subclasses that are specific to topic (particularly if the
    subject requires the flashcards to behave differently) or I'll simply add another
    String variable.
*/

public class Flashcard extends Card
{
    private final String term;
    private final String definition;
    private final String example;

    public String revealTerm()
    {
        return term;
    }

    public String revealDefinition()
    {
        return definition;
    }

    public String revealExample()
    {
        return example;
    }



    //basic flashcard created
    public Flashcard(String term, String definition, String example)
    {
        this.term = term;
        this.definition = definition;
        this.example = example;
    }


}
