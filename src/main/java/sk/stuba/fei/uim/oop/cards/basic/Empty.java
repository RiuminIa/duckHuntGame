package sk.stuba.fei.uim.oop.cards.basic;

public class Empty extends DefaultCard {
    public Empty() {
        super('~');
    }
    public void tryToHit(){
        System.out.println("you missed");
    }
}
