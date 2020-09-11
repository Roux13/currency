package ru.nehodov.currency;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import ru.nehodov.currency.repository.CurrencyRepository;

public class CurrencyPullJobService extends JobIntentService {

    private static final String TAG = CurrencyPullJobService.class.getSimpleName();

    private static final int JOB_ID = 999;

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        CurrencyRepository repository = new CurrencyRepository(getApplication());
        repository.refreshRates();
        Log.d(TAG, "Rates were refreshed");
    }

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, CurrencyPullJobService.class, JOB_ID, work);
    }
}
