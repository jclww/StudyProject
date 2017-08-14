package com.lww.ssm.dao;

import com.lww.ssm.entity.DomyGoods;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface DomyGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DomyGoodsWithBLOBs record);

    int insertSelective(DomyGoodsWithBLOBs record);

    DomyGoodsWithBLOBs selectByPrimaryKey(Long id);


    public int createGoods(DomyGoodsWithBLOBs dg);
    public List<Map<String,Object>> findAllByLimit(Map<String,Integer> params);
    public Map<String,Object> findBySn(String sn);
    public Map<String,Object> findDetailBySn(String sn);
    public List<Map<String,Object>> findByName(String name);
    public List<Map<String,Object>> findByTime(Map<String,Date> params);
    public void deleteBysn(String sn);
    public void updateBySn(Map<String,Object> params);
    int updateByPrimaryKeySelective(DomyGoodsWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DomyGoodsWithBLOBs record);

    int updateByPrimaryKey(DomyGoods record);
}