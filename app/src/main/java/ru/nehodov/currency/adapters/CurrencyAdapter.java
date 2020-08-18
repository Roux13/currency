package ru.nehodov.currency.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.nehodov.currency.R;
import ru.nehodov.currency.entities.Rate;

public class CurrencyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Rate> rates = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerView.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.currencies_item, parent, false)) { };
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        final Rate rate = rates.get(position);
        TextView currencyNameTv = holder.itemView.findViewById(R.id.currency_name);
        TextView rateTv = holder.itemView.findViewById(R.id.rate);
        currencyNameTv.setText(rate.getCurrency());
        rateTv.setText(String.valueOf(rate.getRate()));
    }

    @Override
    public int getItemCount() {
        return rates.size();
    }

    public void setRates(List<Rate> rates) {
        if (rates != null) {
            this.rates.clear();
            this.rates.addAll(rates);
            notifyDataSetChanged();
        }
    }
}
