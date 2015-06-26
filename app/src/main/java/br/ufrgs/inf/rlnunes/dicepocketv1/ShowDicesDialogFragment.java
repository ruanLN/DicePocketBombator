package br.ufrgs.inf.rlnunes.dicepocketv1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Prav1 on 26/06/2015.
 */
public class ShowDicesDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        ArrayList<Dice> dices = (ArrayList<Dice>) getArguments().getSerializable("dices");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        String resultado = "";
        int i = 1;
        int total = 0;
        for(Dice dice : dices) {
            int val = dice.roll();
            resultado = resultado + "Dado " + i + ": " + val +  "\n";
            i++;
            total += val;
        }
        resultado = resultado + "Total: " + total + "\n";
        builder.setMessage(resultado)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
