package org.vcmo.thisgoods.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.bigkoo.svprogresshud.SVProgressHUD;

import org.vcmo.thisgoods.Dispatcher;
import org.vcmo.thisgoods.R;
import org.vcmo.thisgoods.view.base.BaseActivity;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();


    private Dispatcher mDispatcher;

    private final static int PASSWORD_MINIMUM_LENGTH = 6;
    private final static int ACCOUNT_MINIMUM_LENGTH = 6;

    private final static byte ACCOUNT_FLAG = 0x01;
    private final static byte PASSWORD_FLAG = ACCOUNT_FLAG << 1;
    private final static byte REGISTER_PHONE_FLAG = ACCOUNT_FLAG << 2;
    private final static byte REGISTER_PASSWORD_FLAG = ACCOUNT_FLAG << 3;

    @Bind(R.id.login_view)
    View loginView;
    @Bind(R.id.register_view)
    View registerView;

    @Bind({R.id.login_account, R.id.login_password, R.id.register_phone_number, R.id.register_password})
    List<TextView> logingForm;

    @Bind(R.id.btn_login)
    Button btnLogin;

    private byte textSignal = 0x00;

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


        svProgressHUD = new SVProgressHUD(this);

        for (int i = 0; i < logingForm.size(); i++) {

            final int flag = i;

            logingForm.get(i).addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    byte nowFlag = (byte) (ACCOUNT_FLAG << flag);

                    if (count + start < ACCOUNT_MINIMUM_LENGTH) {
                        textSignal &= ~nowFlag;
                    } else {
                        textSignal |= nowFlag;
                    }

                    btnLogin.setBackgroundResource(((textSignal & 0x03) == 0x03) ? R.drawable.shape_btn_circle_red : R.drawable.shape_btn_circle_gray);


                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {

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
        Log.d(TAG, "login: " + textSignal);

        if ((textSignal & 0x03) != 0x03)
            return;

        //
        Log.d(TAG, "login: ---request");

//        svProgressHUD.showWithStatus("登录中···");

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btn_register)
    public void regist() {
        if (((textSignal >> 2) & 0x3) != 0x03)
            return;

        Log.d(TAG, "regist: ---request");
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

