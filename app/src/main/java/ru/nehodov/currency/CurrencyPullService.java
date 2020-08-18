package ru.nehodov.currency;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.Executors;

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
        Log.d(TAG, "execute a task in a service");
    }
}
