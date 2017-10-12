package com.example.avil.currencyconverter.model;


import android.os.Handler;
import android.os.HandlerThread;

import com.example.avil.currencyconverter.R;
import com.example.avil.currencyconverter.model.curse_value.CurseParser;
import com.example.avil.currencyconverter.model.curse_value.Valute;
import com.example.avil.currencyconverter.repos.IRepoCallback;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class CurrencyRequest implements ICurrencyRequest {

    private static final String path = "http://www.cbr.ru/scripts/XML_daily.asp";

    private HandlerThread handlerThread;

    private static volatile boolean isActive = false;

    public CurrencyRequest(final IRepoCallback repo) {

        if (isActive) {
            repo.log(R.string.request_already_sent);
            return;
        }

        repo.log(R.string.update_rate);

        handlerThread = new HandlerThread("currency_request");
        handlerThread.start();


        final Handler handler = new Handler(handlerThread.getLooper());

        handler.post(new Runnable() {
            @Override
            public void run() {

                isActive = true;

                HttpURLConnection urlConnection = null;

                try {

                    URL url = new URL(path);

                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream inputStream = urlConnection.getInputStream();

                    repo.log(R.string.currency_loaded);

                    CurseParser curseParser = new CurseParser(inputStream);

                    // ====
                    // Сохраняем все валюты
                    List<Valute> list = curseParser.getValute();
                    repo.update(list);

                } catch (Exception e) {
                    e.printStackTrace();
                    repo.log(R.string.currency_cant_load);
                    repo.onError();
                } finally {
                    isActive = false;

                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            }
        });
    }

    public void onDestroy() {
        handlerThread.quit();
    }

}
