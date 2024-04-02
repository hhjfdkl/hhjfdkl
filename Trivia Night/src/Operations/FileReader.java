package Operations;

import Flashcards.Card;
import Flashcards.Flashcard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader
{
    private String input = "input.txt";

    public void setInput(String input){
        this.input = input;
    }

    public List<Card> generateCards()
    {
        File f = new File(input);
        List<Card> deck = new ArrayList<>();
        try
        {
            Scanner reader = new Scanner(f);
            String str = null;
            while (reader.hasNextLine())
            {
                str = reader.nextLine();
                String[] s = str.split(":");
                deck.add(new Flashcard(s[0], s[1], s[2]));
            }
        } catch (FileNotFoundException e)
        {
            System.out.println("Invalid file input");
            //this should be thrown to the Operations.UI
        }
        return deck;
    }

}
