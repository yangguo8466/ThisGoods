package org.vcmo.thisgoods.stores;

import org.vcmo.thisgoods.Dispatcher;
import org.vcmo.thisgoods.actions.Action;
import org.vcmo.thisgoods.actions.LoginAction;

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


    private StoreChangeEvent changeEvent;

    @Override
    public void onAction(Action action) {
        switch (action.getType()) {
            case LoginAction.ACTION_LOGIN_START:
                

                changeEvent = new LoginStartE();
                break;
            case LoginAction.ACTION_LOGIN_SUCCESS:
                changeEvent = new LoginSuccessE();
                break;
            case LoginAction.ACTION_LOGIN_FAILED:
                changeEvent = new LoginFailedE();
                break;
        }

        emitStoreChange();
    }

    @Override
    public StoreChangeEvent changeEvent() {
        return changeEvent;
    }


    public class LoginSuccessE extends StoreChangeEvent {
    }

    public class LoginFailedE extends StoreChangeEvent {
    }

    public class LoginStartE extends StoreChangeEvent {
    }
}
