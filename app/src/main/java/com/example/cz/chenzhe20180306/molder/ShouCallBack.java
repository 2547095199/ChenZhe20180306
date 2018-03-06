package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.bean.ShouBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface ShouCallBack {
    public void success(ShouBean bean);

    public void failuer(String e);
}
