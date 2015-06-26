package br.ufrgs.inf.rlnunes.dicepocketv1;

import android.os.Parcelable;

import java.io.Serializable;
import java.util.Random;

/**
 * Created by Prav1 on 08/06/2015.
 */
public class Dice implements Serializable{
    private int nFaces;
    public Dice(int nf) {
        this.nFaces = nf;
    }

    public int roll() {
        Random randomizer = new Random();
        return randomizer.nextInt(nFaces) + 1;
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
}
