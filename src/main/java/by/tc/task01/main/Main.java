package by.tc.task01.main;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria teapotCriteria = new Criteria(SearchCriteria.Teapots.class.getSimpleName());
		appliances = service.find(teapotCriteria);
		if (appliances != null) {
			System.out.println("All kettles: ");
			PrintApplianceInfo.print(appliances);
		}

		//////////////////////////////////////////////////////////////////

		appliances = service.getMin(Comparator.comparing(Appliance::getPrice));
		System.out.println("Appliances with minimal price: ");

		PrintApplianceInfo.print(appliances);
	}

}
