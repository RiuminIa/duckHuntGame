package sk.stuba.fei.uim.oop.cards.basic;

import sk.stuba.fei.uim.oop.player.KillException;

public abstract class DefaultCard {
    private char name;
    protected DefaultCard(char name){
        this.name=name;
    }
    public abstract void tryToHit() throws KillException;

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return (""+name);
    }
}
