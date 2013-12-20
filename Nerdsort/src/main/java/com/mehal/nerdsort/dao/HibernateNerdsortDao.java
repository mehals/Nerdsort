package com.mehal.nerdsort.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mehal.nerdsort.types.OrderableList;
import com.mehal.nerdsort.types.SortableItem;

@Transactional
public class HibernateNerdsortDao implements NerdsortDao {
	private SessionFactory sessionFactory;
	
	@Autowired
	public HibernateNerdsortDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public SortableItem getItemForId(int itemId) {
		return (SortableItem) (getCurrentSession().get(SortableItem.class, itemId));
	}
	
	@Override
	public OrderableList getListForId(int listId) {
		return (OrderableList) (getCurrentSession().get(OrderableList.class, listId));
	}

	@Override
	public List<OrderableList> getAllLists() {
		return getCurrentSession().createQuery("from OrderableList").list();
	}

}
