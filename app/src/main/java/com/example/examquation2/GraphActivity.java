package com.example.examquation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class GraphActivity extends AppCompatActivity {
    ArrayList<Integer> ValueList;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        ValueList = new ArrayList<Integer>();

        linearLayout = findViewById(R.id.mLinearLayout2);

        Intent intent =getIntent();
        ValueList = intent.getIntegerArrayListExtra("Values");
        Toast.makeText(this, "If Result not show on the screen, plese go back and update your Values", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "ArrayList Value "+ValueList.get(0), Toast.LENGTH_SHORT).show();

        int Division = ((ValueList.size()*2)+1);

        GraphView graphView = new GraphView(this,ValueList,Division);

        linearLayout.addView(graphView);

    }
}
