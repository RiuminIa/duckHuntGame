package sk.stuba.fei.uim.oop.cards.actions;

import sk.stuba.fei.uim.oop.game.Pond;

public class DuckMarch extends Action{
    public DuckMarch( ) {
        super("Duck march");
    }
    public void activation(Pond pond){
        pond.changeCard();
    }
    public boolean checkActivations(Pond pond){
        return true;
    }

}
