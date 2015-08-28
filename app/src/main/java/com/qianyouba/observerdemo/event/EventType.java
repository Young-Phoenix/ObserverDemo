package com.qianyouba.observerdemo.event;

import java.util.HashSet;
import java.util.Set;

/**
 * 所有的业务类型，在这里写，方便管理
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public class EventType {
    private static volatile EventType mEventType;
    private final static Set<String> eventTypes = new HashSet<>();
    public final static String UPDATE_MAIN = "com.updateMain";
    public final static String UPDATE_TEXT = "com.updateText";
    private EventType(){
        eventTypes.add(UPDATE_MAIN);
        eventTypes.add(UPDATE_TEXT);
    }
    public static EventType getInstance(){
        if(mEventType==null){
            mEventType = new EventType();
        }
        return mEventType;
    }
    public boolean contains(String eventType){
        return eventTypes.contains(eventType);
    }
}
