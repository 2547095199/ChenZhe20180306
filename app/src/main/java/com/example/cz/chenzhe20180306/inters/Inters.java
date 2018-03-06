package com.example.cz.chenzhe20180306.inters;


import com.example.cz.chenzhe20180306.bean.DeleteBean;
import com.example.cz.chenzhe20180306.bean.GoWuCheBean;
import com.example.cz.chenzhe20180306.bean.ShouBean;
import com.example.cz.chenzhe20180306.bean.UpDateBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


/**
 * Created by CZ on 2018/3/6.
 */

public interface Inters {
    //https://www.zhaoapi.cn/ad/getAd
    @GET("ad/getAd")
    Observable<ShouBean> getShou();

    // //http://120.27.23.105/product/getCarts?uid=100&source=android
    @GET("product/getCarts")
    Observable<GoWuCheBean> getGoWuChe(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/deleteCart?uid=100&pid=45
    @GET("product/deleteCart")
    Observable<DeleteBean> getDelete(@QueryMap HashMap<String, String> map);

    //http://120.27.23.105/product/updateCarts?uid=101&sellerid=7&pid=86&selected=0&num=3
    @GET("product/updateCarts")
    Observable<UpDateBean> getUpDate(@QueryMap HashMap<String, String> map);
}
