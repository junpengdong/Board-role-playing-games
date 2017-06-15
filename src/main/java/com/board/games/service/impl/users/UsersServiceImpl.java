package com.board.games.service.impl.users;

import com.board.games.bean.Users;
import com.board.games.mapper.users.UsersMapper;
import com.board.games.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/6/14.
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public int register(String account, String password, String name, String sex, String age, String mobile, String imgurl) {
        if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password) || StringUtils.isEmpty(name) || StringUtils.isEmpty(mobile)){
            return -1;
        }
        //判断是否账号是否已注册
        Users isUsersEmpty = usersMapper.selectByAccount(account);
        if(isUsersEmpty != null){
            return -2;
        }

        Users users = new Users();
        users.setAccount(account);
        users.setPassword(password);
        users.setName(name);
        users.setSex(sex);
        users.setAge(age);
        users.setMobile(mobile);
        users.setImgurl(imgurl);

        return usersMapper.insert(users);
    }

    @Override
    public Users login(String account, String password) {
        return usersMapper.login(account, password);
    }
}
