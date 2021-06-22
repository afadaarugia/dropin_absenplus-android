package com.britech.absendulu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.britech.absendulu.R;
import com.britech.absendulu.adapter.RekapAbsensiAdapter;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.getdataabsensi.ResponseGetDataAbsensi;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RekapKehadiranFragment extends Fragment {

    @BindView(R.id.rvRekapKehadiran)
    RecyclerView rvRekapKehadiran;

    RekapAbsensiAdapter adapter;
    ApiEndpointService apiInterface;
    PrefManager prefManager;
    FragmentActivity listener;


    public RekapKehadiranFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_rekap_kehadiran, container, false);

        ButterKnife.bind(this,view);
        apiInterface = ApiClient.getApiClient().create(ApiEndpointService.class);

        adapter=new RekapAbsensiAdapter(getContext(),apiInterface);
        rvRekapKehadiran.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRekapKehadiran.setAdapter(adapter);
//        rvRekapKehadiran.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));

        RekapKehadiran();

        return view;
    }

    public  void RekapKehadiran(){
        PrefManager prf = new PrefManager(listener);
        Call<ResponseGetDataAbsensi> api=apiInterface.getAbsensi("Bearer" +prf.getString(Const.TOKEN));
        api.enqueue(new Callback<ResponseGetDataAbsensi>() {
            @Override
            public void onResponse(Call<ResponseGetDataAbsensi> call, Response<ResponseGetDataAbsensi> response) {
                if(response.isSuccessful()){
                    adapter.setItems(response.body().getData().getAbsensi());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<ResponseGetDataAbsensi> call, Throwable t) {

            }
        });


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity){
            this.listener = (FragmentActivity) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
