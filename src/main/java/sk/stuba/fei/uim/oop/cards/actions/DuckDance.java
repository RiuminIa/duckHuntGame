package sk.stuba.fei.uim.oop.cards.actions;
import sk.stuba.fei.uim.oop.game.Pond;
import java.util.Collections;

public class DuckDance extends Action{
    public DuckDance( ) {
        super("Duck dance");
    }
    public void activation(Pond pond){
        pond.getCardDeck().addAll(pond.getCards());
        pond.getCards().clear();
        Collections.shuffle(pond.getCardDeck());
    }
    public boolean checkActivations(Pond pond){
        return true;
    }

}
