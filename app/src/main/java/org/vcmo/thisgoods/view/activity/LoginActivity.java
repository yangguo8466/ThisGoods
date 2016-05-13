package org.vcmo.thisgoods.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.LoginFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;
import com.squareup.otto.Subscribe;

import org.vcmo.thisgoods.Dispatcher;
import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.actions.LoginActionCreator;
import org.vcmo.thisgoods.base.util.MyTextWatch;
import org.vcmo.thisgoods.stores.LoginStore;
import org.vcmo.thisgoods.view.base.BaseActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();


    private Dispatcher mDispatcher;

    private final static byte ACCOUNT_FLAG = 0x01;

    @Bind(R.id.login_view)
    View loginView;
    @Bind(R.id.register_view)
    View registerView;

    int[] minLengths = {6, 6, 11, 6};
    int[] maxLengths = {-1, -1, 11, -1};

    @Bind({R.id.login_account, R.id.login_password, R.id.register_phone_number, R.id.register_password})
    List<EditText> logingForm;

    @Bind(R.id.btn_login)
    Button btnLogin;

    private byte textSignal = 0x00;
    private LoginActionCreator actionCreator;
    private LoginStore loginStore;

    private SVProgressHUD svProgressHUD;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_login);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ButterKnife.bind(this);

        init();
    }

    private void init() {

        actionCreator = LoginActionCreator.getInstance();
        loginStore = LoginStore.getInstance();
        loginStore.register(this);

        svProgressHUD = new SVProgressHUD(this);

        for (int i = 0; i < logingForm.size(); i++) {

            final int flag = i;

            MyTextWatch.createTextWatch(logingForm.get(i), maxLengths[i], minLengths[i], new MyTextWatch.TextChangCallBack() {

                @Override
                public void call(int totalCount) {
                }

                @Override
                public void changeStatus(boolean active) {
                    byte nowFlag = (byte) (ACCOUNT_FLAG << flag);

                    if (active) {
                        textSignal |= nowFlag;
                    } else {
                        textSignal &= ~nowFlag;
                    }
                    btnLogin.setBackgroundResource(((textSignal & 0x03) == 0x03) ? R.drawable.shape_btn_circle_red : R.drawable.shape_btn_circle_gray);

                }
            });
        }

    }


    @OnClick(R.id.btn_register)
    public void register(View view) {

        loginView.setVisibility(View.GONE);
        registerView.setVisibility(View.VISIBLE);

    }

    @OnClick(R.id.btn_reist_back)
    public void backLogin(View view) {

        loginView.setVisibility(View.VISIBLE);
        registerView.setVisibility(View.GONE);

    }

    @OnClick(R.id.btn_login)
    public void login(View view) {

        if ((textSignal & 0x03) != 0x03)
            return;

        actionCreator.login("user", "pw");

    }


    @Subscribe
    public void showLoginProcess(LoginStore.LoginStartE event) {
        svProgressHUD.showWithStatus("登录中···");
    }

    @Subscribe
    public void LoginFialed(LoginStore.LoginFailedE event) {
        dismissLoginProcess();
    }

    @Subscribe
    public void loginSuccess(LoginStore.LoginSuccessE event) {
        dismissLoginProcess();

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void dismissLoginProcess() {
        svProgressHUD.dismiss();
    }


    @OnClick(R.id.btn_register)
    public void regist() {
        if (((textSignal >> 2) & 0x3) != 0x03)
            return;


    }


    @Override
    public void onBackPressed() {

        if (svProgressHUD.isShowing()) {
            svProgressHUD.dismiss();
            return;
        }
        super.onBackPressed();
    }
}

