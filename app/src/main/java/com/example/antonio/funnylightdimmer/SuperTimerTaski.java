package com.example.antonio.funnylightdimmer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.os.Handler;
import android.widget.TextView;

/**
 * Created by antonio on 09.12.15.
 */
public class SuperTimerTaski {
    Timer m_timer;
    MyTimerTask m_myTimerTask;


    public void checkdata(){

    }

    public SuperTimerTaski(Context context, TextView connectedField) {

        m_timer = new Timer();
        m_myTimerTask = new MyTimerTask(context, connectedField);
        //delay 1000ms, repeat in 5000ms
        m_timer.schedule(m_myTimerTask, 1000, 5000);
    }
}
    class MyTimerTask extends TimerTask {
        TextView m_connectedField;
        private final Handler handler;

        public MyTimerTask(Context context, TextView connectedField) {
            m_connectedField = connectedField;
            handler = new Handler(context.getMainLooper());
        }
        @Override
        public void run() {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat =
                    new SimpleDateFormat("dd:MMMM:yyyy HH:mm:ss a");
            final String strDate = simpleDateFormat.format(calendar.getTime());

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    m_connectedField.setText(strDate);

                }
            });
        }

        private void runOnUiThread(Runnable r) {
            handler.post(r);
        }
    }
