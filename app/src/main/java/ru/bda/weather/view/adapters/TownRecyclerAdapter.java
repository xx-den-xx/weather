package ru.bda.weather.view.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.bda.weather.R;
import ru.bda.weather.other.Const;
import ru.bda.weather.presenter.TownActivityPresenter;
import ru.bda.weather.presenter.mo.WeatherTown;

public class TownRecyclerAdapter extends RecyclerView.Adapter<TownRecyclerAdapter.ViewHolder> {

    private List<WeatherTown> weatherList;

    private TownActivityPresenter presenter;

    private Context context;

    public TownRecyclerAdapter(List<WeatherTown> weatherList, TownActivityPresenter presenter, Context context) {
        this.weatherList = weatherList;
        this.presenter = presenter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_town_recycler_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WeatherTown weather = weatherList.get(position);
        double temp = weather.getMainTemp();
        double tempMin = weather.getMainTempMin();
        double tempMax = weather.getMainTempMax();

        String tempStr = temp > 0 ? "+" + temp : "" + temp;
        String tempMinStr = tempMin > 0 ? "+" + tempMin : "" + tempMin;
        String tempMaxStr = tempMax > 0 ? "+" + tempMax : "" + tempMax;
        Picasso.with(context)
                .load(weather.getWeatherIcon())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_gallery)
                .into(holder.imageWeather);
        holder.textTown.setText(weather.getName() + "," + weather.getSysCountry() +
                " " + weather.getWeatherDescription());
        holder.textWeather.setText(context.getString(R.string.town_weather_now,
                tempStr,
                Const.CELSIUS,
                tempMinStr,
                tempMaxStr,
                weather.getWindSpeed() + ""));
        holder.textCoord.setText(context.getString(R.string.town_goepoint,
                weather.getCoordLat() + "",
                weather.getCoordLon() + ""));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public void setWeatherList(List<WeatherTown> items) {
        this.weatherList = items;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView imageWeather;
        TextView textTown;
        TextView textWeather;
        TextView textCoord;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
            imageWeather = (ImageView) itemView.findViewById(R.id.image_weather);
            textTown = (TextView) itemView.findViewById(R.id.text_town);
            textWeather = (TextView) itemView.findViewById(R.id.text_weather);
            textCoord = (TextView) itemView.findViewById(R.id.text_coord);
        }
    }
}
