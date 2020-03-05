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

import java.util.ArrayList;

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
//        holder.pkname.setText(arrypro.get(position).getName());

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
