package com.britech.absendulu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.getdataabsensi.AbsensiItem;
import com.britech.absendulu.service.ApiEndpointService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class RekapAbsensiAdapter extends RecyclerView.Adapter<RekapAbsensiAdapter.ViewHolder>{

    PrefManager prefManager;
    Context context;
    List<AbsensiItem> items = new ArrayList<>();
    ApiEndpointService apiInterface;
    TextView located;

    public RekapAbsensiAdapter(Context context, ApiEndpointService apiInterface) {
        this.context = context;
        this.apiInterface = apiInterface;

    }

    public void setItems(List<AbsensiItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rekap_kehadiran,parent,false);
//        located = view.findViewById(R.id.located);
//        located.setText(prefManager.getString(Const.SEKTOR));
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SimpleDateFormat formatOutgoing = new SimpleDateFormat("HH:mm a");
        SimpleDateFormat formatOutgoing2 = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        formatOutgoing.setTimeZone(tz);
        formatOutgoing2.setTimeZone(tz);

        String timeIn = formatOutgoing.format(items.get(position).getTimeIn());
        String createds = formatOutgoing2.format(items.get(position).getCreatedAt());
        String located = "Samarinda";

        holder.created.setText(createds);
        holder.located.setText(located);
        holder.tvTimein.setText(timeIn);
        holder.tvTimein.setTextColor(context.getResources().getColor(R.color.green));

        if(items.get(position).getTimeOut()==null){
            holder.tvTimeOut.setText("Tidak Absen");
            holder.tvTimeOut.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }else {
            String timeOut = formatOutgoing.format(items.get(position).getTimeOut());
            holder.tvTimeOut.setText(timeOut);
            holder.tvTimeOut.setTextColor(context.getResources().getColor(R.color.green));
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvTimein, tvTimeOut,created, located;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTimein = itemView.findViewById(R.id.tvTimeIn);
            tvTimeOut = itemView.findViewById(R.id.tvTimeOut);
            created = itemView.findViewById(R.id.created);
            located = itemView.findViewById(R.id.located);

        }
    }
}
