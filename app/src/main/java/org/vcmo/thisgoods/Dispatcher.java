package org.vcmo.thisgoods;

import org.vcmo.thisgoods.actions.Action;
import org.vcmo.thisgoods.stores.Store;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jie on 2016-05-05.
 */
public class Dispatcher {

    private List<Store> stores;
    private static Dispatcher instance;

    public static Dispatcher getInstance() {
        if (instance == null)
            instance = new Dispatcher();

        return instance;
    }

    private Dispatcher() {
        stores = new ArrayList<>();
    }

    public void register(Store store) {
        if (stores.contains(store))
            return;

        stores.add(store);
    }

    public void unregister(Store store) {
        stores.remove(store);
    }

    public void dispatch(Action action) {
        post(action);
    }

    private void post(Action action) {
        for (Store store :
                stores) {
            store.onAction(action);
        }
    }

}
