package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * ApplianceDAO implementation
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	private static final String path = "src/main/resources/appliances_db.xml";

	@Override
	public List<Appliance> find(Criteria criteria) {
		List<Appliance> foundAppliances = new ArrayList<>();
		try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))) {
			Appliance appliance = (Appliance)decoder.readObject();
			while (appliance != null) {
				try {
					if (respond(appliance, criteria)) {
						foundAppliances.add(appliance);
					}
				} catch (NoSuchFieldException e) {
					System.out.println(e.getMessage());
				}
				appliance = (Appliance)decoder.readObject();
			}
		}
		catch (ArrayIndexOutOfBoundsException ignored) {}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return foundAppliances;
	}

	@Override
	public void save(List<Appliance> appliances) {
		try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(path)))){
			for(Appliance appliance : appliances){
				encoder.writeObject(appliance);
			}
		}
		catch (FileNotFoundException e){
			System.out.println(e.getMessage());
		}
	}

	@Override
	public List<Appliance> loadAll() {
		List<Appliance> appliances = new ArrayList<>();
		try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(path)))){
			Appliance result = (Appliance)decoder.readObject();
			while(result != null) {
				appliances.add(result);
				result = (Appliance)decoder.readObject();
			}
		}
		catch (ArrayIndexOutOfBoundsException ignored) {}
		catch(FileNotFoundException e){
			System.out.println(e.getMessage());
		}
		return appliances;
	}

	private boolean respond(Appliance appliance, Criteria criteria) throws IllegalAccessException, NoSuchFieldException {
		if (!appliance.getClass().getSimpleName().equals(criteria.getGroupSearchName())) {
			return false;
		}
		Set<String> properties = criteria.getCriteria().keySet();
		for (String property : properties) {
			Field field = null;
			try {
				field = appliance.getClass().getDeclaredField(property);
			} catch (NoSuchFieldException e) {
				System.out.println(e.getMessage());
			}
			assert field != null;
			field.setAccessible(true);
			Object fieldValue = field.get(appliance);
			if (!fieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
				return false;
			}
		}
		for (String property : properties) {
			Field parentField = appliance.getClass().getSuperclass().getDeclaredField(property);
			parentField.setAccessible(true);
			Object parentFieldValue = parentField.get(appliance);
			if (!parentFieldValue.toString().equals(criteria.getCriteria().get(property).toString())) {
				return false;
			}
		}
		return true;
	}

}
