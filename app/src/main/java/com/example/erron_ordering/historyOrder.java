package com.example.erron_ordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class historyOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_order);

        final Button buttonOrder = (Button) findViewById(R.id.buttonOK);

        TextView showItems = findViewById(R.id.showItems);
        TextView textItems = findViewById(R.id.textItems);
        TextView textTotal = findViewById(R.id.textTotal);
        TextView showAmount = findViewById(R.id.showAmount);
        TextView textAddiMenu = findViewById(R.id.textAddiMenus);
        TextView showAddMenu = findViewById(R.id.showAddMenu);

        showItems.setTextColor(Color.BLUE);
        textItems.setTextColor(Color.BLUE);
        textTotal.setTextColor(Color.RED);
        showAmount.setTextColor(Color.RED);
        textAddiMenu.setTextColor(getResources().getColor(R.color.textcolor));
        showAddMenu.setTextColor(getResources().getColor(R.color.textcolor));

        String items = getIntent().getStringExtra("Total");
        String radioselect = getIntent().getStringExtra("Selection");
        String totalPrice = getIntent().getStringExtra("Price");

        showAmount.setText(totalPrice);
        showAddMenu.setText(radioselect);
        showItems.setText(items);


        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);


            }
        });
    }
}