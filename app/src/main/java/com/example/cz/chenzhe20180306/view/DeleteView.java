package com.example.cz.chenzhe20180306.view;

import com.example.cz.chenzhe20180306.bean.DeleteBean;

/**
 * Created by CZ on 2018/3/6.
 */

public interface DeleteView {
    public void success(DeleteBean bean);

    public void failuer(String e);
}
