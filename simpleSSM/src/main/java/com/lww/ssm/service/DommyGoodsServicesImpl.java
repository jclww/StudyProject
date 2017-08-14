package com.lww.ssm.service;

import com.lww.ssm.dao.DomyGoodsMapper;
import com.lww.ssm.entity.DomyGoodsWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/7/7.
 */
@Service("dommyGoods")
public class DommyGoodsServicesImpl implements DommyGoodsServices {
    @Resource
    private DomyGoodsMapper dgm;
    public DomyGoodsWithBLOBs selectByPrimaryKey(Long id)
    {
        return dgm.selectByPrimaryKey(id);
    }
    public int deleteByPrimaryKey(Long id){
        return dgm.deleteByPrimaryKey(id);
    }
    public int createGoods(DomyGoodsWithBLOBs dg){return dgm.createGoods(dg);}
    public List<Map<String,Object>> findAllByLimit(Map<String,Integer> params){
        return dgm.findAllByLimit(params);
    }
    public Map<String,Object> findBySn(String sn){
        return dgm.findBySn(sn);
    }
    public Map<String,Object> findDetailBySn(String sn){
        return dgm.findDetailBySn(sn);
    }

    public List<Map<String,Object>> findByName(String name){
        return dgm.findByName(name);
    }
    public List<Map<String,Object>> findByTime(Map<String,Date> params){
        return dgm.findByTime(params);
    }
    public void deleteBysn(String sn){
        dgm.deleteBysn(sn);
    }
    public void updateBySn(Map<String,Object> params){
        dgm.updateBySn(params);
    }
}
