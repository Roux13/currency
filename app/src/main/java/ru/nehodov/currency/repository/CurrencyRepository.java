package ru.nehodov.currency.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import ru.nehodov.currency.dao.CurrencyDao;
import ru.nehodov.currency.database.CurrencyDb;
import ru.nehodov.currency.entities.ApiResponse;
import ru.nehodov.currency.entities.Rate;
import ru.nehodov.currency.network.ExchangeRatesApi;
import ru.nehodov.currency.network.NetworkService;

public class CurrencyRepository {

    private final ExchangeRatesApi exchangeRatesApi;

    private final CurrencyDao currencyDao;

    public CurrencyRepository(Application application) {
        CurrencyDb db = CurrencyDb.getInstance(application);
        this.currencyDao = db.getCurrencyDao();
        this.exchangeRatesApi = new NetworkService().getApi();
    }

    public LiveData<List<Rate>> getRates() {
        return currencyDao.getRates();
    }

    public void refreshRates() {
        Call<ApiResponse> call = exchangeRatesApi.getRates();
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call,
                                   retrofit2.Response<ApiResponse> response) {
                if (response.isSuccessful()) {
                    CurrencyDb.DB_EXECUTOR_SERVICES.execute(() -> {
                        currencyDao.clearDb();
                        response.body().getRates().getAllRates().stream()
                                .forEach(currencyDao::insertRate);
                    });
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {

            }
        });
    }
}
