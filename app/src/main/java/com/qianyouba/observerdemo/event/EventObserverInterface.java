package com.qianyouba.observerdemo.event;

/**
 * 观察者接口
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public interface EventObserverInterface {
    /**
     * 根据事件进行数据或UI的更新
     * @param eventType
     */
    void dispathChange(String eventType);
}
