package com.hrw.network.volleytwiceencap.http.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by wtz on 2016/12/9.
 */
public class ProgressDialogUtils {
    private ProgressDialog progressDialog;
    /*
	 * 提示加载
	 */
    public void showDialog(Context context,String title, String message) {
        if (progressDialog == null) {

            progressDialog = ProgressDialog.show(context, title,
                    message, true, false);
        } else if (progressDialog.isShowing()) {
            progressDialog.setTitle(title);
            progressDialog.setMessage(message);
        }

        progressDialog.show();

    }
    /*
	 * 隐藏提示加载
	 */
    public void hideProgressDialog() {

        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

    }

}
