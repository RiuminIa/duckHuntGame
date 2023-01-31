package sk.stuba.fei.uim.oop.game;


import sk.stuba.fei.uim.oop.cards.actions.Action;
import sk.stuba.fei.uim.oop.player.KillException;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Game {
    private final Board board;
    private int livePlayers;

    public Game() {
        System.out.println("Welcome to the realistic world of duck hunting");
        this.board = new Board();
        this.livePlayers=board.getNumberOfPlayers();
        try {
            while (true) {
                for (Player p:this.board.getPlayers()) {
                    if(p.getLiveDucks()>0) {
                        run(p);
                    }
                }
            }
        }
        catch (Exception e) {
            System.out.println("Player " + this.board.getPlayers().get(0).getName() + " WIN!!!");
        }
    }
    private void run(Player player) throws Exception {
        int temp;
        this.board.printDeck();
        if(checkActivations(player)) {
            System.out.println(player);
                while(true) {
                    temp = choiceCard("Choose one activity card "+player.printActivity());
                    if (!(checkActivations(temp,player))){
                        System.out.println("You can't use "+player.getActions().get(temp)+" card now");
                    }
                    else{
                        try {
                            player.getActions().get(temp).activation(this.board.getPond());
                            break;
                        }
                        catch (KillException e){
                            this.livePlayers--;
                            this.board.getPlayers().forEach(n->{if (n.getSymbol()==e.getMessage().charAt(0)){
                                                     this.board.getActionsCards().addAll(n.getActions());
                                                     n.getActions().clear();
                            }
                            });
                            if (this.livePlayers==1){
                                throw new Exception();
                            }
                            else{
                                break;
                            }
                        }
                        catch (Exception e){
                            continue;
                        }
                    }
                }
            this.board.checkDeck();
        }
        else {
            temp = choiceCard("Player " + player.getName() + " you don't have any Activity cards to use right now. Choose one activity card to change\n" +
                        player.printActivity());
        }
        player.changeActivite(this.board.getActionsCards(),temp);
    }

    private boolean checkActivations(Player player){
        for (Action a:player.getActions()){
            if(a.checkActivations(this.board.getPond())){
                return true;
            }
        }
        return false;
    }
   private int choice (String s) throws Exception {
        int temp;
        temp = ZKlavesnice.readInt(s);
        if (temp < 0 || temp > 2 ) {
            throw new Exception("There is no such number");
        }
        return temp;
    }
    private int choiceCard(String s) {
        int temp;
        try{
            temp=choice(s);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            temp=choiceCard(s);
        }
        return temp;
    }
    private boolean checkActivations(int temp,Player player){
        return player.getActions().get(temp).checkActivations(this.board.getPond());
    }
}
