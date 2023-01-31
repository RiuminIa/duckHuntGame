package sk.stuba.fei.uim.oop.cards.crosshair;

public class Crosshair {
    private boolean aim;

    public boolean isAim() {
        return aim;
    }
    private char simbol;

    public Crosshair() {
        this.aim = false;
        this.simbol='ᴼ';
    }

    public boolean activate(){
        if (!this.aim){
            this.aim=true;
            this.simbol='×';
            return true;
        }
        else{
            return false;
        }
    }
    public void putAway(){
        this.aim = false;
        this.simbol='ᴼ';
    }
    @Override
    public String toString() {
        return (""+this.simbol);
    }
}

