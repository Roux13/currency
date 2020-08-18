package ru.nehodov.currency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.nehodov.currency.adapters.CurrencyAdapter;

public class MainActivity extends AppCompatActivity {

    private CurrencyViewModel viewModel;

    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CurrencyAdapter();
        viewModel = new ViewModelProvider(this).get(CurrencyViewModel.class);
        viewModel.gerRates().observe(this, rates -> adapter.setRates(rates));
        RecyclerView recycler = findViewById(R.id.currencyList);
        Intent intent = new Intent(this, CurrencyPullService.class);
        startService(intent);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(adapter);
        FloatingActionButton refreshActionBtn = findViewById(R.id.refreshActionButton);
        refreshActionBtn.setOnClickListener(
                v -> {
                    startService(new Intent(this, CurrencyPullService.class));
                    Toast.makeText(this, "Rates refreshed", Toast.LENGTH_SHORT).show();
                });
    }
}