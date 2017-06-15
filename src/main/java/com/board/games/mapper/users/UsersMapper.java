package com.board.games.mapper.users;

import java.util.List;

import com.board.games.bean.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersMapper {
    @Delete({
        "delete from t_users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_users (id, account, ",
        "password, name, ",
        "sex, age, mobile, ",
        "imgurl, status)",
        "values (#{id,jdbcType=INTEGER}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{sex,jdbcType=VARCHAR}, #{age,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{imgurl,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR})"
    })
    int insert(Users record);

    @Select({
        "select",
        "id, account, password, name, sex, age, mobile, imgurl, status",
        "from t_users",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgurl", property="imgurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    Users selectByPrimaryKey(Integer id);

    @Select(
        "SELECT * FROM t_users WHERE account = #{account}"
    )

    Users selectByAccount(@Param("account")String account);

    @Select(
        "SELECT * FROM t_users WHERE account = #{account} AND `password` = #{password}"
    )
    Users login(@Param("account")String account, @Param("password")String password);

    @Select({
        "select",
        "id, account, password, name, sex, age, mobile, imgurl, status",
        "from t_users"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="imgurl", property="imgurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<Users> selectAll();

    @Update({
        "update t_users",
        "set account = #{account,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR},",
          "sex = #{sex,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "imgurl = #{imgurl,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);
}