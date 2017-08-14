package com.lww.ssm.service;

import com.lww.ssm.entity.DomyGoodsWithBLOBs;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/7.
 */
public interface DommyGoodsServices {
    public DomyGoodsWithBLOBs selectByPrimaryKey(Long id);
    public int deleteByPrimaryKey(Long id);
    public int createGoods(DomyGoodsWithBLOBs dg);
    public List<Map<String,Object>> findAllByLimit(Map<String,Integer> params);
    public Map<String,Object> findBySn(String sn);
    public Map<String,Object> findDetailBySn(String sn);
    public List<Map<String,Object>> findByName(String name);
    public List<Map<String,Object>> findByTime(Map<String,Date> params);
    public void deleteBysn(String sn);
    public void updateBySn(Map<String,Object> params);

}
