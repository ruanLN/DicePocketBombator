package br.ufrgs.inf.rlnunes.dicepocketv1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Prav1 on 11/06/2015.
 */
public class DiceListItemViewAdapter extends ArrayAdapter<Dice> {
    int resource;
    Context context;
    List<Dice> dices;
    final DiceListItemViewAdapter adapter;
    public DiceListItemViewAdapter(Context context, List<Dice> arr) {
        super(context, R.layout.dice_list_item_view);
        this.resource = R.layout.dice_list_item_view;
        this.context = context;
        this.dices = arr;
        adapter = this;
    }

    @Override
    public int getCount() {
        return dices.size();
    }

    @Override
    public Dice getItem(int position) {
        return dices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.dice_list_item_view, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.textView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        switch(dices.get(position).getnFaces()) {
            case 20:
                imageView.setImageResource(R.drawable.d20);
                break;
            case 6:
                imageView.setImageResource(R.drawable.d6);
                break;
            case 4:
                imageView.setImageResource(R.drawable.d4);
                break;
            default:
                imageView.setImageResource(R.drawable.d6);                
        }
        textView.setText(dices.get(position).toString());


        Button btn = (Button) rowView.findViewById(R.id.remove);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getContext(), dices.get(position).toString(), Toast.LENGTH_LONG).show();
                dices.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        return rowView;
    }
}
