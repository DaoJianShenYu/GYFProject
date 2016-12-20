package com.hrw.network.volleytwiceencap.http.Login;

import com.android.volley.Request;
import com.hrw.shopping.bean.Invoice;
import com.hrw.shopping.http.Constant;
import com.hrw.shopping.http.HttpLoader;
import com.hrw.shopping.http.HttpParams;
import com.hrw.shopping.http.IProtocol;

/**
 * Created by fxc on 2016/12/14.
 */

public class InvoiceProtocol implements IProtocol {
    @Override
    public Request<?> doRequest(HttpLoader loader, HttpLoader.HttpListener listener) {
        HttpParams httpParams = new HttpParams();

        return loader.get(Constant.REQUEST_INVOICE, httpParams,
                Invoice.class, Constant.INVOICE, listener);
    }
}
