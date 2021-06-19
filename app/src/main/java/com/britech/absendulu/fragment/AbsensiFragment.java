package com.britech.absendulu.fragment;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.cekAbsen.ResponseCekAbsen;
import com.britech.absendulu.model.ceklokasi.ResponseCekLokasi;
import com.britech.absendulu.model.jamAbsen.ResponseJamAbsen;
import com.britech.absendulu.model.postdataabsen.ResponseDataAbsen;
import com.britech.absendulu.model.responseRecognition.ResponseRecognition;
import com.britech.absendulu.model.updatedataabsen.ResponseGetIdUpdate;
import com.britech.absendulu.model.updatedataabsen.ResponseUpdateDataAbsen;
import com.britech.absendulu.model.uploadRecognition.ResponseMyFoto;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;
import com.bumptech.glide.Glide;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.ontbee.legacyforks.cn.pedant.SweetAlert.SweetAlertDialog;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import gun0912.tedbottompicker.TedBottomPicker;
import id.zelory.compressor.Compressor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;


public class AbsensiFragment extends Fragment implements EasyPermissions.PermissionCallbacks {

    String TAG;
    PrefManager prefManager;
    FragmentActivity listener;
    ImageView btnFotoUpload;
    Button buttonAbsenKeluar;
    Button buttonAbsenMasuk;
    ApiEndpointService apiEndpointService;
    Retrofit retrofit;
    Double lang, lat;
    List<ResponseGetIdUpdate> getIdUpdates = new ArrayList();
    private static final int Image_Capture_Code = 1;
    private static final int pic_id = 123;

    private FusedLocationProviderClient client;
    private Uri uriFoto=null;
    File imgFile;
    MultipartBody.Part bodyImagePath;


    ProgressBar progressBar;
    LinearLayout layoutAbsen, messageAbsen;
    TextView absenDay,timeAbsen,cekAbsen;

    public AbsensiFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_absensi, container, false);
        btnFotoUpload = view.findViewById(R.id.foto_absen);
        buttonAbsenMasuk = view.findViewById(R.id.button_absen_masuk);
        buttonAbsenKeluar = view.findViewById(R.id.button_absen_keluar);
        progressBar = view.findViewById(R.id.progressBar);
        layoutAbsen = view.findViewById(R.id.layoutAbsen);
        messageAbsen = view.findViewById(R.id.messageAbsen);
        cekAbsen = view.findViewById(R.id.cekAbsen);
        absenDay = view.findViewById(R.id.absenDay);
        timeAbsen = view.findViewById(R.id.timeAbsen);
        clikActionImg();
        return view;

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity() != null) {
            client = LocationServices.getFusedLocationProviderClient(listener);
            openPermission();
            Dexter.withActivity(getActivity())
                    .withPermissions(
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .withListener(new MultiplePermissionsListener() {
                        @Override public void onPermissionsChecked(MultiplePermissionsReport report) {
                        }
                        @Override public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        }
                    }).check();
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Capture_Code) {
            if (resultCode == RESULT_OK) {
                Bitmap bp = (Bitmap) data.getExtras().get("data");

                Uri tempUri = getImageUri(getContext(), bp);

                // CALL THIS METHOD TO GET THE ACTUAL PATH
                File finalFile = new File(getRealPathFromURI(tempUri));

                imgFile = new File(String.valueOf(finalFile));

                btnFotoUpload.setImageBitmap(bp);
                postRecognition();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(listener, "Cancelled", Toast.LENGTH_LONG).show();
            }
        }
    }
    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }


    /**
     *  PERIKSA LOKASI & ABSENSI
        ==============================
     **/
    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(123)
    private void openPermission() {
        String[]perms = {ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        //get long/lat
        if (EasyPermissions.hasPermissions(listener,perms)){
            client.getLastLocation().addOnSuccessListener(listener, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location !=null){
                        lat = location.getLatitude();
                        lang = location.getLongitude();
                        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
                        PrefManager prf = new PrefManager(listener);
                        Call<ResponseCekLokasi> cekLokasi =api.cekLokasi("Bearer " +prf.getString(Const.TOKEN),lat, lang);
                        if (lat != null && lang != null){
                            cekLokasi.enqueue(new Callback<ResponseCekLokasi>() {
                                @Override
                                public void onResponse(@NonNull Call<ResponseCekLokasi> call,@NonNull Response<ResponseCekLokasi> response) {
                                    if (response.isSuccessful()) {
                                        jamAbsen();
                                    }else{
                                        new SweetAlertDialog(listener)
                                                .setTitleText("Anda Berada Diluar Kantor")
                                                .show();
                                    }
                                }

                                @Override
                                public void onFailure(@NonNull Call<ResponseCekLokasi> call,@NonNull Throwable t) {
                                    Toast.makeText(listener, "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
                                    layoutAbsen.setVisibility(View.GONE);
                                }
                            });
                        } else {
                            layoutAbsen.setVisibility(View.GONE);
                            new SweetAlertDialog(listener)
                                    .setTitleText("Nyalakan Lokasi")
                                    .show();
                        }
                    }else{
                        layoutAbsen.setVisibility(View.GONE);
                        cekAbsen.setText("Aktifkan GPS");
                        new SweetAlertDialog(listener)
                                .setTitleText("Aktifkan GPS Lokasi Anda")
                                .show();
                    }
                }
            });
        } else {
            EasyPermissions.requestPermissions(this, "We need Permission",
                    123, perms);
        }
    }

    /**
     *  PENCARIAN PATH GAMBAR
     ==============================
     **/
    public String getRealPathFromUri(final Uri uri) {
        // DocumentProvider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && DocumentsContract.isDocumentUri(getContext(), uri)) {

            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {

                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));

                return getDataColumn(getContext(), contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }

                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{
                        split[1]
                };

                return getDataColumn(getContext(), contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {

            // Return the remote address
            if (isGooglePhotosUri(uri))
                return uri.getLastPathSegment();

            return getDataColumn(getContext(), uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }

        return null;
    }


    private String getDataColumn(Context context, Uri uri, String selection,
                                 String[] selectionArgs) {

        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {
                column
        };

        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs,
                    null);
            if (cursor != null && cursor.moveToFirst()) {
                final int index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    private boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    private boolean isGooglePhotosUri(Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }

    /**
     *  AKSI PENGAMBILAN FOTO
     ==============================
     **/
    public void clikActionImg() {
        //OPEN CAMERA
        btnFotoUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);
//                TedBottomPicker.with(getActivity())
//                        .show(new TedBottomPicker.OnImageSelectedListener() {
//                            @Override
//                            public void onImageSelected(Uri uri) {
//                                // here is selected uri
//                                uriFoto=uri;
//                                Picasso.get().load(uri).into(btnFotoUpload);
//                                if(uriFoto!=null){
//                                    File tempBitmap= null;
//                                    try {
//                                        tempBitmap = new Compressor(requireContext())
//                                                .setQuality(60)
//                                                .compressToFile(new File(Objects.requireNonNull(uriFoto.getPath())));
//                                        uriFoto=Uri.fromFile(tempBitmap);
//
//                                        String filePath = getRealPathFromUri(uriFoto);
//                                        if (filePath != null && !filePath.isEmpty()) {
////                                            File file = new File(filePath);
//                                            imgFile = new File(filePath);
//                                            if (imgFile.exists()) {
//                                                progressBar.setVisibility(View.VISIBLE);
//                                                postRecognition();
//                                            } else {
//                                                new SweetAlertDialog(listener)
//                                                        .setTitleText("Foto Tidak Ada")
//                                                        .show();
//                                            }
////                                            if (imgFile.exists()) {
////                                                // creates RequestBody instance from file
//////                            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
//////                            // MultipartBody.Part is used to send also the actual filename
////////                                                profileViewModel.multipartImageProfile = MultipartBody.Part.createFormData("foto", file.getName(), requestFile);
//////                            imgFile = new File(file.getPath());
////                                                imgFile.getName();
////
////                                            }
//                                        }
//                                    } catch (IOException e) {
//                                        e.printStackTrace();
//                                    }
//                                }
//                            }
//                        });
            }
        });
    }

    /**
     *  KIRIM DATA KE SERVER PEMBANDING
     ==============================
     **/
    public void postRecognition() {
        try {
            PrefManager prf = new PrefManager(listener);

            RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/from-data"), imgFile);
            bodyImagePath = MultipartBody.Part.createFormData("foto_upload", imgFile.getName(), requestFile);

            RequestBody usersid = RequestBody.create(MultipartBody.FORM, prf.getString(Const.ID));
            RequestBody path = RequestBody.create(MultipartBody.FORM, prf.getString(Const.PATHRECOGNITION));

            ApiEndpointService apiService = ApiClient.getApiClient().create(ApiEndpointService.class);

            Call<ResponseRecognition> call = apiService.postRecognition(
                    "Bearer " + prf.getString(Const.TOKEN),
                    usersid,
                    path,
                    bodyImagePath
            );
            call.enqueue(new Callback<ResponseRecognition>() {
                @Override
                public void onResponse(Call<ResponseRecognition> call, Response<ResponseRecognition> response) {
                    progressBar.setVisibility(View.VISIBLE);
                    if (response.isSuccessful()){
                        if (response.body() != null) {
                            if (response.body().getData().getSimiliarity() == null){
                                progressBar.setVisibility(View.GONE);
                                new SweetAlertDialog(listener)
                                        .setTitleText("Wajah Tidak Dikenali")
                                        .show();
                            } else if (response.body().getData().getSimiliarity().equals("true")) {
                                postData();
                                progressBar.setVisibility(View.GONE);
                            } else {
                                progressBar.setVisibility(View.GONE);
                                new SweetAlertDialog(listener)
                                        .setTitleText("Wajah Tidak Dikenali")
                                        .show();
                            }
                        } else {
                            progressBar.setVisibility(View.GONE);
                            new SweetAlertDialog(listener)
                                    .setTitleText("Gagal Upload Ulangi")
                                    .show();
                        }
                    } else {
                        progressBar.setVisibility(View.GONE);
                        new SweetAlertDialog(listener)
                                .setTitleText("Coba Ulangi Absen")
                                .show();
                    }
                }
                @Override
                public void onFailure(Call<ResponseRecognition> call, Throwable t) {
                    Toast.makeText(listener, String.valueOf(t), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception $e){
            Toast.makeText(listener, String.valueOf($e), Toast.LENGTH_SHORT).show();
        }
    }


    public void jamAbsen () {
        SimpleDateFormat formatOutgoing = new SimpleDateFormat("HH");
        TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
        formatOutgoing.setTimeZone(tz);

        Calendar c = Calendar.getInstance();

        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
        PrefManager prf = new PrefManager(listener);
        Call<ResponseJamAbsen> jamAbsen =api.getJamAbsen("Bearer " +prf.getString(Const.TOKEN));
        jamAbsen.enqueue(new Callback<ResponseJamAbsen>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<ResponseJamAbsen> call,@NonNull Response<ResponseJamAbsen> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {

                        String dateNow = formatOutgoing.format(c.getTime());

                        String pagiawal = formatOutgoing.format(response.body().getData().getAwalPagiAwal());
                        String pagiakhir = formatOutgoing.format(response.body().getData().getAwalPagiAkhir());

                        String soreawal = formatOutgoing.format(response.body().getData().getAwalSoreAwal());
                        String soreakhir = formatOutgoing.format(response.body().getData().getAwalSoreAkhir());

                        if (Integer.parseInt(dateNow) >= Integer.parseInt(pagiawal)  && Integer.parseInt(dateNow) <= Integer.parseInt(pagiakhir) ) {
                            layoutAbsen.setVisibility(View.VISIBLE);
                            messageAbsen.setVisibility(View.GONE);
                            cekAbsen.setText("Silahkan Absen Pagi");
                            cekAbsenPagi();
                        } else if (Integer.parseInt(dateNow) >= Integer.parseInt(soreawal)  && Integer.parseInt(dateNow) <= Integer.parseInt(soreakhir)) {
                            layoutAbsen.setVisibility(View.VISIBLE);
                            messageAbsen.setVisibility(View.GONE);
                            cekAbsen.setText("Silahkan Absen Sore");
                            cekAbsenSore();
                        }
                    } else {
                        cekAbsen.setText("BODY NULL");
                    }
                } else {
                    cekAbsen.setText("FILED RESPONSE");
                }
            }

            @Override
            public void onFailure(Call<ResponseJamAbsen> call, Throwable t) {
                Toast.makeText(listener, String.valueOf(call) + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *  CEK ABSEN PAGI
     ==============================
     **/
    public void cekAbsenPagi() {
        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
        PrefManager prf = new PrefManager(listener);
        Call<ResponseCekAbsen> cekLokasi =api.getCekAbsen("Bearer " +prf.getString(Const.TOKEN));
        cekLokasi.enqueue(new Callback<ResponseCekAbsen>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<ResponseCekAbsen> call,@NonNull Response<ResponseCekAbsen> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getData() != null) {
                            if (response.body().getData().getTimeIn() != null) {
                                layoutAbsen.setVisibility(View.GONE);
                                messageAbsen.setVisibility(View.VISIBLE);
                                absenDay.setText("SUDAH ABSEN PAGI");

                                SimpleDateFormat formatOutgoing = new SimpleDateFormat("HH:mm aa");
                                TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
                                formatOutgoing.setTimeZone(tz);
                                String absen = formatOutgoing.format(response.body().getData().getTimeIn());
                                timeAbsen.setText(absen);
                            }
                        }
                    } else {
                        cekAbsen.setText("Absen ... 1");
                    }
                } else {
                    cekAbsen.setText("Absen ... 2");
                }
            }

            @Override
            public void onFailure(Call<ResponseCekAbsen> call, Throwable t) {
                Toast.makeText(listener, String.valueOf(call) + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *  CEK ABSEN SORE
     ==============================
     **/
    public void cekAbsenSore() {
        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
        PrefManager prf = new PrefManager(listener);
        Call<ResponseCekAbsen> cekLokasi =api.getCekAbsen("Bearer " +prf.getString(Const.TOKEN));
        cekLokasi.enqueue(new Callback<ResponseCekAbsen>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<ResponseCekAbsen> call,@NonNull Response<ResponseCekAbsen> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        if (response.body().getData() != null) {
                            if (response.body().getData().getTimeOut() != null) {
                                layoutAbsen.setVisibility(View.GONE);
                                messageAbsen.setVisibility(View.VISIBLE);
                                absenDay.setText("SUDAH ABSEN SORE");

                                SimpleDateFormat formatOutgoing = new SimpleDateFormat("HH:mm aa");
                                TimeZone tz = TimeZone.getTimeZone("Asia/Jakarta");
                                formatOutgoing.setTimeZone(tz);
                                String absen = formatOutgoing.format(response.body().getData().getTimeOut());
                                timeAbsen.setText(absen);
                            }
                        }
                    } else {
                        cekAbsen.setText("Absen ... 1");
                    }
                } else {
                    cekAbsen.setText("Absen ... 2");
                }
            }

            @Override
            public void onFailure(Call<ResponseCekAbsen> call, Throwable t) {
                Toast.makeText(listener, String.valueOf(call) + t, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     *  KIRIM DATA ABSENSI
     ==============================
     **/
    private void postData() {
        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
        PrefManager prefManager = new PrefManager(listener);
        Call<ResponseCekLokasi> cekLokasi = api.cekLokasi("Bearer" +prefManager.getString(Const.TOKEN),lat,lang);

        if (lat != null && lang != null){
            cekLokasi.enqueue(new Callback<ResponseCekLokasi>() {
                @Override
                public void onResponse(Call<ResponseCekLokasi> call, Response<ResponseCekLokasi> response) {
                    if(response.isSuccessful()){
                        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
                        final PrefManager prefManager = new PrefManager(listener);
                        Call<ResponseGetIdUpdate> getIdUpdate = api.getIdUpdate("Bearer"+ prefManager.getString(Const.TOKEN));
                        getIdUpdate.enqueue(new Callback<ResponseGetIdUpdate>() {
                            @Override
                            public void onResponse(Call<ResponseGetIdUpdate> call, Response<ResponseGetIdUpdate> response) {
                                if (response.isSuccessful()){
                                    PrefManager prefManager = new PrefManager(listener);
                                    prefManager.setString(Const.IDABSEN, String.valueOf(response.body().getData().getId()));
//                                    buttonAbsenMasuk.setVisibility(View.INVISIBLE);
//                                    buttonAbsenKeluar.setVisibility(View.VISIBLE);
                                    updateData();
                                }else{
                                    ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
                                    PrefManager prefManager = new PrefManager(listener);
                                    Call<ResponseDataAbsen> postAbsen = api.postAbsen("Bearer" + prefManager.getString(Const.TOKEN),lat,lang);
                                    if(lat != null && lang != null){
//                                        buttonAbsenMasuk.setVisibility(View.VISIBLE);
//                                        buttonAbsenKeluar.setVisibility(View.INVISIBLE);
                                        postAbsen.enqueue(new Callback<ResponseDataAbsen>() {
                                            @Override
                                            public void onResponse(Call<ResponseDataAbsen> call, Response<ResponseDataAbsen> response) {
                                                if (response.isSuccessful()){
                                                    new SweetAlertDialog(listener)
                                                        .setTitleText("Berhasil Absen")
                                                        .show();

//                                                    buttonAbsenMasuk.setVisibility(View.INVISIBLE);
//                                                    buttonAbsenKeluar.setVisibility(View.INVISIBLE);
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<ResponseDataAbsen> call, Throwable t) {
                                                Toast.makeText(listener, "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    } else {
                                        new SweetAlertDialog(listener)
                                                .setTitleText("Nyalakan Lokasi")
                                                .show();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseGetIdUpdate> call, Throwable t) {
                                Toast.makeText(listener, "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<ResponseCekLokasi> call, Throwable t) {
                    Toast.makeText(listener, "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     *  KIRIM DATA ABSENSI PULANG
     ==============================
     **/
    private void updateData(){
        ApiEndpointService api = ApiClient.getApiClient().create(ApiEndpointService.class);
        PrefManager prf = new PrefManager(listener);
        int id = Integer.parseInt(prf.getString(Const.IDABSEN));
        Call<ResponseUpdateDataAbsen> updateAbsen = api.updateAbsen("Bearer"+ prf.getString(Const.TOKEN),id,lat,lang);
        if(lat != null && lang !=null){
            updateAbsen.enqueue(new Callback<ResponseUpdateDataAbsen>() {
                @Override
                public void onResponse(Call<ResponseUpdateDataAbsen> call, Response<ResponseUpdateDataAbsen> response) {
                    if (response.isSuccessful()) {
                        new SweetAlertDialog(listener)
                                .setTitleText("Selamat beristirahat")
                                .show();

//                        buttonAbsenKeluar.setVisibility(View.GONE);
                    }
                }

                @Override
                public void onFailure(Call<ResponseUpdateDataAbsen> call, Throwable t) {
                    Toast.makeText(listener, "Tidak ada Koneksi Internet", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            new SweetAlertDialog(listener)
                    .setTitleText("Nyalakan Lokasi")
                    .show();
        }
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

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            new AppSettingsDialog.Builder(this).build().show();
        }
    }
}
