package com.zxin.jiuxian.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by Administrator on 2018/8/6.
 */

public class AddressCacheResult {
    @JSONField(name = "cacheAddress")
    public AddressListResultInfo.AddrListItem mCacheAddress;
}

