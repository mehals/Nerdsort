package com.mehal.nerdsort.managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mehal.nerdsort.dao.NerdsortDao;
import com.mehal.nerdsort.types.UserVote;

public class VoteManager {
	@Autowired
	private NerdsortDao nerdsortDao;
	
	public VoteManager(NerdsortDao nerdsortDao) {
		this.nerdsortDao = nerdsortDao;
	}
	
	public void storeVotesFromJson(String jsonVote, int userId) {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			@SuppressWarnings("unchecked")
			Map<String, List<Integer>> map = mapper.readValue(jsonVote, Map.class);
			List<UserVote> userVotes = new ArrayList<UserVote>();
			
			for(String listId : map.keySet()) {
				UserVote userVote = new UserVote();
				userVote.setUserId(userId);
				userVote.setListId(Integer.parseInt(listId));
				userVote.setUserOrdering(mapper.writeValueAsString(map.get(listId)));
				userVotes.add(userVote);
			}
			
			nerdsortDao.storeVotes(userVotes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
