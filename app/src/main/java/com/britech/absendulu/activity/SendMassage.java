package com.britech.absendulu.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.bixbox.ResponseSendMessages;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMassage extends AppCompatActivity {

    private TextView mNomor,mPesan;
    private Button btnSend;
    private String nomor, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_massage);
        mNomor = (TextView) findViewById(R.id.nomor);
        mPesan = (TextView) findViewById(R.id.pesan);
        final PrefManager prefManager = new PrefManager(this);

        btnSend = findViewById(R.id.kirim);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nomor = String.valueOf(mNomor.getText());
                pesan = String.valueOf(mPesan.getText());
                Toast.makeText(SendMassage.this, "nomor :" + nomor +"pesan: "+pesan, Toast.LENGTH_SHORT).show();
//                ApiEndpointService api = ApiClient.getApiBixBox().create(ApiEndpointService.class);
//                Call<ResponseSendMessages> postAbsen = api.postMassage("GWRTCI8kI3CB7BzQ7aIC7wgWA7EH4WOe",nomor,pesan);
//                    postAbsen.enqueue(new Callback<ResponseSendMessages>() {
//                        @Override
//                        public void onResponse(Call<ResponseSendMessages> call, Response<ResponseSendMessages> response) {
//                            if (response.isSuccessful()){
//                                Toast.makeText(SendMassage.this, "Berhasil", Toast.LENGTH_SHORT).show();
////                                new SweetAlertDialog(getApplicationContext())
////                                        .setTitleText("Berhasil Absen")
////                                        .show();
//                            } else {
//                                new SweetAlertDialog(getApplicationContext())
//                                        .setTitleText("Data gagal")
//                                        .show();
//                            }
//                        }
//
//                        @Override
//                        public void onFailure(Call<ResponseSendMessages> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
//                        }
//                    });
//                ApiEndpointService api = ApiClient.getApiBixBox().create(ApiEndpointService.class);
//                String pesan;
//                pesan = "Absen Sekarang";
//                Call<ResponseSendMessages> postAbsen = api.postMassage("GWRTCI8kI3CB7BzQ7aIC7wgWA7EH4WOe","081344531097",pesan);
//                Toast.makeText(getApplicationContext(), "nomor :" + prefManager.getString(Const.NOHP) +"pesan: "+pesan, Toast.LENGTH_LONG).show();
//                postAbsen.enqueue(new Callback<ResponseSendMessages>() {
//                    @Override
//                    public void onResponse(Call<ResponseSendMessages> call, Response<ResponseSendMessages> response) {
//                        if (response.isSuccessful()){
//                            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_SHORT).show();
//                        } else {
//                            Toast.makeText(getApplicationContext(), "Gagal Kirim", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseSendMessages> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
//                    }
//                });
                }
        });
    }
}

//package id.britech.poscustomer.ui.activity.profile;
//
//import android.Manifest;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.DatePickerDialog;
//import android.content.ContentUris;
//import android.content.Context;
//import android.content.Intent;
//import android.database.Cursor;
//import android.net.Uri;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.Environment;
//import android.provider.DocumentsContract;
//import android.provider.MediaStore;
//import android.view.MenuItem;
//import android.view.View;
//import android.widget.DatePicker;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.databinding.DataBindingUtil;
//import androidx.lifecycle.ViewModelProvider;
//
//import com.ethanhua.skeleton.Skeleton;
//import com.ethanhua.skeleton.SkeletonScreen;
//import com.gmail.samehadar.iosdialog.IOSDialog;
//import com.karumi.dexter.Dexter;
//import com.karumi.dexter.MultiplePermissionsReport;
//import com.karumi.dexter.PermissionToken;
//import com.karumi.dexter.listener.PermissionRequest;
//import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
//import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
//import com.squareup.picasso.MemoryPolicy;
//import com.squareup.picasso.NetworkPolicy;
//import com.squareup.picasso.Picasso;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.List;
//
//import gun0912.tedbottompicker.TedBottomPicker;
//import id.britech.poscustomer.R;
//import id.britech.poscustomer.config.Const;
//import id.britech.poscustomer.databinding.ActivityProfileBinding;
//import id.britech.poscustomer.manager.PrefManager;
//import id.britech.poscustomer.ui.activity.MapAddressActivity;
//import id.britech.poscustomer.ui.activity.login.LoginActivity;
//import id.britech.poscustomer.viewmodel.ViewModelFactory;
//import id.zelory.compressor.Compressor;
//import okhttp3.MediaType;
//import okhttp3.MultipartBody;
//import okhttp3.RequestBody;
//
//public class ProfileActivity extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener {
//
//    ProfileViewModel profileViewModel;
//    ActivityProfileBinding binding;
//
//    SkeletonScreen skeletonScreen;
//    private Uri uriFoto=null;
//    private Context context;
//    private DatePickerDialog dpd;
//    IOSDialog progressDialog;
//    static final int REQUEST_CODE=400;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        context=this;
//
//        profileViewModel=obtainViewModel(this);
//        profileViewModel.setToken(new PrefManager(context).getString("token"));
//        binding = DataBindingUtil.setContentView(ProfileActivity.this, R.layout.activity_profile);
//        binding.setLifecycleOwner(this);
//        binding.setClickHandlers(new ProfileActivity.ProfileActivityClickHandlers(this));
//        binding.setProfileViewModel(profileViewModel);
//
//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        progressDialog = new IOSDialog.Builder(context)
//                .setTitle(R.string.loading)
//                .setTitleColorRes(R.color.standard_white)
//                .build();
//
//        skeletonScreen = Skeleton.bind(binding.include.llcontainer)
//                .load(R.layout.skeleton_profile)
//                .shimmer(true)
//                .duration(1000)
//                .color(R.color.shimmer_color)
//                .angle(20)
//                .show();
//
//        getDataPelanggan();
//
//        Dexter.withActivity(this)
//                .withPermissions(
//                        Manifest.permission.CAMERA,
//                        Manifest.permission.ACCESS_COARSE_LOCATION,
//                        Manifest.permission.ACCESS_FINE_LOCATION,
//                        Manifest.permission.READ_EXTERNAL_STORAGE,
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                .withListener(new MultiplePermissionsListener() {
//                    @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
//                        if(!report.areAllPermissionsGranted()){
//                            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
//                                    .setTitleText("Izin Bermasalah")
//                                    .setContentText("Izin aplikasi tidak cukup")
//                                    .setConfirmText("Tutup")
//                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                        @Override
//                                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                                            finish();
//                                        }
//                                    })
//                                    .show();
//                        }
//                    }
//                    @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
//                        token.continuePermissionRequest();
//                    }
//                }).check();
//
//        profileViewModel.getProfileUser().observe(this, profileUser -> {
//            if(profileUser!=null){
//                if (!profileUser.isNamaValid()) {
//                    binding.include.nama.setError("Nama Masih Kosong");
//                    binding.include.nama.requestFocus();
//                }else if (!profileUser.isEmailValid()) {
//                    binding.include.email.setError("Masukkan Email yang valid");
//                    binding.include.email.requestFocus();
//                }else if (!profileUser.isJenisKelaminValid()) {
//                    binding.include.radioPria.setError("Masukkan Jenis Kelamin yang valid");
//                    binding.include.radioPria.requestFocus();
//                }else if (!profileUser.isTanggalLahirValid()) {
//                    binding.include.tanggalLahir.setError("Masukkan Tanggal Lahir yang valid");
//                    binding.include.tanggalLahir.requestFocus();
//                }else if (!profileUser.isPekerjaanValid()) {
//                    binding.include.pekerjaan.setError("Masukkan Pekerjaan yang valid");
//                    binding.include.pekerjaan.requestFocus();
//                }else if (!profileUser.isAlamatValid()) {
//                    binding.include.alamat.setError("Masukkan Alamat yang valid");
//                    binding.include.alamat.requestFocus();
//                }else{
//
//                    profileViewModel.updateUserLiveData().observe(this,responseUserApiResponse -> {
//                        if(responseUserApiResponse!=null){
//                            switch (responseUserApiResponse.status) {
//                                case LOADING:
//                                    progressDialog.show();
//                                    break;
//                                case SUCCESS:
//                                    progressDialog.hide();
//                                    if (responseUserApiResponse.body != null) {
//                                        new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
//                                                .setTitleText("Sukses")
//                                                .setContentText("Update Profil Berhasil")
//                                                .setConfirmText("Tutup")
//                                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                                    @Override
//                                                    public void onClick(SweetAlertDialog sDialog) {
//                                                        sDialog.dismissWithAnimation();
//                                                    }
//                                                })
//                                                .show();
//                                    }
//                                    break;
//                                case ERROR:
//                                    progressDialog.hide();
//                                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
//                                            .setTitleText("Pesan Aplikasi")
//                                            .setContentText("Masalah pada jaringan/koneksi")
//                                            .setConfirmText("Tutup")
//                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                                @Override
//                                                public void onClick(SweetAlertDialog sDialog) {
//                                                    sDialog.dismissWithAnimation();
//                                                }
//                                            })
//                                            .show();
//                                    break;
//
//                                case EXPIRED_TOKEN:
//                                    progressDialog.hide();
//                                    new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
//                                            .setTitleText("Pesan Aplikasi")
//                                            .setContentText("Login kadaluarsa Silahkan Login Ulang Kembali")
//                                            .setConfirmText("Tutup")
//                                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                                @Override
//                                                public void onClick(SweetAlertDialog sDialog) {
//                                                    PrefManager prf= new PrefManager(context);
//                                                    prf.remove("token");
//                                                    Intent intent= new Intent(context, LoginActivity.class);
//                                                    context.startActivity(intent);
//                                                    ((Activity) context).finish();
//                                                    sDialog.dismissWithAnimation();
//                                                }
//                                            })
//                                            .show();
//                                    break;
//                            }
//                        }
//                    });
//                }
//            }
//        });
//
//        binding.include.ubahTanggal.setOnClickListener(v->{
//            Calendar tanggal = Calendar.getInstance();
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                tanggal.setTime(sdf.parse(binding.include.tanggalLahir.getText().toString()));
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
//
//            dpd=new DatePickerDialog(
//                    context, this, tanggal.get(Calendar.YEAR),
//                    tanggal.get(Calendar.MONTH),
//                    tanggal.get(Calendar.DAY_OF_MONTH));
//
//            dpd.setTitle("Pilih Tanggal Lahir");
//
//            dpd.show();
//        });
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        switch (item.getItemId())
//        {
//            case android.R.id.home:
//                onBackPressed();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    public void getDataPelanggan(){
//        profileViewModel.getDataPelanggan().observe(this, userApiResponse -> {
//            if (userApiResponse != null) {
//                switch (userApiResponse.status) {
//                    case LOADING:
//                        binding.include.llcontainer.setVisibility(View.GONE);
//                        skeletonScreen.show();
//                        break;
//                    case SUCCESS:
//                        binding.include.llcontainer.setVisibility(View.VISIBLE);
//                        skeletonScreen.hide();
//                        if (userApiResponse.body != null) {
//                            profileViewModel.setAlamatLiveData(userApiResponse.body.getUser().getPelanggan().getAlamat(),userApiResponse.body.getUser().getPelanggan().getLongitude(),
//                                    userApiResponse.body.getUser().getPelanggan().getLatitude());
//                            profileViewModel.setEmailLiveData(userApiResponse.body.getUser().getEmail());
//                            profileViewModel.setNamaLiveData(userApiResponse.body.getUser().getName());
//                            profileViewModel.setKontakLiveData(userApiResponse.body.getUser().getKontak());
//                            profileViewModel.setPekerjaanLiveData(userApiResponse.body.getUser().getPelanggan().getPekerjaan());
//
//                            if(userApiResponse.body.getUser().getPelanggan().getJenisKelamin().equals("pria")){
//                                profileViewModel.setJenisKelaminLiveData(R.id.radioPria);
//                            }else{
//                                profileViewModel.setJenisKelaminLiveData(R.id.radioWanita);
//                            }
//
//                            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//                            profileViewModel.setTanggalLahirLiveData(dateFormat.format(userApiResponse.body.getUser().getPelanggan().getTanggalLahir()));
//
//                            Picasso.get().load(Const.BASE_URL+userApiResponse.body.getUser().getFoto())
//                                    .placeholder(R.drawable.profile)
//                                    .error(R.drawable.profile)
//                                    .memoryPolicy(MemoryPolicy.NO_CACHE)
//                                    .networkPolicy(NetworkPolicy.NO_CACHE)
//                                    .into(binding.include.imageProfil);
//                        }
//                        break;
//                    case ERROR:
//                        binding.include.llcontainer.setVisibility(View.GONE);
//                        skeletonScreen.show();
//                        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
//                                .setTitleText("Pesan Aplikasi")
//                                .setContentText("Masalah pada jaringan/koneksi")
//                                .setConfirmText("Tutup")
//                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                    @Override
//                                    public void onClick(SweetAlertDialog sDialog) {
//                                        sDialog.dismissWithAnimation();
//                                    }
//                                })
//                                .show();
//                        break;
//
//                    case EXPIRED_TOKEN:
//                        binding.include.llcontainer.setVisibility(View.GONE);
//                        skeletonScreen.show();
//                        new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
//                                .setTitleText("Pesan Aplikasi")
//                                .setContentText("Login kadaluarsa Silahkan Login Ulang Kembali")
//                                .setConfirmText("Tutup")
//                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                    @Override
//                                    public void onClick(SweetAlertDialog sDialog) {
//                                        PrefManager prf= new PrefManager(context);
//                                        prf.remove("token");
//                                        Intent intent= new Intent(context, LoginActivity.class);
//                                        context.startActivity(intent);
//                                        ((Activity) context).finish();
//                                        sDialog.dismissWithAnimation();
//                                    }
//                                })
//                                .show();
//                        break;
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == REQUEST_CODE) {
//            if(resultCode == MapAddressActivity.RESULT_CODE){
//                String alamat = data.getStringExtra(MapAddressActivity.EXTRA_ALAMAT);
//                Double longitude = data.getDoubleExtra(MapAddressActivity.EXTRA_LONGITUDE,0);
//                Double latitude = data.getDoubleExtra(MapAddressActivity.EXTRA_LATITUDE,0);
//                profileViewModel.setAlamatLiveData(alamat,longitude,latitude);
//            }
//            if (resultCode == Activity.RESULT_CANCELED) {
//                Toast.makeText(this, "Batal Memilih Alamat ", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    @Override
//    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//        String sDay="00"+dayOfMonth;
//        String sMonth="00"+(month+1);
//        String tanggal= sDay.substring(sDay.length()-2)+"/"+sMonth.substring(sMonth.length()-2)+"/"+year;
//        binding.include.tanggalLahir.setText(tanggal);
//    }
//
//    public String getRealPathFromUri(final Uri uri) {
//        // DocumentProvider
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(context, uri)) {
//            // ExternalStorageProvider
//            if (isExternalStorageDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                if ("primary".equalsIgnoreCase(type)) {
//                    return Environment.getExternalStorageDirectory() + "/" + split[1];
//                }
//            }
//            // DownloadsProvider
//            else if (isDownloadsDocument(uri)) {
//
//                final String id = DocumentsContract.getDocumentId(uri);
//                final Uri contentUri = ContentUris.withAppendedId(
//                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
//
//                return getDataColumn(context, contentUri, null, null);
//            }
//            // MediaProvider
//            else if (isMediaDocument(uri)) {
//                final String docId = DocumentsContract.getDocumentId(uri);
//                final String[] split = docId.split(":");
//                final String type = split[0];
//
//                Uri contentUri = null;
//                if ("image".equals(type)) {
//                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
//                } else if ("video".equals(type)) {
//                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//                } else if ("audio".equals(type)) {
//                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//                }
//
//                final String selection = "_id=?";
//                final String[] selectionArgs = new String[]{
//                        split[1]
//                };
//
//                return getDataColumn(context, contentUri, selection, selectionArgs);
//            }
//        }
//        // MediaStore (and general)
//        else if ("content".equalsIgnoreCase(uri.getScheme())) {
//
//            // Return the remote address
//            if (isGooglePhotosUri(uri))
//                return uri.getLastPathSegment();
//
//            return getDataColumn(context, uri, null, null);
//        }
//        // File
//        else if ("file".equalsIgnoreCase(uri.getScheme())) {
//            return uri.getPath();
//        }
//
//        return null;
//    }
//
//    private String getDataColumn(Context context, Uri uri, String selection,
//                                 String[] selectionArgs) {
//
//        Cursor cursor = null;
//        final String column = "_data";
//        final String[] projection = {
//                column
//        };
//
//        try {
//            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
//                    null);
//            if (cursor != null && cursor.moveToFirst()) {
//                final int index = cursor.getColumnIndexOrThrow(column);
//                return cursor.getString(index);
//            }
//        } finally {
//            if (cursor != null)
//                cursor.close();
//        }
//        return null;
//    }
//
//    private boolean isExternalStorageDocument(Uri uri) {
//        return "com.android.externalstorage.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isDownloadsDocument(Uri uri) {
//        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isMediaDocument(Uri uri) {
//        return "com.android.providers.media.documents".equals(uri.getAuthority());
//    }
//
//    private boolean isGooglePhotosUri(Uri uri) {
//        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
//    }
//
//    public class ProfileActivityClickHandlers{
//        Context context;
//        public ProfileActivityClickHandlers(Context context) {
//            this.context = context;
//        }
//
//        public void ubahAlamatClickHandlers(View v){
//            Intent intent=new Intent(ProfileActivity.this, MapAddressActivity.class);
//            startActivityForResult(intent,REQUEST_CODE);
//        }
//
//        public void ubahTanggalClickHandlers(View v){
//            Calendar tanggal = Calendar.getInstance();
//            try {
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                tanggal.setTime(sdf.parse(binding.include.tanggalLahir.getText().toString()));
//            } catch (ParseException ex) {
//                ex.printStackTrace();
//            }
//
//            dpd=new DatePickerDialog(
//                    context, AlertDialog.THEME_HOLO_LIGHT,ProfileActivity.this, tanggal.get(Calendar.YEAR),
//                    tanggal.get(Calendar.MONTH),
//                    tanggal.get(Calendar.DAY_OF_MONTH));
//
//            dpd.setTitle("Pilih Tanggal Lahir");
//
//            dpd.show();
//        }
//
//        public void onTanggalFocusChange(View v,Boolean hasFocus){
//
//            if(hasFocus){
//                Calendar now = Calendar.getInstance();
//                dpd=new DatePickerDialog(
//                        context, AlertDialog.THEME_HOLO_LIGHT,
//                        ProfileActivity.this,
//                        now.get(Calendar.YEAR),
//                        now.get(Calendar.MONTH),
//                        now.get(Calendar.DAY_OF_MONTH));
//
//                dpd.setTitle("Pilih Tanggal Lahir");
//
//                dpd.show();
//            }else{
//                dpd.hide();
//            }
//        }
//
//        public void clickLogout(View v){
//            new SweetAlertDialog(context, SweetAlertDialog.NORMAL_TYPE)
//                    .setTitleText("Logout Akun")
//                    .setContentText("Apakah anda ingin logout dari aplikasi?")
//                    .setConfirmText("Logout")
//                    .setCancelText("Batal")
//                    .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener(){
//                        @Override
//                        public void onClick(SweetAlertDialog sweetAlertDialog) {
//                            sweetAlertDialog.dismissWithAnimation();
//                        }
//                    })
//                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                        @Override
//                        public void onClick(SweetAlertDialog sDialog) {
//                            sDialog.dismissWithAnimation();
//                            PrefManager prf= new PrefManager(context);
//                            prf.remove("token");
//                            prf.remove("myPoint");
//
//                            Intent i = new Intent(ProfileActivity.this, LoginActivity.class);
//                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                            startActivity(i);
//                        }
//                    })
//                    .show();
//        }
//
//        public void imageClick(View v){
//            TedBottomPicker tedBottomPicker = new TedBottomPicker.Builder(ProfileActivity.this)
//                    .setOnImageSelectedListener(new TedBottomPicker.OnImageSelectedListener() {
//                        @Override
//                        public void onImageSelected(Uri uri) {
//                            // here is selected uri
//                            uriFoto=uri;
//                            Picasso.get().load(uri).into(binding.include.imageProfil);
//
//                            if(uriFoto!=null){
//                                File tempBitmap= null;
//                                try {
//                                    tempBitmap = new Compressor(ProfileActivity.this)
//                                            .setQuality(60).compressToFile(new File(uriFoto.getPath()));
//                                    uriFoto=Uri.fromFile(tempBitmap);
//
//                                    String filePath = getRealPathFromUri(uriFoto);
//                                    if (filePath != null && !filePath.isEmpty()) {
//                                        File file = new File(filePath);
//                                        if (file.exists()) {
//                                            // creates RequestBody instance from file
//                                            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//                                            // MultipartBody.Part is used to send also the actual filename
//                                            profileViewModel.multipartImageProfile = MultipartBody.Part.createFormData("foto", file.getName(), requestFile);
//                                        }
//                                    }
//                                } catch (IOException e) {
//                                    e.printStackTrace();
//                                }
//                            }
//                        }
//                    })
//                    .create();
//
//            tedBottomPicker.show(getSupportFragmentManager());
//        }
//    }
//
//    @NonNull
//    private static ProfileViewModel obtainViewModel(AppCompatActivity activity) {
//        // Use a Factory to inject dependencies into the ViewModel
//        ViewModelFactory factory = ViewModelFactory.getInstance(activity.getApplication());
//        return new ViewModelProvider(activity, factory).get(ProfileViewModel.class);
//    }
//}
