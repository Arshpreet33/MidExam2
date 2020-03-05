package com.example.midexam;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {


    private ArrayList<Weather_> arrypro;
    private Context context;
    private View.OnClickListener itemlistener;

    public RecycleAdapter(ArrayList<Weather_> arrypro, Context context) {
        this.arrypro = arrypro;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String uri = "https://www.metaweather.com/static/img/weather/png/64/" + arrypro.get(position).getWeather_state_abbr() + ".png";

        Picasso.get().load(uri).into(holder.pkimg);

        String dateStr = arrypro.get(position).getApplicable_date();
        String day = getDay(arrypro.get(position).getApplicable_date());
        holder.pkname.setText(day);
//        holder.pkname.setText(arrypro.get(position).getName());

    }

    public String getDay(String d) {
        try {


            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = format.parse(d);
            SimpleDateFormat format2 = new SimpleDateFormat("EEEE");
            return format2.format(date);
//        String dayOfMonth = (String) DateFormat.format("EEEE", date);
//        return day
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public int getItemCount() {
        return arrypro.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView pkimg;
        TextView pkname;

        public ViewHolder(View itemview) {
            super(itemview);

            pkimg = itemview.findViewById(R.id.img_pk);
            pkname = itemview.findViewById(R.id.txt_pknm);
            itemview.setTag(this);
        }
    }
}
