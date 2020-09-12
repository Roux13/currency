package ru.nehodov.currency;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ru.nehodov.currency.entities.Rate;
import ru.nehodov.currency.repository.CurrencyRepository;

public class CurrencyViewModel extends AndroidViewModel {

    private final CurrencyRepository repository;

    private final LiveData<List<Rate>> rates;

    public CurrencyViewModel(Application application) {
        super(application);
        repository = new CurrencyRepository(application.getApplicationContext());
        rates = repository.getRates();
    }

    public void refreshRates() {
        repository.refreshRates();
    }

    public LiveData<List<Rate>> gerRates() {
//        refreshRates();
        return this.rates;
    }
}
