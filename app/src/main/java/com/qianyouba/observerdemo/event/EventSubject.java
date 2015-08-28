package com.qianyouba.observerdemo.event;

import android.app.usage.UsageEvents;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的主题角色的实现，这里用来监听事件的发生，采用单例模式来实现
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public class EventSubject implements EventSubjectInterface {
    private List<EventObserver> mEventObservers = new ArrayList<>();
    private static volatile EventSubject mEventSubject;
    private EventSubject(){}

    public static synchronized EventSubject getInstance(){
        if(mEventSubject==null){
            mEventSubject = new EventSubject();
        }
        return mEventSubject;
    }

    @Override
    public void registerObserver(EventObserver observer) {
        synchronized (mEventObservers){
            if(observer!=null){
                if(mEventObservers.contains(observer))
                    return;
                mEventObservers.add(observer);
            }
        }
    }

    @Override
    public void removeObserver(EventObserver observer) {
        synchronized (mEventObservers){
            int index = mEventObservers.indexOf(observer);
            if(index>=0)
                mEventObservers.remove(observer);
        }
    }

    @Override
    public void notifyObserver(String eventType) {
        if(mEventObservers!=null && mEventObservers.size()>0 && eventType!=null){
            for(EventObserver observer:mEventObservers){
                observer.dispathChange(eventType);
            }
        }
    }
}
