package com.mehal.nerdsort.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mehal.nerdsort.types.OrderableList;
import com.mehal.nerdsort.types.SortableItem;
import com.mehal.nerdsort.types.UserVote;

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
		return (SortableItem) (getCurrentSession().get(SortableItem.class,
				itemId));
	}

	@Override
	public OrderableList getListForId(int listId) {
		return (OrderableList) (getCurrentSession().get(OrderableList.class,
				listId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderableList> getAllLists() {
		return getCurrentSession().createQuery("from OrderableList").list();
	}

	@Override
	public void storeVotes(List<UserVote> votes) {
		for (UserVote vote : votes) {
			getCurrentSession().save(vote);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserVote> getVotesForUser(int userId) {
		// TODO Auto-generated method stub
		Criteria criteria = getCurrentSession().createCriteria(UserVote.class)
				.add(Restrictions.eq("userId", userId));

		return criteria.list();
	}
}
