package br.ufrgs.inf.rlnunes.dicepocketv1;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Prav1 on 08/06/2015.
 */
public class Dice implements Serializable{
    private int nFaces;
    private int value;
    private boolean active;
    public Dice(int nf) {
        this.nFaces = nf;
        this.setValue(-1);
        this.setActive(true);
    }

    public int roll() {
        Random randomizer = new Random();
        this.value = randomizer.nextInt(nFaces) + 1;
        return value;
    }

    public void setnFaces(int nf) {
        this.nFaces = nf;
    }

    public int getnFaces() {
        return this.nFaces;
    }

    public String toString() {
        return "Faces: " + nFaces;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
