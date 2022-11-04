package by.tc.task01.dao;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.List;

/**
 * ApplianceDAO Interface
 */
public interface ApplianceDAO {

	/**
	 * @param criteria - criteria to find
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * @param appliances - appliances List
	 */
	void save(List<Appliance> appliances);

	/**
	 * @return Appliance List
	 */
	List<Appliance> loadAll();
}
