package com.lww.learn;

public interface DomyRedisInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DomyRedisInfo record);

    int insertSelective(DomyRedisInfo record);

    DomyRedisInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DomyRedisInfo record);

    int updateByPrimaryKey(DomyRedisInfo record);
}