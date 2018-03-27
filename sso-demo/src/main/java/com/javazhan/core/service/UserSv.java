package com.javazhan.core.service;

import com.javazhan.core.dao.mapper.TUserMapper;
import com.javazhan.core.model.dto.TUser;
import com.javazhan.core.model.pojo.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 9:33 2018/3/27
 * @Modified By:
 */
public interface UserSv {
    public ResponseData checkData(String param, int type);
    public ResponseData createUser(TUser user);
}
