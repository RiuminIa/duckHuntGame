package sk.stuba.fei.uim.oop.cards.actions;

import sk.stuba.fei.uim.oop.cards.crosshair.Crosshair;
import sk.stuba.fei.uim.oop.game.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Aim extends Action {
    public Aim() {
        super("Aim");
    }
    public void activation(Pond pond) throws Exception {
        int temp;
            temp=choiceCard(0);
            if(!pond.getAims().get(temp).activate()){
                System.out.println("The target has already been activated");
                this.activation(pond);
            }
        }
    public boolean checkActivations(Pond pond){
        for(Crosshair cr: pond.getAims()){
            if (!cr.isAim()){
                return true;
            }
        }
        return false;
    }
}
