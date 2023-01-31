package sk.stuba.fei.uim.oop.cards.basic;

import sk.stuba.fei.uim.oop.player.KillException;
import sk.stuba.fei.uim.oop.player.Player;

public class Duck extends DefaultCard {
    private Player owner;

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Duck(char name,Player player) {
        super(name);
        this.owner=player;
    }
    public void tryToHit() throws KillException {
        System.out.println("you killed "+owner.getName()+"'s duck ");
        this.owner.kill();
    }
}
