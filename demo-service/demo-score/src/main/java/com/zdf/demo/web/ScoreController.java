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

@Api("����")
@RequestMapping("/score")
@RestController
public class ScoreController {

	@Autowired
	private ScoreMapper scoreMapper;
	
	@ApiOperation(value="��ӻ���")
	@PostMapping("/add")
	public String  insert(Score score) {
		scoreMapper.insert(score);
		return "S";
	}
	
	@ApiOperation("ͨ���û������һ�����ϸ")
	@GetMapping("/findByPersonId")
	public List<Score> findByPersonId(String pid){
		return scoreMapper.findByPersonId(pid);
	}
	
	@ApiOperation("�����û��ܻ���")
	@GetMapping("/findTotalScoreByPersonId")
	public int findTotalScoreByPersonId(String pid) {
		return scoreMapper.findTotalScoreByPersonId(pid);
	}
	
}
