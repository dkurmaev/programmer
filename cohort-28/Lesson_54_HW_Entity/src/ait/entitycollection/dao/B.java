package ait.entitycollection.dao;

import ait.entitycollection.interfaces.Entity;
import ait.entitycollection.interfaces.EntityCollection;

import java.util.HashMap;
import java.util.Map;

//Low Add frequency, High Remove Max Value frequency
public class B implements EntityCollection {

	private Map<Integer, Entity> entities;

	public B() {
		entities = new HashMap<>();
	}


	//O(1)
	@Override
	public void add(Entity entity) {
		entities.put(entity.getValue(), entity);
	}


	//O(n)
	@Override
	public Entity removeMaxValue() {
		if (entities.isEmpty()) {
			return null;
		}

		Entity maxEntity = null;
		int maxValue = Integer.MIN_VALUE;

		for (Entity entity : entities.values()) {
			if (entity.getValue() > maxValue) {
				maxEntity = entity;
				maxValue = entity.getValue();
			}
		}

		if (maxEntity != null) {
			entities.remove(maxValue);
		}

		return maxEntity;
	}
}

