package com.example.cz.chenzhe20180306.persenter;

import com.example.cz.chenzhe20180306.bean.DeleteBean;
import com.example.cz.chenzhe20180306.molder.DeleteCallBack;
import com.example.cz.chenzhe20180306.molder.MyDeleteMolder;
import com.example.cz.chenzhe20180306.view.DeleteView;

/**
 * Created by CZ on 2018/3/6.
 */

public class DeletePersenter {
    DeleteView view;
    private final MyDeleteMolder molder;

    public DeletePersenter(DeleteView view) {
        this.view = view;
        molder = new MyDeleteMolder();
    }

    public void getData(String uid, String pid, String source) {
        molder.get(uid, pid, source, new DeleteCallBack() {
            @Override
            public void success(DeleteBean bean) {
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

    public void getdelete() {
        this.view = null;
    }
}
