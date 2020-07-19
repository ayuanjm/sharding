package com.yuan.sharding.dao.user;

import com.yuan.sharding.entity.TdMsSms;

import java.util.List;

public interface UserTdMsSmsMapper {

    List<TdMsSms> selectByPrimaryKey(List<Long> id);

    List<TdMsSms> selectByName(String name);

}