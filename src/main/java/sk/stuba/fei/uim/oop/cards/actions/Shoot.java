package sk.stuba.fei.uim.oop.cards.actions;
import sk.stuba.fei.uim.oop.cards.crosshair.Crosshair;
import sk.stuba.fei.uim.oop.game.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class Shoot extends Action{
    public Shoot() {
        super("Shoot");
    }
    public void activation(Pond pond) throws Exception {
        int temp;
            temp= choiceCard(0);
            if (!(pond.getAims().get(temp).isAim())){
                System.out.println("Target not found");
                this.activation(pond);
            }
            else{
                pond.shoot(temp);
            }
    }


    public boolean checkActivations(Pond pond){
        for(Crosshair cr: pond.getAims()){
            if (cr.isAim()){
                return true;
            }
        }
        return false;
    }

}
