package com.board.games.service.users;

import com.board.games.bean.Users;

/**
 * Created by Administrator on 2017/6/14.
 */
public interface UsersService {

    int register(String account, String password, String name, String sex, String age, String mobile, String imgurl);

    Users login(String account, String password);

}
