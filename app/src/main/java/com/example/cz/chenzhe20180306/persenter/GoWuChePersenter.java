package com.example.cz.chenzhe20180306.persenter;

import com.example.cz.chenzhe20180306.bean.GoWuCheBean;
import com.example.cz.chenzhe20180306.molder.GoWuCheCallBack;
import com.example.cz.chenzhe20180306.molder.MyGoWuCheMolder;
import com.example.cz.chenzhe20180306.view.GoWuCheView;

/**
 * Created by CZ on 2018/3/6.
 */

public class GoWuChePersenter {
    GoWuCheView view;
    private final MyGoWuCheMolder molder;

    public GoWuChePersenter(GoWuCheView view) {
        this.view = view;
        molder = new MyGoWuCheMolder();
    }

    public void getData(String uid, String source) {
        molder.get(uid, source, new GoWuCheCallBack() {
            @Override
            public void success(GoWuCheBean bean) {
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

    public void gowuche() {
        this.view = null;
    }
}
