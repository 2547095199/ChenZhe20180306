package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.app.MyApp;
import com.example.cz.chenzhe20180306.bean.ShouBean;
import com.example.cz.chenzhe20180306.bean.UpDateBean;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by CZ on 2018/3/6.
 */

public class UpDateMolder {
    //http://120.27.23.105/product/updateCarts?uid=101&sellerid=7&pid=86&selected=0&num=3
    public void get(String uid, String sellerid, String pid, String selected, String num, final UpDateCallBack callBack) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uid", uid);
        map.put("sellerid", sellerid);
        map.put("pid", pid);
        map.put("selected", selected);
        map.put("num", num);
        MyApp.inters.getUpDate(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UpDateBean>() {
                    @Override
                    public void accept(UpDateBean bean) throws Exception {
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
