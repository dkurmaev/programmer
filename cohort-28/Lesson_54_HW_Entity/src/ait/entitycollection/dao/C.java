package ait.entitycollection.dao;
//Case C (Medium Add frequency, Medium Remove Max Value frequency)

import ait.entitycollection.interfaces.Entity;
import ait.entitycollection.interfaces.EntityCollection;

import java.util.HashMap;
import java.util.Map;

public class C implements EntityCollection {
	private Map<Integer, Entity> entities;

	public C() {
		entities = new HashMap<>();
	}
	@Override
	public void add(Entity entity) {
		entities.put(entity.getValue(), entity);
	}

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