package org.vcmo.thisgoods.actions;

import org.vcmo.thisgoods.model.action.LoginR;

/**
 * Created by Jie on 2016-05-12.
 */
public class LoginAction extends Action<LoginR> {

    public static final String ACTION_LOGIN_START = "login_start";
    public static final String ACTION_LOGIN_SUCCESS = "login_success";
    public static final String ACTION_LOGIN_FAILED = "login_failed";

    public LoginAction(String type, LoginR data) {
        super(type, data);
    }


}
