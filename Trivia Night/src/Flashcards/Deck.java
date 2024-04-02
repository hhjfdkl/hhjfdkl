package Flashcards;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/*
     The deck features our list of cards. It uses a file reader to generate the deck list.
     Anything that deals with card manipulation is here - with respect to the deck at least;
     things like reading cards is in the Flashcards.Flashcard class. Flashcards.Deck only cares about taking cards
     out of the deck, putting cards into the deck, and counting how many cards we have.
*/

public class Deck implements HasDice
{

 private List <Card> cards = new ArrayList<>();

 public Deck(){}

 public Deck(List<Card> cards)
 {
  this.cards = cards;
 }

 public Deck(Card card)
 {
  this.cards.add(card);
 }




//gets a card from list without taking it out
public Card peek(int n)
{
  return this.cards.get(n);
}

//pulls a card out of the deck
 public Card pull(int n)
 {
  Card card = peek(n);
  this.cards.remove(n);
  return card;
 }

 public void put(Card card)
 {
  cards.add(card);
 }



 public int count()
 {
  return this.cards.size();
 }

 //this method reduces repeating code with our objects.
 public Card draw()
 {
  return pull(roll(count()));
 }



}
