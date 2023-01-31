package sk.stuba.fei.uim.oop.player;

import sk.stuba.fei.uim.oop.cards.actions.Action;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;

public class Player {
    private String name;
    private char symbol;
    ArrayList <Action> actions = new ArrayList<>();
    private int liveDucks;

    public Player(int x){
        do {
            this.name = ZKlavesnice.readString("player " + (x) + " enter your name");
            if(this.name.isBlank()){
                System.out.println("You didn't enter anything");
            }
        }while(this.name.isBlank());
        this.liveDucks=5;
    }
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public ArrayList<Action> getActions() {

        return actions;
    }

    public void setActions(ArrayList<Action> actionsTemp) {
        for(int i=this.actions.size();i<3;i++){
            this.actions.add(actionsTemp.remove(0));
        }
    }
    public void kill() throws KillException {
        this.liveDucks--;
        if(this.liveDucks==0){
            System.out.println(this.name+"'s ducks were killed");
            throw new KillException(String.valueOf(this.symbol));
        }
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        String s="";
        s="Player "+this.name+" your turn,"+" you have "+this.liveDucks+" ducks, your ducks are: "+"'"+this.symbol+"'";
        return s;
    }
    public String printActivity(){
        StringBuilder s= new StringBuilder();
        for (int i=0;i<3;i++){
            s.append(i).append("=").append(this.actions.get(i)).append(" ");
        }
        return s.toString();
    }
    public void changeActivite(ArrayList<Action> actionsTemp,int number){
        actionsTemp.add(this.actions.remove(number));
        setActions(actionsTemp);
    }
    public String getName() {
        return name;
    }

    public int getLiveDucks() {
        return liveDucks;
    }

    public void setLiveDucks(int liveDucks) {
        this.liveDucks = liveDucks;
    }
}
