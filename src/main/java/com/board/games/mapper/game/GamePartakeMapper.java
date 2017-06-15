package com.board.games.mapper.game;

import java.util.List;

import com.board.games.bean.GamePartake;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface GamePartakeMapper {
    @Delete({
        "delete from t_game_partake",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_game_partake (id, user_id, ",
        "launch_id, partake_time, ",
        "status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
        "#{launchId,jdbcType=VARCHAR}, #{partakeTime,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(GamePartake record);

    @Select({
        "select",
        "id, user_id, launch_id, partake_time, status",
        "from t_game_partake",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="launch_id", property="launchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="partake_time", property="partakeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    GamePartake selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, launch_id, partake_time, status",
        "from t_game_partake"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="launch_id", property="launchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="partake_time", property="partakeTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<GamePartake> selectAll();

    @Update({
        "update t_game_partake",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "launch_id = #{launchId,jdbcType=VARCHAR},",
          "partake_time = #{partakeTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GamePartake record);
}