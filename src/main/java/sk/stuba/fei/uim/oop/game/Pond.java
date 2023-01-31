package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.basic.DefaultCard;
import sk.stuba.fei.uim.oop.cards.basic.Duck;
import sk.stuba.fei.uim.oop.cards.crosshair.Crosshair;
import sk.stuba.fei.uim.oop.player.KillException;
import java.util.ArrayList;

public class Pond {
    private ArrayList<DefaultCard> cards =new ArrayList<>();
    private ArrayList<Crosshair> aims=new ArrayList<>();
    ArrayList<DefaultCard> cardDeck;

    public ArrayList<DefaultCard> getCardDeck() {
        return cardDeck;
    }

    public void setCardDeck(ArrayList<DefaultCard> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public void changeCard(){
        this.cardDeck.add(this.cards.remove(0));
    }
    public Pond(ArrayList<DefaultCard> deck) {
        this.cardDeck =deck;
        for(int i=0;i<6;i++){
            this.aims.add(new Crosshair());
            this.cards.add(deck.remove(0));
        }
    }

    public void shoot(int temp) throws KillException {
        this.aims.get(temp).putAway();
        if (this.cards.get(temp) instanceof Duck){
            this.cards.remove(temp).tryToHit();
        }
        else {
           this.cards.get(temp).tryToHit();
        }
    }

    @Override
    public String toString() {
        String s="";
        for (Crosshair cr:this.aims){
            s=s+" "+cr;
        }
        s+='\n';
        for (DefaultCard d:this.cards){
            s=s+" "+d;
        }
        return s;
    }
    public ArrayList<DefaultCard> getCards() {
        return cards;
    }

    public void setCards(ArrayList<DefaultCard> cards) {
        this.cards = cards;
    }

    public ArrayList<Crosshair> getAims() {
        return aims;
    }

    public void setAims(ArrayList<Crosshair> aims) {
        this.aims = aims;
    }

}
