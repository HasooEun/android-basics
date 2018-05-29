package com.example.hasoo.vendingmachine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make instance
        final EditText editText = (EditText)findViewById(R.id.editText);
        final EditText editText2 = (EditText)findViewById(R.id.editText2);
        final EditText editText3 = (EditText)findViewById(R.id.editText3);
        final CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        final TextView textView4 = (TextView)findViewById(R.id.textView4);
        final TextView textView5 = (TextView)findViewById(R.id.textView5);
        final TextView textView6 = (TextView)findViewById(R.id.textView6);
        Button button = (Button)findViewById(R.id.button);

        // set onClickListener for button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calculation
                int americano = Integer.parseInt(editText.getText().toString());
                int cafelatte = Integer.parseInt(editText2.getText().toString());
                int cafemocha = Integer.parseInt(editText3.getText().toString());
                int price = americano*1000 + cafelatte*1500 + cafemocha*1700;
                int discount = (int)(checkBox.isChecked()?price*0.1:0);
                int discountedPrice = price - discount;

                // make sentence
                String sOrderTotal = "주문갯수: " + (americano+cafelatte+cafemocha);
                String sDiscountTotal = "할인금액: " + discount;
                String sPriceTotal = "결제금액: " + discountedPrice;

                // output
                textView4.setText(sOrderTotal);
                textView5.setText(sDiscountTotal);
                textView6.setText(sPriceTotal);
            }
        });
    }
}
