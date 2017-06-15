package com.board.games.controller.users;

import com.board.games.bean.Users;
import com.board.games.exception.BaseRuntimeException;
import com.board.games.service.users.UsersService;
import com.board.games.utils.APIUtil;
import com.board.games.utils.RandomCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RequestMapping("/users")
@Controller
public class UsersController {

    @Autowired
    private UsersService usersService;

    /**
     * 获取验证码
     * @param request
     * @return
     */
    @RequestMapping(value = "/getValiCode", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getValiCode(HttpServletRequest request){
        String code = RandomCode.getValiCode(4);
        //将英文字母存放到session中
        HttpSession session = request.getSession();
        session.setAttribute("checkCode", code);
        //将英文字母存放到Map中返回到前端
        Map<String, Object> map = new HashMap<>();
        map.put("checkCode",code);
        return APIUtil.toMap("00200", true, map);
    }

    /**
     * 用户登陆
     * @param account
     * @param password
     * @param code
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestParam("account")String account,
                                     @RequestParam("password")String password,
                                     @RequestParam("code")String code,
                                     HttpServletRequest request){

        //验证验证码
        HttpSession session = request.getSession();
        String checkCode = session.getAttribute("checkCode").toString();
        if(StringUtils.isEmpty(code)){
            throw new BaseRuntimeException("验证码不能为空");
        }

        if(!checkCode.equals(code)){
            throw new BaseRuntimeException("验证码错误");
        }

        //验证账号、密码
        Users isSuccess = usersService.login(account, password);
        if(isSuccess == null){
            throw new BaseRuntimeException("登陆失败");
        }

        //保存登陆状态
        session.setAttribute("users", isSuccess);
        Map<String, Object> map = new HashMap<>();
        map.put("name", isSuccess.getName());
        return APIUtil.toMap("00200", true, map);
    }

    /**
     * 用户注册
     * @param account
     * @param password
     * @param name
     * @param sex
     * @param age
     * @param mobile
     * @param imgurl
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(@RequestParam("account")String account,
                                        @RequestParam("password")String password,
                                        @RequestParam("name")String name,
                                        @RequestParam("sex")String sex,
                                        @RequestParam("age")String age,
                                        @RequestParam("mobile")String mobile,
                                        @RequestParam(value = "imgurl", required = false)String imgurl){


        int isSuccess = usersService.register(account, password, name, sex, age, mobile, imgurl);
        if(isSuccess == 0){
            return APIUtil.toMap("00400", false);
        }else if(isSuccess == -1){
            throw new BaseRuntimeException("必填项存在空值");
        }else if(isSuccess == -2){
            throw new BaseRuntimeException("账号已被注册");
        }else{
            return APIUtil.toMap("00200", true);
        }
    }

    /**
     * 用户注销
     * @param request
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Map<String, Object> logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("users");
        return APIUtil.toMap("00200", true);
    }

}
