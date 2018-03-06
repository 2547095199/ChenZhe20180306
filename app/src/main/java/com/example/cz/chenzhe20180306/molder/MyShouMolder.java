package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.app.MyApp;
import com.example.cz.chenzhe20180306.bean.ShouBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/3/6.
 */

public class MyShouMolder {
    public void get(final ShouCallBack callBack) {
        MyApp.inters.getShou()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShouBean>() {
                    @Override
                    public void accept(ShouBean bean) throws Exception {
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
