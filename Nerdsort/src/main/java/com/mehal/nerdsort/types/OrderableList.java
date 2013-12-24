package com.mehal.nerdsort.types;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "item_lists")
public class OrderableList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7440417144271147341L;

	@Column(name = "list_name")
	private String listTitle;

	@OneToMany(mappedBy = "orderableList", fetch = FetchType.EAGER)
	private List<SortableItem> items;

	@Transient
	private List<SortableItem> userSortedItems;

	@Id
	@GeneratedValue
	@Column(name = "list_id")
	private int listId;

	public OrderableList() {

	}

	public OrderableList(int listId, String listTitle, List<SortableItem> items) {
		this.listId = listId;
		this.listTitle = listTitle;
		this.items = items;
	}

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	public String getListTitle() {
		return listTitle;
	}

	public void setListTitle(String listTitle) {
		this.listTitle = listTitle;
	}

	public List<SortableItem> getItems() {
		Collections.sort(items);
		return this.items;
	}

	public void setItems(List<SortableItem> items) {
		this.items = items;
	}

	public List<SortableItem> getUserSortedItems() {
		return userSortedItems;
	}

	public void setUserSortedItems(List<SortableItem> userSortedItems) {
		this.userSortedItems = userSortedItems;
	}
}
