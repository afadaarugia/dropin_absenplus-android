package com.britech.absendulu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.ResponseUser;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;
import com.google.android.material.textfield.TextInputLayout;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    //Variables
    Button buttonLogin;
    TextInputLayout eNik;
    TextInputLayout ePassword;
    ApiEndpointService apiEndpointService;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Hooks
//        apiEndpointService = ApiClient.getApiClient().create(ApiEndpointService.class);
        context = this;
        initialLayout();
        eNik = (TextInputLayout) findViewById(R.id.nik);
        ePassword = (TextInputLayout) findViewById(R.id.password);
        PrefManager prefManager = new PrefManager(getApplicationContext());
        if (!prefManager.getString("token").equals("") && !prefManager.getString("password").equals("")) {
            startMainActivity();
            getAccessToken(prefManager.getString("token"),prefManager.getString("password"));

        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(LoginActivity.this, Dashboard.class);
        startActivity(intent);
    }

    private void initialLayout() {
        buttonLogin = findViewById(R.id.button_login);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = eNik.getEditText().getText().toString();
                String password = ePassword.getEditText().getText().toString();

                boolean cancel = false;
                View focusView = null;

                if (TextUtils.isEmpty(email)){
                    new SweetAlertDialog(LoginActivity.this,SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Data tidak boleh kosong!")
                            .show();
                    focusView = eNik;
                    cancel = true;
                }
                if (cancel) {
                    focusView.requestFocus();
                }else{
                    getAccessToken(email,password);
                }

            }
        });

    }

    public void getAccessToken(String nik, String password) {
        ApiEndpointService apiEndpointService = ApiClient.getApiClient().create(ApiEndpointService.class);
        Call<ResponseUser> api = apiEndpointService.getAccessToken(nik, password);
        api.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                if (response.isSuccessful()) {
                    PrefManager prefManager = new PrefManager(getApplicationContext());
                    String email = eNik.getEditText().getText().toString();
                    String password = ePassword.getEditText().getText().toString();

                    if (response.body() != null) {
                        prefManager.setString(Const.TOKEN, response.body().getData().getToken());
                        prefManager.setString(Const.EMAIL, response.body().getData().getUser().getEmail());
                        prefManager.setString(Const.NAMA, response.body().getData().getUser().getName());
                        prefManager.setString(Const.NAMA_KARYAWAN, response.body().getData().getDetail().getNamaLengkap());
                        prefManager.setString(Const.NIK, String.valueOf(response.body().getData().getDetail().getNikBistel()));
                        prefManager.setString(Const.LATITUDE, String.valueOf(response.body().getData().getDetail().getSektor().getLatitude()));
                        prefManager.setString(Const.LONGTITUDE, String.valueOf(response.body().getData().getDetail().getSektor().getLongtitude()));
                        prefManager.setString(Const.POSISI, String.valueOf(response.body().getData().getDetail().getNamePosisions().getNama()));
                        prefManager.setString(Const.NOHP, String.valueOf(response.body().getData().getDetail().getNoTelp()));
                        prefManager.setString(Const.PATHRECOGNITION, String.valueOf(response.body().getData().getPath().getFoto()));
                        prefManager.setString(Const.ID, String.valueOf(response.body().getData().getUser().getId()));
                        prefManager.setString(Const.PASSWORD, password);
                    }
                    startActivity(new Intent(LoginActivity.this, Dashboard.class));
                    finish();
                }else{
                    new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Username/password salah !")
                            .show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                new SweetAlertDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Gagal Koneksi")
                        .show();
            }

        });
    }
}




