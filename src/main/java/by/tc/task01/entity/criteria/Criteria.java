package by.tc.task01.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * Criteria class
 */
public class Criteria {

	private final String groupSearchName;
	private final Map<String, Object> criteria = new HashMap<>();

	public Criteria(String groupSearchName) {
		this.groupSearchName = groupSearchName;
	}

	/**
	 * @return groupSearchName
	 */
	public String getGroupSearchName() {
		return groupSearchName;
	}

	/**
	 * @param searchCriteria - criteria to search
	 * @param value - correspond object
	 */
	public void add(String searchCriteria, Object value) {
		criteria.put(searchCriteria, value);
	}

	/**
	 * @return criteria set
	 */
	public Map<String, Object> getCriteria() {
		return criteria;
	}

}
