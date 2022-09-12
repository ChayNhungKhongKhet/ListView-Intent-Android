package com.phamtantb24.listviewevent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailCombatant extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_combatant);
        Intent intent = this.getIntent();
        Combatant combatant = (Combatant) intent.getSerializableExtra("data");
        textView = findViewById(R.id.textView);
        textView.setText("Man hinh chi tiet "+combatant.getName()+"---"+combatant.getPower());

    }
}