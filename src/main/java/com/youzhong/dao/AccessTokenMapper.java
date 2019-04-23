package com.youzhong.dao;

import com.youzhong.entity.AccessToken;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccessTokenMapper {
    @Select("select * from t_accessToken")
    List<AccessToken> gettoken();

    @Select("insert into t_accessToken values(null,#{token},#{expiresIn})")
    void insert(AccessToken token);

    @Select("update t_accessToken set token=#{token} , expiresIn=#{expiresIn} where id=1 ")
    void update(AccessToken token);
}
