package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.app.MyApp;
import com.example.cz.chenzhe20180306.bean.GoWuCheBean;
import com.example.cz.chenzhe20180306.bean.ShouBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/3/6.
 */

public class MyGoWuCheMolder {
    //http://120.27.23.105/product/getCarts?uid=100&source=android
    public void get(String uid, String source, final GoWuCheCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("source", source);
        MyApp.inters.getGoWuChe(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GoWuCheBean>() {
                    @Override
                    public void accept(GoWuCheBean bean) throws Exception {
                        callBack.success(bean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        callBack.failuer(String.valueOf(throwable));
                    }
                });
    }
}
