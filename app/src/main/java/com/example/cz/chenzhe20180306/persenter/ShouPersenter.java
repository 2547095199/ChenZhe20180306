package com.example.cz.chenzhe20180306.persenter;

import com.example.cz.chenzhe20180306.bean.ShouBean;
import com.example.cz.chenzhe20180306.molder.MyShouMolder;
import com.example.cz.chenzhe20180306.molder.ShouCallBack;
import com.example.cz.chenzhe20180306.view.ShouView;

/**
 * Created by CZ on 2018/3/6.
 */

public class ShouPersenter {
    ShouView view;
    private final MyShouMolder molder;

    public ShouPersenter(ShouView view) {
        this.view = view;
        molder = new MyShouMolder();
    }

    public void getData() {
        molder.get(new ShouCallBack() {
            @Override
            public void success(ShouBean bean) {
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

    public void shou() {
        this.view = null;
    }
}
