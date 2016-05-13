package org.vcmo.thisgoods.actions;

import org.vcmo.thisgoods.Dispatcher;
import org.vcmo.thisgoods.model.action.LoginR;
import org.vcmo.thisgoods.utils.rest.RestAPI;
import org.vcmo.thisgoods.utils.rest.RestFactory;

/**
 * Created by Jie on 2016-05-13.
 */
public class LoginActionCreator {
    private static final String TAG = LoginActionCreator.class.getSimpleName();

    private static LoginActionCreator instance;

    private Dispatcher dispatcher;
    private RestAPI rest;

    public static LoginActionCreator getInstance() {
        if (instance == null) {
            instance = new LoginActionCreator();
            instance.dispatcher = Dispatcher.getInstance();
            instance.rest = RestFactory.createRest(RestAPI.class);
        }
        return instance;
    }

    public void login(String account, String pw) {
        //tell store show loading dialog
        dispatcher.dispatch(new Action(LoginAction.ACTION_LOGIN_START, null));

        //
//        rest.login(new LoginR(account, pw));


    }

}
