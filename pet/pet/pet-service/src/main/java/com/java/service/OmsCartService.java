package com.java.service;

import com.java.po.PmsSku;

public interface OmsCartService {
    public boolean addCart(Integer num, PmsSku sku, Long id);
}
