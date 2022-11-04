package by.tc.task01.service;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Comparator;
import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria);
	void save(List<Appliance> appliances);
	List<Appliance> getMin(Comparator<Appliance> comparator);
}
