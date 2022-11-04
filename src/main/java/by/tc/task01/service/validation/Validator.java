package by.tc.task01.service.validation;

import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Validator
 */
public class Validator {

	/**
	 * @param criteria - criteria to check
	 * @return valid or invalid
	 */
	public static boolean validCriteria(Criteria criteria) {
		return switch (criteria.getGroupSearchName()) {
			case "Teapots" -> doesCriteriaExists(criteria, SearchCriteria.Teapots.class);
			case "Laptop" -> doesCriteriaExists(criteria, SearchCriteria.Laptop.class);
			case "Oven" -> doesCriteriaExists(criteria, SearchCriteria.Oven.class);
			case "Refrigerator" -> doesCriteriaExists(criteria, SearchCriteria.Refrigerator.class);
			case "Speakers" -> doesCriteriaExists(criteria, SearchCriteria.Speakers.class);
			case "TabletPC" -> doesCriteriaExists(criteria, SearchCriteria.TabletPC.class);
			case "VacuumCleaner" -> doesCriteriaExists(criteria, SearchCriteria.VacuumCleaner.class);
			default -> false;
		};
	}

	/**
	 * @param criteria - criteria to check
	 * @param e - enum
	 * @return exist criteria or not
	 */
	private static boolean doesCriteriaExists(Criteria criteria, Class<? extends Enum<?>> e) {
		Set<String> properties = criteria.getCriteria().keySet();
		String[] arr = Arrays.stream(e.getEnumConstants()).map(Enum::toString).toArray(String[]::new);
		return new HashSet<>(Arrays.asList(arr)).containsAll(properties);
	}

}
