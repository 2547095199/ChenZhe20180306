package com.example.cz.chenzhe20180306.persenter;

import com.example.cz.chenzhe20180306.bean.UpDateBean;
import com.example.cz.chenzhe20180306.molder.UpDateCallBack;
import com.example.cz.chenzhe20180306.molder.UpDateMolder;
import com.example.cz.chenzhe20180306.view.UpDateView;

/**
 * Created by CZ on 2018/3/6.
 */

public class UpDatePersenter {
    UpDateView view;
    private final UpDateMolder molder;

    public UpDatePersenter(UpDateView view) {
        this.view = view;
        molder = new UpDateMolder();
    }

    public void getDate(String uid, String sellerid, String pid, String selected, String num) {
        molder.get(uid, sellerid, pid, selected, num, new UpDateCallBack() {
            @Override
            public void success(UpDateBean bean) {
                if (view != null) {
                    view.success(bean);
                }
            }

            @Override
            public void failuer(String e) {
                if (view != null) {
                    view.failuer(e);
                }
            }
        });
    }
}
