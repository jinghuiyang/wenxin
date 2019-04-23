package com.youzhong.service.impl;

import com.youzhong.dao.AccessTokenMapper;
import com.youzhong.entity.AccessToken;
import com.youzhong.service.AccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessTokenServiceImpl implements AccessTokenService {
    @Autowired
    private AccessTokenMapper accessTokenMapper;

    @Override
    public AccessToken getToken() {
        List<AccessToken> list = accessTokenMapper.gettoken();
        if (list.size() > 0 && list != null) {
          return list.get(0);
        }
        return null;
    }

    @Override
    public void update(AccessToken token) {
        accessTokenMapper.update(token);
    }

    @Override
    public void insert(AccessToken token) {
        accessTokenMapper.insert(token);
    }
}
