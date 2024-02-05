package com.smorzhok.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MakeOrderActivity extends AppCompatActivity {

    private static final String EXTRA_USER_NAME = "userName";

    private TextView textViewGreetings;
    private TextView textViewAddivies;

    private RadioGroup radioGroupsDrinks;
    private RadioButton radioButtonTea;
    private RadioButton radioButtonCoffee;

    private CheckBox checkBoxSugar;
    private CheckBox checkBoxMilk;
    private CheckBox checkBoxLemon;

    private Spinner spinnerTea;
    private Spinner spinnerCoffee;

    private String userName;
    private String teaAdditives;
    private String coffeeAdditives;
    private String drink;
    private
    ArrayList<String> additives = new ArrayList<>();
    String drinkType="";

    private Button buttonMakeOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_order);
        initFields();
        setUpUserName();
        radioGroupsDrinks.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (radioButtonTea.getId() == i) {
                    setTeaView();
                    checkBoxLemon.setVisibility(View.VISIBLE);
                    spinnerCoffee.setVisibility(View.INVISIBLE);
                    spinnerTea.setVisibility(View.VISIBLE);
                } else {
                    setCoffeeView();
                    checkBoxLemon.setVisibility(View.INVISIBLE);

                    spinnerCoffee.setVisibility(View.VISIBLE);
                    spinnerTea.setVisibility(View.INVISIBLE);
                }

            }

        });
        radioButtonTea.setChecked(true);

        buttonMakeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                madeOrder();
                Intent intent = OrderDetailActivity.newIntent(MakeOrderActivity.this,
                        userName,
                        additives.toString(),
                        drinkType, drink
                        );
                startActivity(intent);
            }
        });
    }


    private void madeOrder() {
        if (radioButtonTea.isChecked() && checkBoxLemon.isChecked()) {
            additives.add(checkBoxLemon.getText().toString());
        }

        if (checkBoxSugar.isChecked())
            additives.add(checkBoxSugar.getText().toString());
        if (checkBoxMilk.isChecked())
            additives.add(checkBoxMilk.getText().toString());

        if (radioButtonTea.isChecked())
        {
            drinkType = spinnerTea.getSelectedItem().toString();
        }
        else drinkType = spinnerCoffee.getSelectedItem().toString();

    }

    private void setTeaView() {
        drink = getString(R.string.adding, getString(R.string.Tea).toLowerCase());
        textViewAddivies.setText(drink);

    }

    private void setCoffeeView() {
        drink = getString(R.string.adding, getString(R.string.Coffee).toLowerCase());
        textViewAddivies.setText(drink);
    }

    public static Intent newIntent(Context context, String userName) {
        Intent intent = new Intent(context, MakeOrderActivity.class);
        intent.putExtra(EXTRA_USER_NAME, userName);
        return intent;
    }

    private void setUpUserName() {
        userName = getIntent().getStringExtra(EXTRA_USER_NAME);
        String greetings = getString(R.string.Hello_user);
        String result = String.format(greetings, userName);
        textViewGreetings.setText(result);
    }

    private void initFields() {
        textViewGreetings = findViewById(R.id.textViewGreetings);
        textViewAddivies = findViewById(R.id.textViewAddivies);

        radioGroupsDrinks = findViewById(R.id.radioGroupsDrinks);
        radioButtonTea = findViewById(R.id.radioButtonTea);
        radioButtonCoffee = findViewById(R.id.radioButtonCoffee);

        checkBoxSugar = findViewById(R.id.checkBoxSugar);
        checkBoxMilk = findViewById(R.id.checkBoxMilk);
        checkBoxLemon = findViewById(R.id.checkBoxLemon);

        spinnerTea = findViewById(R.id.spinnerTea);
        spinnerCoffee = findViewById(R.id.spinnerCoffee);

        buttonMakeOrder = findViewById(R.id.buttonMakeOrder);

    }
}