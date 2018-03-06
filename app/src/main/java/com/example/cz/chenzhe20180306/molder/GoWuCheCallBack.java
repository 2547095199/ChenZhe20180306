package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.bean.GoWuCheBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface GoWuCheCallBack {
    public void success(GoWuCheBean bean);

    public void failuer(String e);
}
