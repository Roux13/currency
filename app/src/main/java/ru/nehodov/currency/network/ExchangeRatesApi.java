package ru.nehodov.currency.network;

import retrofit2.Call;
import retrofit2.http.GET;
import ru.nehodov.currency.entities.ApiResponse;
import ru.nehodov.currency.entities.Rates;

public interface ExchangeRatesApi {

    @GET("latest?base=USD")
    Call<ApiResponse> getRates();

}
