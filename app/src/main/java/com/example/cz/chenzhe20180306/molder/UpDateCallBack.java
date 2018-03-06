package com.example.cz.chenzhe20180306.molder;

import com.example.cz.chenzhe20180306.bean.UpDateBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface UpDateCallBack {
    public void success(UpDateBean bean);

    public void failuer(String e);
}
