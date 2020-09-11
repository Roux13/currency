package ru.nehodov.currency;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import ru.nehodov.currency.repository.CurrencyRepository;

public class CurrencyPullService extends IntentService {

    private static final String TAG = CurrencyPullService.class.getName();

    public CurrencyPullService() {
        super("CurrencyPullService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        CurrencyRepository repository = new CurrencyRepository(getApplication());
        repository.refreshRates();
        Log.d(TAG, "Rates were refreshed");
    }
}
