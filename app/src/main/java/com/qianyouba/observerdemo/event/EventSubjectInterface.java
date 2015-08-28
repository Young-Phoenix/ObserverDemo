package com.qianyouba.observerdemo.event;

/**
 * 抽象的主题角色
 * Created by Administrator on 2015/8/28 0028.
 * @author phoenix
 * @since 2015/8/28
 * @version 1.0
 */
public interface EventSubjectInterface {
    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(EventObserver observer);

    /**
     *移除观察者
     * @param observer
     */
    void removeObserver(EventObserver observer);

    /**
     *通知注册的观察者进行数据活着UI的更新
     * @param eventType
     */
    void notifyObserver(String eventType);
}
