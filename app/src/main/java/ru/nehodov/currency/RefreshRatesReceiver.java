package ru.nehodov.currency;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import ru.nehodov.currency.repository.CurrencyRepository;

public class RefreshRatesReceiver extends BroadcastReceiver {

    private static final String TAG = RefreshRatesReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
            CurrencyRepository repository = new CurrencyRepository(context);
            repository.refreshRates();
            Toast.makeText(
                    context,
                    "Rates are refreshed",
                    Toast.LENGTH_LONG
            ).show();
            Log.d(TAG, "Intent is ACTION_BOOT_COMPLETED, rates are refreshed");
    }
}
