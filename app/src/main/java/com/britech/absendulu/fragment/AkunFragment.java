package com.britech.absendulu.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.britech.absendulu.R;
import com.britech.absendulu.activity.LoginActivity;
import com.britech.absendulu.activity.SettingReminder;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


public class AkunFragment extends Fragment {
    PrefManager prefManager;
    FragmentActivity listener;
    LinearLayout buttonLogout,pengaturan, bantuan;
    ApiEndpointService apiEndpointService;
    Context context;
    TextView tvNama,tvNik,tvKontak;
    ImageView ivProfil;
    public AkunFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View view = inflater.inflate(R.layout.fragment_akun, container, false);
        prefManager = new PrefManager(listener);
        buttonLogout = view.findViewById(R.id.exit);
        tvNama = view.findViewById(R.id.tvNama);
        tvNama.setText(prefManager.getString(Const.NAMA_KARYAWAN));
        tvNik = view.findViewById(R.id.tvNik);
        tvNik.setText(prefManager.getString(Const.NIK));
        tvKontak = view.findViewById(R.id.tvKontak);
        tvKontak.setText(prefManager.getString(Const.EMAIL));
        ivProfil = view.findViewById(R.id.tvFotoProfil);
        Glide.with(view).load(ApiClient.BASE_PATH +prefManager.getString(Const.PATHRECOGNITION)).into(ivProfil);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });

        pengaturan = view.findViewById(R.id.pengaturan);
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(view.getContext(), SettingReminder.class ));
            }
        });

        bantuan = view.findViewById(R.id.bantuan);
        bantuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;
                fragment = new BantuanFragment();
                listener.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container,fragment,Const.TAG_FRAGMENT).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(Const.TAG_FRAGMENT).commit();
            }
        });
        return view;
    }

    private void logout(){
        PrefManager prefManager = new PrefManager(listener);

        prefManager.remove("token");
        prefManager.remove("nama");
        prefManager.remove("foto");
        prefManager.remove("no_hp");
        prefManager.remove("idAbsen");
        prefManager.remove("user_id");
        prefManager.remove("password");
        prefManager.remove("password");
        prefManager.remove("foto");
        prefManager.remove("posisi");
        prefManager.remove("nik");
        prefManager.remove("nama_karyawan");
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
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
