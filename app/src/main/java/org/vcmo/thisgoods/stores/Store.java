package org.vcmo.thisgoods.stores;

import com.squareup.otto.Bus;

import org.vcmo.thisgoods.actions.Action;

/**
 * abstract store
 * Created by Jie on 2016-05-05.
 */
public abstract class Store {

    private static final Bus bus = new Bus();

    /**
     * 将controller-view注册到store中
     *
     * @param view
     */
    public void register(final Object view) {
        bus.register(view);
    }

    public void unregister(final Object view) {
        bus.unregister(view);
    }

    /**
     * Store注册于Dispatch的回调接口，根据action的类型来处理action。
     *
     * @param action
     */
    public abstract void onAction(Action action);

    /**
     * Store的广播事件，告知自己的数据已经发生改变，让controller-view来获取自己的数据更新UI
     *
     * @return
     */
    public abstract StoreChangeEvent changeEvent();


    void emitStoreChange() {
        this.bus.post(changeEvent());
    }

    public class StoreChangeEvent {
    }


}
