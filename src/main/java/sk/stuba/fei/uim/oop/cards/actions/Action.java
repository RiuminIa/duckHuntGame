package sk.stuba.fei.uim.oop.cards.actions;

import sk.stuba.fei.uim.oop.game.Pond;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

public abstract class Action {
    private final String name;
    protected Action(String name){
        this.name=name;
    }
    public abstract void activation(Pond pond) throws Exception;
    public abstract boolean checkActivations(Pond pond);
    protected int choiceCard(int to) throws Exception {
        int temp ;
        try {
            temp = choice(to);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            temp=choiceCard(to);
        }
        if (temp==6) {
            throw new Exception();
        }
        return temp;
    }
    private int choice(int to) throws Exception {
        int temp=0;
        temp= ZKlavesnice.readInt("choose card ("+to+"-5) or press 6 for back");
        if (temp<to || temp>6){
            throw new Exception("There is no such number");
        }
        return temp;
    }
    @Override
    public String toString() {
        return name;
    }
    //abstract public activate();
}
