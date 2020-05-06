package com.zdf.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.zdf.demo.entity.Score;

@Mapper
public interface ScoreMapper {

	@Insert("insert into t_score values(#{id},#{userid},#{orderid},#{scorenum})")
	public void insert(Score score);
	
	@Select("select *from t_score where userid=#{pid}")
	public List<Score> findByPersonId(String pid);

	@Select("select sum(scorenum) from t_score where userid=#{pid}")
	public int findTotalScoreByPersonId(String pid);
}
