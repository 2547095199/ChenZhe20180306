package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.app.MyApp;
import com.example.cz.chenzhe20180306.bean.DeleteBean;
import com.example.cz.chenzhe20180306.bean.GoWuCheBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/3/6.
 */

public class MyDeleteMolder {
    //http://120.27.23.105/product/deleteCart?uid=100&pid=45
    public void get(String uid, String pid, String source, final DeleteCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("pid", pid);
        map.put("source", source);

        MyApp.inters.getDelete(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DeleteBean>() {
                    @Override
                    public void accept(DeleteBean bean) throws Exception {
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
