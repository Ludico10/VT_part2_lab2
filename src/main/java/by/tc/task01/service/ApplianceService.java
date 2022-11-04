package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

/**
 *ApplianceService interface
 */
public interface ApplianceService {

	/**
	 * @param criteria - criteria for search
	 * @return list of appliances
	 */
	List<Appliance> find(Criteria criteria);

	/**
	 * @param appliances - list to save
	 */
	void save(List<Appliance> appliances);

	/**
	 * @param comparator - comparator to search
	 * @return list of minimum appliances
	 */
	List<Appliance> getMin(Comparator<Appliance> comparator);
}
