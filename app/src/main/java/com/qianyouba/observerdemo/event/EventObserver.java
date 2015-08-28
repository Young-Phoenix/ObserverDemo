package com.qianyouba.observerdemo.event;

import android.os.Handler;
import android.os.Looper;

/**
 * 用于更新UI，这里执行更新UI的onChange方法
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public abstract class EventObserver implements EventObserverInterface {
    private Handler mHandler;
    public EventObserver(){
        mHandler = new Handler(Looper.getMainLooper());
    }
    public abstract void onChange(String eventType);
    @Override
    public void dispathChange(String eventType) {
        mHandler.post(new NotificationRunnable(eventType));
    }
    private final class NotificationRunnable implements Runnable{
        private String mEventType;
        public NotificationRunnable(String eventType){
            mEventType = eventType;
        }
        @Override
        public void run() {
            onChange(mEventType);
        }
    }
}
