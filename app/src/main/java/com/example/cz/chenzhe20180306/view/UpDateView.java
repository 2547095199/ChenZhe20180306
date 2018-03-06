package com.example.cz.chenzhe20180306.view;

import com.example.cz.chenzhe20180306.bean.UpDateBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface UpDateView {
    public void success(UpDateBean bean);

    public void failuer(String e);
}
