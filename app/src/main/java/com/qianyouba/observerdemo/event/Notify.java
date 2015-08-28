package com.qianyouba.observerdemo.event;

/**
 * 通知中心，用来通知更新数据或者UI，采用单例模式
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public class Notify {
    private static volatile Notify notify;
    private Notify(){}
    public static Notify getInstance(){
        if(notify==null){
            notify = new Notify();
        }
        return notify;
    }

    public void notifyActivity(String eventType){
        EventSubject eventSubject = EventSubject.getInstance();
        EventType eventTypes = EventType.getInstance();
        if(eventTypes.contains(eventType)){
            eventSubject.notifyObserver(eventType);
        }
    }
}
