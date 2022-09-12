package com.phamtantb24.listviewevent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CombatantAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Combatant> combatants;

    public CombatantAdapter(Context context, int layout, List<Combatant> combatants) {
        this.context = context;
        this.layout = layout;
        this.combatants = combatants;
    }

    @Override
    public int getCount() {
        return combatants.size();
    }

    @Override
    public Object getItem(int i) {
        return combatants.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        // mapping view
        TextView nameTxt = view.findViewById(R.id.name);
        TextView powerTxt = view.findViewById(R.id.power);
        ImageView avatarEmp = view.findViewById(R.id.avatar);

        Combatant combatant = (Combatant) getItem(i);
        nameTxt.setText(combatant.getName());
        powerTxt.setText(""+combatant.getPower());
        avatarEmp.setImageResource(combatant.getImage());
        return view;
    }
}
