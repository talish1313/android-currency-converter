package com.example.avil.currencyconverter.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.avil.currencyconverter.R;
import com.example.avil.currencyconverter.presenter.IMainPresenter;
import com.example.avil.currencyconverter.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainView {

    private IMainPresenter presenter;

    private EditText moneyIn;
    private TextView moneyOut;

    private Spinner spinner1;
    private Spinner spinner2;

    private Button update_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = (Spinner) findViewById(R.id.spinner_1);
        spinner2 = (Spinner) findViewById(R.id.spinner_2);

        moneyOut = (TextView) findViewById(R.id.money_out);
        moneyIn = (EditText) findViewById(R.id.money_in);

        update_btn = (Button) findViewById(R.id.update_btn);

        presenter = MainPresenter.getInstance();
        presenter.setView(this);
    }

    @Override
    public EditText getMoneyIn() {
        return moneyIn;
    }

    @Override
    public Spinner getSpinner1() {
        return spinner1;
    }

    @Override
    public Spinner getSpinner2() {
        return spinner2;
    }

    @Override
    public Button getUpdateBtn() {
        return update_btn;
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     * Отображение результата пересчета курса
     *
     * @param val
     */
    public void setValue(String val) {
        moneyOut.setText(val);
    }
}
