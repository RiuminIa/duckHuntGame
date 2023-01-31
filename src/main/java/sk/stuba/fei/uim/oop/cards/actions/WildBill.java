package sk.stuba.fei.uim.oop.cards.actions;
import sk.stuba.fei.uim.oop.game.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class WildBill extends Action{
    public WildBill() {
        super("Wild Bill");
    }
    public void activation(Pond pond) throws Exception {
        int temp;
        temp=choiceCard(0);
        pond.shoot(temp);
    }
    public boolean checkActivations(Pond pond){
        return true;
    }

}
