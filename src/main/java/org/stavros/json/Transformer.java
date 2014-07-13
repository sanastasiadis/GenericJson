package org.stavros.json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Transformer {
	public static String toJson(Object obj) {
		StringBuffer sb = new StringBuffer();
		
		if (obj instanceof String) {
			sb.append('"').append(obj).append('"');
		}
		else if (obj instanceof Integer
				|| obj instanceof Double
				|| obj instanceof Float
				|| obj instanceof Short
				|| obj instanceof Long) {
			sb.append(obj);
		}
		else {
			System.out.println("Calling toJson method for a type of: " + obj.getClass().toString());
			List<String> fields = new ArrayList<String>();
			for (Field f: obj.getClass().getDeclaredFields()) {
				StringBuilder sbField = new StringBuilder();
				f.setAccessible(true);
				sbField.append(f.getName()).append(": ");
				try {
					sbField.append(toJson(f.get(obj)));
				}
				catch(IllegalAccessException iae) {
					System.out.println("Illegal access exception for jsonizing value of field: " + f.getName() + ", " + iae.getMessage());
					sbField.append("");
				}
				fields.add(sbField.toString());
			}
			sb.append('{').append(StringUtils.join(fields, ',')).append('}');
		}
		return sb.toString();
	}
}
