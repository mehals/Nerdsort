package com.mehal.nerdsort.dao;

import java.util.List;

import com.mehal.nerdsort.types.OrderableList;
import com.mehal.nerdsort.types.SortableItem;
import com.mehal.nerdsort.types.UserVote;

public interface NerdsortDao {
	public List<OrderableList> getAllLists();

	public SortableItem getItemForId(int itemId);

	public OrderableList getListForId(int listId);

	public void storeVotes(List<UserVote> votes);

	public List<UserVote> getVotesForUser(int userid);
}
