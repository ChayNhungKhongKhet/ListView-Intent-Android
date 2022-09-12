package com.phamtantb24.listviewevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewCombatant;
    List<Combatant> combatants;
    CombatantAdapter adapter;
    EditText nameEdit, powerEdit;
    Button addBtn, delBtn;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        adapter = new CombatantAdapter(this, R.layout.info_line_layout, combatants);
        listViewCombatant.setAdapter(adapter);
        listViewCombatant.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Combatant viewClick = combatants.get(i);
                nameEdit.setText(viewClick.getName());
                powerEdit.setText(""+viewClick.getPower());
                id = i;
            }
        });

        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                combatants.remove(id);
                adapter.notifyDataSetChanged();
            }
        });
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString();
                int power = Integer.parseInt(powerEdit.getText().toString());
                combatants.add(new Combatant(name,power));
                adapter.notifyDataSetChanged();
            }
        });

        listViewCombatant.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Combatant viewClick = combatants.get(position);
                Intent intent = new Intent(MainActivity.this, DetailCombatant.class);
                intent.putExtra("data", viewClick);
                startActivity(intent);
                return true;
            }
        });
    }
    private void mapping() {
        listViewCombatant = findViewById(R.id.listViewCombatant);
        nameEdit = findViewById(R.id.nameEdit);
        powerEdit = findViewById(R.id.powerEdit);
        addBtn = findViewById(R.id.addBtn);
        delBtn = findViewById(R.id.delBtn);
        combatants = new ArrayList<>();
        combatants.add(new Combatant("Goku",2412, R.drawable.goku));
        combatants.add(new Combatant("Vegeta",2433,R.drawable.vegeta));
        combatants.add(new Combatant("Frieza",2754,R.drawable.frieza));
    }
}