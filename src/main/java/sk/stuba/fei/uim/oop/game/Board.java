package sk.stuba.fei.uim.oop.game;

import sk.stuba.fei.uim.oop.cards.actions.*;
import sk.stuba.fei.uim.oop.cards.basic.DefaultCard;
import sk.stuba.fei.uim.oop.cards.basic.Duck;
import sk.stuba.fei.uim.oop.cards.basic.Empty;
import sk.stuba.fei.uim.oop.player.Player;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.*;

public class Board {
    private Pond pond;
    private ArrayList<DefaultCard> cardDeck =new ArrayList<>();
    private ArrayList<Action> actionsCards=new ArrayList<>();
    private final Map<Integer, Character> symbols= new HashMap<>(Map.of(1,'o',2,'p',3,'g',4,'y',5,'v',6,'b'));
    private ArrayList <Player> players=new ArrayList<>();
    private int numberOfPlayers;


    public Board() {
        this.numberOfPlayers= choiceSomeParameters("Enter number of players (2-6):",2,6);
        makeActionCards();
        makePlayers();
        makePond();
        this.pond =new Pond(cardDeck);

    }
    public void printDeck(){
        System.out.println("\n 0 1 2 3 4 5");
        System.out.println(pond);
    }

    private void makeActionCards(){
        for (int i=0;i<10;i++){
            this.actionsCards.add(new Aim());
        }
        for (int i=0;i<12;i++){
            this.actionsCards.add(new Shoot());
        }
        for (int i=0;i<2;i++){
            this.actionsCards.add(new WildBill());
        }
        for (int i=0;i<6;i++){
            this.actionsCards.add(new DuckMarch());
        }
        for (int i=0;i<2;i++){
            this.actionsCards.add(new Scatter());
        }
        this.actionsCards.add(new TurboDuck());
        this.actionsCards.add(new DuckDance());
        Collections.shuffle(this.actionsCards);
    }
    private void makePond(){
        for(int i=0;i<5;i++){
            cardDeck.add(new Empty());
        }
        for(Player player:players){
            for(int i=0;i<5;i++){
                this.cardDeck.add(new Duck(player.getSymbol(),player));
            }
        }
        Collections.shuffle(this.cardDeck);
    }

    private void makePlayers(){
        int key;
        for (int i=0;i<numberOfPlayers;i++){
            this.players.add(new Player(i+1));
            do {
                key=ZKlavesnice.readInt("Choose a symbol of your ducks. " +symbols.toString());
                if(!this.symbols.containsKey(key)){
                    System.out.println("There is no such number");
                }
            }while(!this.symbols.containsKey(key));
                this.players.get(i).setSymbol(symbols.get(key));
                System.out.println("symbol of your ducks are "+"'"+ symbols.remove(key)+"'");
                this.players.get(i).setActions(actionsCards);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void checkDeck(){
        if (this.pond.getCards().size()<6){
            for (int i = pond.getCards().size(); i<6; i++){
                this.pond.getCards().add(this.cardDeck.remove(0));
            }
        }
    }
    private int choice (String s, int to, int end) throws Exception {
        int temp;
        temp = ZKlavesnice.readInt(s);
        if (temp < to || temp > end ) {
            throw new Exception("There is no such number");
        }
        return temp;
    }
    private int choiceSomeParameters(String s, int to, int end) {
        int temp;
        try{
            temp=choice(s,to,end);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            temp=choiceSomeParameters(s,to,end);
        }
        return temp;
    }

    public Pond getPond() {
        return pond;
    }

    public void setPond(Pond pond) {
        this.pond = pond;
    }


    public ArrayList<DefaultCard> getCardDeck() {
        return this.cardDeck;
    }

    public void setCardDeck(ArrayList<DefaultCard> cardDeck) {
        this.cardDeck = cardDeck;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
    public void setActionsCards(ArrayList<Action> actionsCards) {
        this.actionsCards = actionsCards;
    }
    public ArrayList<Action> getActionsCards() {
        return actionsCards;
    }
}
