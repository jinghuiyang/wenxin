package com.youzhong.service;

import com.youzhong.entity.AccessToken;

public interface AccessTokenService {
    AccessToken getToken();

    void update(AccessToken token);

    void insert(AccessToken token);
}
