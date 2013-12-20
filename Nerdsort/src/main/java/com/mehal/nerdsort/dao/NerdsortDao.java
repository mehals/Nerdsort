package com.mehal.nerdsort.dao;

import java.util.List;

import com.mehal.nerdsort.types.*;

public interface NerdsortDao {	
	public List<OrderableList> getAllLists();
	
	public SortableItem getItemForId(int itemId);

	public OrderableList getListForId(int listId);
}
