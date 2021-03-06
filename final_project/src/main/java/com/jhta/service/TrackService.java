package com.jhta.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhta.dao.Track_Dao;
import com.jhta.dto.Track_Dto;

@Service
public class TrackService {
	
	@Autowired Track_Dao trackDao;
	
	public List<Track_Dto> searchTrack(HashMap<String, String> searchMap) {
		List<Track_Dto> result = trackDao.search(searchMap);
		return result;
	}
	
	public int getSearchRow(String keyword){
		int rowCount = trackDao.getSearchRow();
		return rowCount;
	}
}
