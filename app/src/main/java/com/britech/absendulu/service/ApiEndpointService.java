package com.britech.absendulu.service;

import com.britech.absendulu.model.ResponseUser;
import com.britech.absendulu.model.bixbox.ResponseSendMessages;
import com.britech.absendulu.model.cekAbsen.ResponseCekAbsen;
import com.britech.absendulu.model.ceklokasi.ResponseCekLokasi;
import com.britech.absendulu.model.createabsen.ResponseCreateAbsent;
import com.britech.absendulu.model.getdataabsensi.ResponseGetDataAbsensi;
import com.britech.absendulu.model.jamAbsen.ResponseJamAbsen;
import com.britech.absendulu.model.postdataabsen.ResponseDataAbsen;
import com.britech.absendulu.model.responseRecognition.ResponseRecognition;
import com.britech.absendulu.model.updatedataabsen.ResponseGetIdUpdate;
import com.britech.absendulu.model.updatedataabsen.ResponseUpdateDataAbsen;
import com.britech.absendulu.model.uploadRecognition.ResponseMyFoto;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndpointService {
//    @Headers({
//            "Content-Type: application/x-www-form-urlencoded",
//    })

    @FormUrlEncoded
    @POST("login")//endpoint
    Call<ResponseUser> getAccessToken(@Field("nik")String nik, @Field("password")String password);

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
            "Accept: application/json",
    })
    @POST("absensis")
    @FormUrlEncoded
    Call<ResponseDataAbsen> postAbsen(@Header("Authorization") String token ,
                                      @Field("latitude") Double lattitude,
                                      @Field("longtitude") Double langitude);
    @PUT("absensis/{id}")
    @FormUrlEncoded
    Call<ResponseUpdateDataAbsen> updateAbsen(@Header("Authorization") String token ,
                                              @Path("id") int id,
                                              @Field("latitude") Double lattitude,
                                              @Field("longtitude") Double langitude );
    @GET("cek")
    Call<ResponseCekLokasi> cekLokasi(@Header("Authorization") String token ,
                                      @Query("lat") Double lattitude,
                                      @Query("lang") Double langitude );

    @POST("createAbsen")
    Call<ResponseCreateAbsent> createAbsent(@Header("Authorization") String token ,
                                            @Query("lat") Double lattitude,
                                            @Query("lang") Double langitude );

    @GET("getUpdate")
    Call<ResponseGetIdUpdate> getIdUpdate(@Header("Authorization") String token);

    @GET("absensis")
    Call<ResponseGetDataAbsensi> getAbsensi(@Header("Authorization") String token);

    @GET("absenCek")
    Call<ResponseCekAbsen> getCekAbsen(@Header("Authorization") String token);

    @GET("jamAbsen")
    Call<ResponseJamAbsen> getJamAbsen(@Header("Authorization") String token);


    @POST("user/app")
    Call<ResponseUser> terminateApp();

    @Headers({
            "Content-Type: application/x-www-form-urlencoded",
    })
    @POST("sms-notification/1.0.0/messages")
    @FormUrlEncoded
    Call<ResponseSendMessages> postMassage (@Header("x-api-key") String token,
                                            @Header("senderid") String senderid,
                                            @Field("msisdn")String msisdn,
                                            @Field("content")String content);

    @Multipart
    @Headers({
            "Accept: application/json",
    })
    @POST("recognition")
    Call<ResponseRecognition> postRecognition (@Header("Authorization") String token,
                                               @Part("users_id") RequestBody usersid,
                                               @Part("foto_recognition") RequestBody fotorecognition,
                                               @Part MultipartBody.Part fotoupload);

    @GET("my_foto_recog")
    Call<ResponseMyFoto> getMyFoto(@Header("Authorization") String token);
}
