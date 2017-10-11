package com.example.avil.currencyconverter.presenter;

import com.example.avil.currencyconverter.view.MainView;


public interface IMainPresenter {
    void setView(MainView mainView);

    void convert();

    void onDestroy();
}
