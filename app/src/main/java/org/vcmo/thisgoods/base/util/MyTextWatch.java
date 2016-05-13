package org.vcmo.thisgoods.base.util;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by Jie on 2016-05-13.
 */
public class MyTextWatch implements TextWatcher {

    private static final String TAG = MyTextWatch.class.getSimpleName();

    private TextChangCallBack mCallBack;

    private int minLength = -1;
    private boolean isActive = false;

    public static void createTextWatch(EditText editText, int maxLength, int minLength, TextChangCallBack callBack) {
        editText.addTextChangedListener(new MyTextWatch(editText, maxLength, minLength, callBack));
    }

    private MyTextWatch(EditText editText, int maxlength, int minLength, TextChangCallBack mCallBack) {
        this.mCallBack = mCallBack;
        this.minLength = minLength;

        if (maxlength > 0)
            editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxlength)});
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mCallBack == null)
            return;

        int length = s.length();

        if (minLength > 0) {
            if (isActive && length < minLength) {
                isActive = false;
                mCallBack.changeStatus(isActive);

            } else if (!isActive && length >= minLength) {
                isActive = true;

                mCallBack.changeStatus(isActive);
            }
        }

        mCallBack.call(s.length());
    }

    public interface TextChangCallBack {
        void call(int totalCount);

        void changeStatus(boolean active);
    }
}
