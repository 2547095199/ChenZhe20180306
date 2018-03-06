package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.bean.DeleteBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface DeleteCallBack {
    public void success(DeleteBean bean);

    public void failuer(String e);
}
