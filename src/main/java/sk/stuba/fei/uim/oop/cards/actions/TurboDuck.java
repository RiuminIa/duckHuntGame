package sk.stuba.fei.uim.oop.cards.actions;
import sk.stuba.fei.uim.oop.cards.basic.DefaultCard;
import sk.stuba.fei.uim.oop.cards.basic.Duck;
import sk.stuba.fei.uim.oop.game.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public class TurboDuck extends Action{
    public TurboDuck() {
        super("Turboduck");
    }
    public void activation(Pond pond) throws Exception {
        int temp;
            temp=choiceCard(1);
            if (!(pond.getCards().get(temp) instanceof Duck)){
                System.out.println("You cannot move this card");
                this.activation(pond);
            }
            else{
                pond.getCards().add(0,pond.getCards().remove(temp));
            }
    }
    public boolean checkActivations(Pond pond){
        for (int i=1;i<6;i++){
            if (pond.getCards().get(i) instanceof Duck){
                return true;
            }
        }
        return false;
    }

}
