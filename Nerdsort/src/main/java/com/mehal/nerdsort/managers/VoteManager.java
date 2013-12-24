package com.mehal.nerdsort.managers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.mehal.nerdsort.dao.NerdsortDao;
import com.mehal.nerdsort.types.OrderableList;
import com.mehal.nerdsort.types.SortableItem;
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
			Map<String, List<Integer>> map = mapper.readValue(jsonVote,
					Map.class);
			List<UserVote> userVotes = new ArrayList<UserVote>();

			for (String listId : map.keySet()) {
				UserVote userVote = new UserVote();
				userVote.setUserId(userId);
				userVote.setListId(Integer.parseInt(listId));
				userVote.setUserOrdering(mapper.writeValueAsString(map
						.get(listId)));
				userVotes.add(userVote);
			}

			nerdsortDao.storeVotes(userVotes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<OrderableList> getVoteForUser(int userId) {
		List<UserVote> votes = nerdsortDao.getVotesForUser(userId);
		List<OrderableList> allLists = nerdsortDao.getAllLists();
		Map<Integer, UserVote> voteMap = new HashMap<Integer, UserVote>();
		List<OrderableList> userOrderingOfLists = new ArrayList<OrderableList>();
		ObjectMapper mapper = new ObjectMapper();

		for (UserVote vote : votes) {
			voteMap.put(vote.getListId(), vote);
		}

		for (OrderableList list : allLists) {
			List<SortableItem> defaultOrdering = list.getItems();
			List<SortableItem> newOrdering = new ArrayList<SortableItem>();
			Map<Integer, SortableItem> itemsInList = new HashMap<Integer, SortableItem>();

			for (SortableItem item : defaultOrdering) {
				itemsInList.put(item.getItemId(), item);
			}

			try {
				@SuppressWarnings("unchecked")
				List<String> ordering = mapper.readValue(
						voteMap.get(list.getListId()).getUserOrdering(),
						List.class);

				for (String order : ordering) {
					newOrdering.add(itemsInList.get(Integer.parseInt(order)));
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			list.setUserSortedItems(newOrdering);
			userOrderingOfLists.add(list);
		}

		return userOrderingOfLists;
	}
}
