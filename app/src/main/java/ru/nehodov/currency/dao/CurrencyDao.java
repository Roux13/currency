package ru.nehodov.currency.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import ru.nehodov.currency.entities.Rate;

@Dao
public interface CurrencyDao {

    @Query("SELECT * FROM Rate")
    LiveData<List<Rate>> getRates();

    @Insert
    void insertRate(Rate rate);

    @Query("DELETE FROM Rate")
    void clearDb();

}
