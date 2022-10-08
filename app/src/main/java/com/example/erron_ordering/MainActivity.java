package com.example.erron_ordering;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String radioSelect, menus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonOrder = findViewById(R.id.buttonOrder);

        EditText editPizza = findViewById(R.id.editTextPizza);
        EditText editPasta = findViewById(R.id.editTextPasta);
        EditText editSalad = findViewById(R.id.editTextSalad);

        CheckBox membershipCard = findViewById(R.id.checkBox);

        RadioButton pickles = findViewById(R.id.radioPickles);
        RadioButton sauce = findViewById(R.id.radioSauce);

       /* TextView coba1 = findViewById(R.id.textcoba1);
        TextView coba2 = findViewById(R.id.textcoba2);
        TextView coba3 = findViewById(R.id.textcoba3);*/


        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (pickles.isChecked()) {
                    radioSelect = pickles.getText().toString();
                } else if (sauce.isChecked()) {
                    radioSelect = sauce.getText().toString();
                }

               /* if(editPizza = null){
                    String m1 = "Pizza";
                }*/

                String cPizza = editPizza.getText().toString();
                String cPasta = editPasta.getText().toString();
                String cSalad = editSalad.getText().toString();

                int countPizza = Integer.parseInt(cPizza);
                int countPasta = Integer.parseInt(cPasta);
                int countSalad = Integer.parseInt(cSalad);

                int sendItems = countPasta + countPizza + countSalad;
                String l = String.valueOf(sendItems);

                int amountPizza = countPizza * 16000;
                int amountPasta = countPasta * 11000;
                int amountSalad = countSalad * 4000;

                int t=amountPasta+amountPizza+amountSalad;

                /*if (membershipCard.isChecked()) {
                    //membershipCard.setTextColor(Color.parseColor("059C54"));
                    int b = (amountPasta+amountPizza+amountSalad)*7/100;
                    t= t-b;
                }*/

                /*coba1.setText("Total Items: "+sendItems);
                coba2.setText("Total Price: "+t);
                coba3.setText("Additional Menu: "+radioSelect);

                coba1.setTextColor(Color.BLUE);
                coba2.setTextColor(Color.RED);
                coba3.setTextColor(getResources().getColor(R.color.textcolor));*/

                Intent i = new Intent(getApplicationContext(), historyOrder.class);
                i.putExtra("Total", l);
                i.putExtra("Selection", radioSelect);
                if (membershipCard.isChecked()) {
                    //membershipCard.setTextColor(Color.parseColor("059C54"));
                    int b = t*7/100;
                    t = t-b;
                }

                String n = String.valueOf(t);
                i.putExtra("Price",n);

                startActivity(i);

            }
        });
    }
}