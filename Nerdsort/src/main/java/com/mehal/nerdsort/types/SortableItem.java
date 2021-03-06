package com.mehal.nerdsort.types;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SORTABLE_ITEMS")
public class SortableItem implements Serializable, Comparable<SortableItem> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 525756092023751490L;

	@Id
	@Column(name = "ITEM_ID", nullable = false)
	private int itemId;

	@Column(name = "IMAGE_URL", nullable = false)
	private String imageUrl;

	@Column(name = "ITEM_NAME", nullable = false)
	private String name;

	@Column(name = "POSITION", nullable = false)
	private int position;

	@ManyToOne
	@JoinColumn(name = "list_id")
	private OrderableList orderableList;

	public SortableItem() {

	}

	public SortableItem(String name, String imageUrl) {
		this.imageUrl = imageUrl;
		this.name = name;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderableList getOrderableList() {
		return orderableList;
	}

	public void setOrderableList(OrderableList orderableList) {
		this.orderableList = orderableList;
	}

	@Override
	public int compareTo(SortableItem that) {
		return com.google.common.collect.ComparisonChain.start()
				.compare(this.position, that.position)
				.compare(this.itemId, that.itemId).result();
	}

	public String toString() {
		return name;
	}
}
