package org.vcmo.thisgoods.stores;

import org.vcmo.thisgoods.Dispatcher;
import org.vcmo.thisgoods.actions.Action;

/**
 * Created by Jie on 2016-05-12.
 */
public class LoginStore extends Store {

    private static LoginStore instance;

    public static LoginStore getInstance() {

        if (instance == null) {
            instance = new LoginStore();
            Dispatcher.getInstance().register(instance);
        }

        return instance;
    }

    @Override
    public void onAction(Action action) {

    }

    @Override
    public StoreChangeEvent changeEvent() {
        return null;
    }
}
