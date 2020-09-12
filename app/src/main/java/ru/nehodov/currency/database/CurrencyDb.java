package ru.nehodov.currency.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ru.nehodov.currency.dao.CurrencyDao;
import ru.nehodov.currency.entities.Rate;

@Database(entities = Rate.class, version = 1, exportSchema = false)
public abstract class CurrencyDb extends RoomDatabase {

    private static CurrencyDb instance;
    private static final String DB_NAME = "rates_db";
    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService DB_EXECUTOR_SERVICES
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public abstract CurrencyDao getCurrencyDao();

    public static CurrencyDb getInstance(final Context applicationContext) {
        if (instance == null) {
            synchronized (CurrencyDb.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            applicationContext,
                            CurrencyDb.class,
                            DB_NAME)
                            .build();
                }
            }
        }
        return instance;
    }
}
