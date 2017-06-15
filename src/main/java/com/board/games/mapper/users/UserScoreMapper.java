package com.board.games.mapper.users;

import java.util.List;

import com.board.games.bean.UserScore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreMapper {
    @Delete({
        "delete from t_user_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into t_user_score (id, partake_id, ",
        "evaluate_user_id, be_evaluated_user_id, ",
        "score, msg)",
        "values (#{id,jdbcType=INTEGER}, #{partakeId,jdbcType=VARCHAR}, ",
        "#{evaluateUserId,jdbcType=VARCHAR}, #{beEvaluatedUserId,jdbcType=VARCHAR}, ",
        "#{score,jdbcType=VARCHAR}, #{msg,jdbcType=VARCHAR})"
    })
    int insert(UserScore record);

    @Select({
        "select",
        "id, partake_id, evaluate_user_id, be_evaluated_user_id, score, msg",
        "from t_user_score",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="partake_id", property="partakeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_user_id", property="evaluateUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="be_evaluated_user_id", property="beEvaluatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg", property="msg", jdbcType=JdbcType.VARCHAR)
    })
    UserScore selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, partake_id, evaluate_user_id, be_evaluated_user_id, score, msg",
        "from t_user_score"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="partake_id", property="partakeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="evaluate_user_id", property="evaluateUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="be_evaluated_user_id", property="beEvaluatedUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="score", property="score", jdbcType=JdbcType.VARCHAR),
        @Result(column="msg", property="msg", jdbcType=JdbcType.VARCHAR)
    })
    List<UserScore> selectAll();

    @Update({
        "update t_user_score",
        "set partake_id = #{partakeId,jdbcType=VARCHAR},",
          "evaluate_user_id = #{evaluateUserId,jdbcType=VARCHAR},",
          "be_evaluated_user_id = #{beEvaluatedUserId,jdbcType=VARCHAR},",
          "score = #{score,jdbcType=VARCHAR},",
          "msg = #{msg,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserScore record);
}