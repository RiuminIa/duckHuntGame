package sk.stuba.fei.uim.oop.cards.actions;
import sk.stuba.fei.uim.oop.game.Pond;
import java.util.Collections;

public class Scatter extends Action{
    public Scatter( ) {
        super("Scatter");
    }
    public void activation(Pond pond){
        Collections.shuffle(pond.getCards());
    }
    public boolean checkActivations(Pond pond){
        return true;
    }

}
