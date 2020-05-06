package com.zdf.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdf.demo.entity.Score;
import com.zdf.demo.mapper.ScoreMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("积分")
@RequestMapping("/score")
@RestController
public class ScoreController {

	@Autowired
	private ScoreMapper scoreMapper;
	
	@ApiOperation(value="添加积分")
	@PostMapping("/add")
	public String  insert(Score score) {
		scoreMapper.insert(score);
		return "S";
	}
	
	@ApiOperation("通过用户名查找积分详细")
	@GetMapping("/findByPersonId")
	public List<Score> findByPersonId(String pid){
		return scoreMapper.findByPersonId(pid);
	}
	
	@ApiOperation("查找用户总积分")
	@GetMapping("/findTotalScoreByPersonId")
	public int findTotalScoreByPersonId(String pid) {
		return scoreMapper.findTotalScoreByPersonId(pid);
	}
	
}
