package com.smorzhok.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {


    private static final String EXTRA_ADDITIVES = "additives";
    private static final String EXTRA_USERNAME = "userName";
    private static final String EXTRA_DRINKTYPE = "drinkType";
    private static final String EXTRA_DRINK = "drink";

    private TextView textViewName;
    private TextView textViewDrink;
    private TextView textViewTypeOfDrinks;
    private TextView textViewAddivies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        Intent intent = getIntent();
        setUp();

        textViewAddivies.setText(intent.getStringExtra(EXTRA_ADDITIVES));
        textViewName.setText(intent.getStringExtra(EXTRA_USERNAME));
        textViewTypeOfDrinks.setText(intent.getStringExtra(EXTRA_DRINKTYPE));
        textViewDrink.setText(intent.getStringExtra(EXTRA_DRINK));

    }

    private void setUp(){
        textViewAddivies = findViewById(R.id.textViewAddivies);
        textViewName = findViewById(R.id.textViewName);
        textViewTypeOfDrinks = findViewById(R.id.textViewTypeOfDrinks);
        textViewDrink = findViewById(R.id.textViewDrink);
    }
    public static Intent newIntent(Context context,
                                   String userName,
                                   String additives,
                                   String drinkType,
                                   String drink
                                   ) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra(EXTRA_ADDITIVES, additives);
        intent.putExtra(EXTRA_DRINKTYPE, drinkType);
        intent.putExtra(EXTRA_USERNAME, userName);
        intent.putExtra(EXTRA_DRINK, drink);

        return intent;
    }
}