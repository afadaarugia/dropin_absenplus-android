package com.britech.absendulu.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.getdataabsensi.ResponseGetDataAbsensi;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaFragment extends Fragment {

    PrefManager prefManager;
    FragmentActivity listener;
    TextView tvNamaKaryawan,tvNik,jmlHadir, jmlTidak,jmlCuti,tvTotal,tvTotalLalu;
    LinearLayout btnRekapKehadiran,btnRekapSlipGaji;
    public BerandaFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda,container,false);
        prefManager = new PrefManager(listener);
        tvNamaKaryawan =view.findViewById(R.id.nama_karyawan);
        tvNamaKaryawan.setText(prefManager.getString(Const.NAMA_KARYAWAN));
        tvNik =view.findViewById(R.id.nik);
        tvNik.setText(prefManager.getString(Const.NIK));
        btnRekapKehadiran = view.findViewById(R.id.rekap_kehadiran);
        jmlHadir = view.findViewById(R.id.jumlah_hadir);
        jmlTidak = view.findViewById(R.id.jumlah_tidak_hadir);
        tvTotalLalu = view.findViewById(R.id.tv_total_lalu);
        tvTotal = view.findViewById(R.id.tv_total);
//        jmlCuti = view.findViewById(R.id.jumlah_cuti);
        btnRekapKehadiran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment;
                fragment = new RekapKehadiranFragment();
                listener.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment,Const.TAG_FRAGMENT).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(Const.TAG_FRAGMENT).commit();
            }
        });
//        btnRekapSlipGaji = view.findViewById(R.id.rekap_slip_gaji);
//        btnRekapSlipGaji.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), RekapSlipGaji.class);
//                startActivity(intent);
//            }
//        });

        getAllAbsen();
        return view;
    }

    public void getAllAbsen() {
        PrefManager prf = new PrefManager(listener);
        ApiEndpointService apiInterface = ApiClient.getApiClient().create(ApiEndpointService.class);
        Call<ResponseGetDataAbsensi> api = apiInterface.getAbsensi("Bearer " + prf.getString(Const.TOKEN));
        api.enqueue(new Callback<ResponseGetDataAbsensi>() {
            @Override
            public void onResponse(Call<ResponseGetDataAbsensi> call, Response<ResponseGetDataAbsensi> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        jmlHadir.setText(String.valueOf(response.body().getData().getTotalTimeIn()));
                        jmlTidak.setText(String.valueOf(response.body().getData().getTotalTimeOut()));
                        tvTotalLalu.setText(String.valueOf(response.body().getData().getTtlAbsenLalu()));
                        tvTotal.setText(String.valueOf(response.body().getData().getTotalAbsen()));
//                        jmlCuti.setText(String.valueOf(response.body().getData().getTotalCuti()));

                    }
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
