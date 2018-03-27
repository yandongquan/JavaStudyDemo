package com.javazhan.core.service.impl;

import com.google.gson.Gson;
import com.javazhan.core.dao.mapper.TUserMapper;
import com.javazhan.core.model.dto.TUser;
import com.javazhan.core.model.dto.TUserExample;
import com.javazhan.core.model.pojo.ResponseData;
import com.javazhan.core.service.UserSv;
import com.javazhan.utils.Md5EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yandq
 * @Description:
 * @Date: Create in 9:34 2018/3/27
 * @Modified By:
 */
@Service("userSv")
public class UserSvImpl implements UserSv {

    @Autowired
    private TUserMapper userMapper;

    @Override
    public ResponseData checkData(String param, int type) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        // 根据查询条件动态生成 1、2、3 分别代表 username、phone、email
        if (type==1) {
            criteria.andUserNameEqualTo(param);
        } else if (type==2) {
            criteria.andPhoneEqualTo(param);
        } else if (type==3) {
            criteria.andEmailEqualTo(param);
        } else {
            return new ResponseData("4444","非法的参数",null);
        }

        List<TUser> list = userMapper.selectByExample(example);

        if (list==null||list.size()==0) {
            return new ResponseData("9999","未查到任何信息",null);
        }
        return new ResponseData("0000","success", new Gson().toJson(list.get(0)));
    }

    @Override
    public ResponseData createUser(TUser user) {
        // 密码要进行 MD5 加密。
        String md5Pass = Md5EncryptUtil.encryptToMD5(user.getPassword());
        user.setPassword(md5Pass);
        // 把用户信息插入到数据库中。
        userMapper.insert(user);
        // 返回
        return new ResponseData("0000","success", null);
    }
}
