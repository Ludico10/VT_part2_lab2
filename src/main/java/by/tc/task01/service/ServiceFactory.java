package by.tc.task01.service;

import by.tc.task01.service.impl.ApplianceServiceImpl;

/**
 * Factory for service
 */
public final class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final ApplianceService applianceService = new ApplianceServiceImpl();
	
	private ServiceFactory() {}

	/**
	 * @return ApplianceService
	 */
	public ApplianceService getApplianceService() {
		return applianceService;
	}

	/**
	 * @return ServiceFactory
	 */
	public static ServiceFactory getInstance() {
		return instance;
	}

}
