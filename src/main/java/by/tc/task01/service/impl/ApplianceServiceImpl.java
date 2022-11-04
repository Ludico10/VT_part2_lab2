package by.tc.task01.service.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.DAOFactory;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.validation.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ApplianceService implementation
 */
public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.validCriteria(criteria)) {
			return null;
		}
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		return applianceDAO.find(criteria);
	}

	@Override
	public void save(List<Appliance> appliances) {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		applianceDAO.save(appliances);
	}

	@Override
	public List<Appliance> getMin(Comparator<Appliance> comparator) {
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		List<Appliance> appliances = applianceDAO.loadAll();
		Appliance min = appliances.stream().min(comparator).orElse(null);
		if (min != null) {
			return appliances.stream()
					.filter(p ->comparator.compare(p, min) == 0)
					.collect(Collectors.toList());
		}
		return null;
	}

}
