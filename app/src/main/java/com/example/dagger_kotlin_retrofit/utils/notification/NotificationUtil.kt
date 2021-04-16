package com.example.dagger_kotlin_retrofit.utils.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.dagger_kotlin_retrofit.BuildConfig
import com.example.dagger_kotlin_retrofit.R

class NotificationUtil {
    companion object {
        private val CHANNEL_ID = "" + BuildConfig.APPLICATION_ID
        private const val NOTIFICATION_ID = 12
        var NOTIFICATION_REQUEST_CODE = 1
    }

    private fun builder(
        context: Context,
        title: String,
        content: String,
        priority: Int
    ): NotificationCompat.Builder {
        val build: NotificationCompat.Builder
        build = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) NotificationCompat.Builder(
            context,
            NotificationUtil.CHANNEL_ID
        ) else NotificationCompat.Builder(context)
        build.setSmallIcon(R.mipmap.ic_launcher).setContentTitle(title)
            .setContentText(content).priority =
            priority
        return build
    }

    private fun builder(
        context: Context,
        title: String,
        content: String,
        priority: Int,
        largeIcon: Bitmap
    ): NotificationCompat.Builder {
        return builder(context, title, content, priority).setLargeIcon(largeIcon)
    }

    private fun builder(
        context: Context,
        title: String,
        content: String,
        priority: Int,
        vararg actions: Action
    ): NotificationCompat.Builder? {
        val build = builder(context, title, content, priority)
        for (a in actions) {
            build.addAction(a.icon, a.actionName, a.pendingIntent)
        }
        return build
    }

    private fun builder(
        context: Context,
        title: String,
        content: String,
        priority: Int,
        largeIcon: Bitmap,
        vararg actions: Action
    ): NotificationCompat.Builder? {
        val build = builder(context, title, content, priority).setLargeIcon(largeIcon)
        for (a in actions) {
            build.addAction(a.icon, a.actionName, a.pendingIntent)
        }
        return build
    }

    fun showNotification(
        context: Context,
        title: String,
        content: String,
        priority: Int,
        classPending: Class<*>?
    ) {
        val notificationManager: NotificationManagerCompat
        notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = NotificationUtil.CHANNEL_ID
            val description: String = NotificationUtil.CHANNEL_ID
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NotificationUtil.CHANNEL_ID, name, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }
        val intent = Intent(context, classPending)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            context,
            NotificationUtil.NOTIFICATION_REQUEST_CODE,
            intent,
            0
        )
        notificationManager.notify(
            NotificationUtil.NOTIFICATION_ID,
            builder(context, title, content, priority).setContentIntent(pendingIntent).build()
        )
    }

    fun showNotification(
        context: Context,
        title: String,
        content: String,
        priority: Int,
        largeIcon: Bitmap,
        classPending: Class<*>?
    ) {
        val notificationManager: NotificationManagerCompat
        notificationManager = NotificationManagerCompat.from(context)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = NotificationUtil.CHANNEL_ID
            val description: String = NotificationUtil.CHANNEL_ID
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(NotificationUtil.CHANNEL_ID, name, importance)
            channel.description = description
            notificationManager.createNotificationChannel(channel)
        }
        val intent = Intent(context, classPending)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            context,
            NotificationUtil.NOTIFICATION_REQUEST_CODE,
            intent,
            0
        )
        notificationManager.notify(
            NotificationUtil.NOTIFICATION_ID,
            builder(context, title, content, priority, largeIcon).setContentIntent(pendingIntent)
                .build()
        )
    }
//    public static void showNotification(Context context, String title, String content, int priority, Class<?> classPending, Action... actions) {
//        NotificationManagerCompat notificationManager;
//        notificationManager = NotificationManagerCompat.from(context);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = CHANNEL_ID;
//            String description = CHANNEL_ID;
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            notificationManager.createNotificationChannel(channel);
//        }
//        Intent intent = new Intent(context, classPending);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_REQUEST_CODE, intent, 0);
//        notificationManager.notify(NOTIFICATION_ID, builder(context, title, content, priority, actions).setContentIntent(pendingIntent).build());
//    }


//    public static void showNotification(Context context, String title, String content, int priority, Class<?> classPending, Bitmap largeIcon,String ... action) {
//        NotificationManagerCompat notificationManager;
//        notificationManager = NotificationManagerCompat.from(context);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            CharSequence name = CHANNEL_ID;
//            String description = CHANNEL_ID;
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
//            channel.setDescription(description);
//            notificationManager.createNotificationChannel(channel);
//        }
//        Intent intent = new Intent(context, classPending);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_REQUEST_CODE, intent, 0);
//        notificationManager.notify(NOTIFICATION_ID, builder(context, title, content, priority, largeIcon, actions).setContentIntent(pendingIntent).build());
//    }

    //    public static void showNotification(Context context, String title, String content, int priority, Class<?> classPending, Action... actions) {
    //        NotificationManagerCompat notificationManager;
    //        notificationManager = NotificationManagerCompat.from(context);
    //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    //            CharSequence name = CHANNEL_ID;
    //            String description = CHANNEL_ID;
    //            int importance = NotificationManager.IMPORTANCE_DEFAULT;
    //            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
    //            channel.setDescription(description);
    //            notificationManager.createNotificationChannel(channel);
    //        }
    //        Intent intent = new Intent(context, classPending);
    //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    //        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_REQUEST_CODE, intent, 0);
    //        notificationManager.notify(NOTIFICATION_ID, builder(context, title, content, priority, actions).setContentIntent(pendingIntent).build());
    //    }
    //    public static void showNotification(Context context, String title, String content, int priority, Class<?> classPending, Bitmap largeIcon,String ... action) {
    //        NotificationManagerCompat notificationManager;
    //        notificationManager = NotificationManagerCompat.from(context);
    //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    //            CharSequence name = CHANNEL_ID;
    //            String description = CHANNEL_ID;
    //            int importance = NotificationManager.IMPORTANCE_DEFAULT;
    //            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
    //            channel.setDescription(description);
    //            notificationManager.createNotificationChannel(channel);
    //        }
    //        Intent intent = new Intent(context, classPending);
    //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    //        PendingIntent pendingIntent = PendingIntent.getActivity(context, NOTIFICATION_REQUEST_CODE, intent, 0);
    //        notificationManager.notify(NOTIFICATION_ID, builder(context, title, content, priority, largeIcon, actions).setContentIntent(pendingIntent).build());
    //    }
    class Action(var icon: Int, var actionName: String, var pendingIntent: PendingIntent)
}