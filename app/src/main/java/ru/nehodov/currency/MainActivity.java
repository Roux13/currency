package ru.nehodov.currency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.concurrent.TimeUnit;

import ru.nehodov.currency.adapters.CurrencyAdapter;

public class MainActivity extends AppCompatActivity {

    private CurrencyViewModel viewModel;
    private CurrencyAdapter adapter;

    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new CurrencyAdapter();
        viewModel = new ViewModelProvider(this).get(CurrencyViewModel.class);
        viewModel.gerRates().observe(this, rates -> adapter.setRates(rates));
        RecyclerView recycler = findViewById(R.id.currencyList);
        Intent refreshIntent = new Intent(this, CurrencyPullJobService.class);
        CurrencyPullJobService.enqueueWork(this, refreshIntent);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        FloatingActionButton refreshActionBtn = findViewById(R.id.refreshActionButton);
        refreshActionBtn.setOnClickListener(
                v -> {
                    CurrencyPullJobService.enqueueWork(this, refreshIntent);
                    Toast.makeText(this, "Rates are refreshed", Toast.LENGTH_SHORT).show();
                });
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        long repeatInterval = TimeUnit.MINUTES.toMillis(1);
        long triggerTime = SystemClock.elapsedRealtime() + repeatInterval;
        pendingIntent = PendingIntent.getService(
                this, 0,
                new Intent(this, CurrencyPullService.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (alarmManager != null) {
            alarmManager.setRepeating(
                    AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerTime,
                    repeatInterval, pendingIntent);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }
}