package com.board.games.mapper.game;

import java.util.List;

import com.board.games.bean.GameLaunch;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface GameLaunchMapper {
    @Delete({
        "delete from t_game_launch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_game_launch (id, user_id, ",
        "game_type_id, game_id, ",
        "person_num, begin_time, ",
        "end_time, status)",
        "values (#{id,jdbcType=INTEGER}, #{userId,jdbcType=VARCHAR}, ",
        "#{gameTypeId,jdbcType=VARCHAR}, #{gameId,jdbcType=VARCHAR}, ",
        "#{personNum,jdbcType=VARCHAR}, #{beginTime,jdbcType=TIMESTAMP}, ",
        "#{endTime,jdbcType=TIMESTAMP}, #{status,jdbcType=VARCHAR})"
    })
    int insert(GameLaunch record);

    @Select({
        "select",
        "id, user_id, game_type_id, game_id, person_num, begin_time, end_time, status",
        "from t_game_launch",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_type_id", property="gameTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_num", property="personNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    GameLaunch selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, user_id, game_type_id, game_id, person_num, begin_time, end_time, status",
        "from t_game_launch"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_type_id", property="gameTypeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="game_id", property="gameId", jdbcType=JdbcType.VARCHAR),
        @Result(column="person_num", property="personNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="begin_time", property="beginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_time", property="endTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<GameLaunch> selectAll();

    @Update({
        "update t_game_launch",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "game_type_id = #{gameTypeId,jdbcType=VARCHAR},",
          "game_id = #{gameId,jdbcType=VARCHAR},",
          "person_num = #{personNum,jdbcType=VARCHAR},",
          "begin_time = #{beginTime,jdbcType=TIMESTAMP},",
          "end_time = #{endTime,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(GameLaunch record);
}