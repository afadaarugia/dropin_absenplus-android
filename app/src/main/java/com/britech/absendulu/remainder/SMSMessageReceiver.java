package com.britech.absendulu.remainder;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.Constraints;
import androidx.core.app.NotificationCompat;

import com.britech.absendulu.R;
import com.britech.absendulu.config.Const;
import com.britech.absendulu.manager.PrefManager;
import com.britech.absendulu.model.bixbox.ResponseSendMessages;
import com.britech.absendulu.model.cekAbsen.ResponseCekAbsen;
import com.britech.absendulu.service.ApiClient;
import com.britech.absendulu.service.ApiEndpointService;

import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SMSMessageReceiver extends BroadcastReceiver {

    public static final int NOTIFICATION_ID = 1;
    public static String CHANNEL_ID = "channel_01";
    public static CharSequence CHANNEL_NAME = "rifan channel";

    public SMSMessageReceiver() {

    }

    @Override
    public void onReceive(final Context context, Intent intent) {
        String message = "Ayo absen pulang dulu jangan lupa";
        String title = "Absen Sore";
        showNotificationDaily(context, title,message);
        senMassage(context);

//        ApiEndpointService apiInterface= ApiClient.getApiClient().create(ApiEndpointService.class);
//        final PrefManager prefManager = new PrefManager(context);
//        Call<ResponseCekAbsen> api=apiInterface.getCekAbsen("Bearer "+prefManager.getString(Const.TOKEN));
//        api.enqueue(new Callback<ResponseCekAbsen>() {
//            @Override
//            public void onResponse(@NonNull Call<ResponseCekAbsen> call, @NonNull Response<ResponseCekAbsen> response) {
//                if (response.isSuccessful()) {
//                    if(response.body().getData() != null) {
//                        if (response.body().getData().getTimeOut() == null) {
//                            senMassage(context);
//                        } else {
//                            Toast.makeText(context, "Belum Absen BRO", Toast.LENGTH_LONG).show();
//                        }
//                    }else {
//                        Toast.makeText(context,"DATA NGGA ADA BRO", Toast.LENGTH_LONG).show();
//                    }
//                } else {
//                    Toast.makeText(context,"ERROR RESPONSE NYA BRO", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<ResponseCekAbsen> call, @NonNull Throwable t) {
//                Toast.makeText(context,"Internet Disconnect" + t, Toast.LENGTH_LONG).show();
//                Log.e(Constraints.TAG, String.valueOf(t));
//            }
//        });
    }

    private void senMassage(final Context context) {
        final PrefManager prefManager = new PrefManager(context);
        ApiEndpointService api = ApiClient.getApiBixBox().create(ApiEndpointService.class);
        String pesan,senderid;
        senderid = "d'bigbox.id";
        pesan = "Absen BRO CEPAT SEKARANG";
        Call<ResponseSendMessages> postAbsen = api.postMassage("GWRTCI8kI3CB7BzQ7aIC7wgWA7EH4WOe",senderid, prefManager.getString(Const.NOHP), pesan);
        postAbsen.enqueue(new Callback<ResponseSendMessages>() {
            @Override
            public void onResponse(@NonNull Call<ResponseSendMessages> call,@NonNull Response<ResponseSendMessages> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(context, "Berhasil", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        if (response.errorBody() != null) {
                            Toast.makeText(context, response.errorBody().string(), Toast.LENGTH_LONG).show();
                        }
                    } catch (IOException e) {
                        Toast.makeText(context, String.valueOf(e), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseSendMessages> call, Throwable t) {
                Toast.makeText(context, "Tidak ada Koneksi Internet", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showNotificationDaily(Context context, String title, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_icon_app)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_icon_app))
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{1000, 1000, 1000, 1000, 1000});
            channel.setDescription(CHANNEL_NAME.toString());
            mBuilder.setChannelId(CHANNEL_ID);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel);
            }
        }

        Notification notification = mBuilder.build();

        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID, notification);
        }
    }

    public void setReleaseToday(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        calendar.set(Calendar.MINUTE, 30);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, getPending(context));
    }

    public void setCencel(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        if (alarmManager != null) alarmManager.cancel(getPending(context));
    }

    private static PendingIntent getPending(Context context) {
        Intent intent = new Intent(context, SMSMessageReceiver.class);
        return  PendingIntent.getBroadcast(context, NOTIFICATION_ID, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

}
