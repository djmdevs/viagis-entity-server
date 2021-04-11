package mz.djm.via.be.util;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

public class Field{

	private String name;
	private Object value;
	private static Map parameters = new HashMap<String, Object>();
	
	private Field(){
	}

	/**
	 * Generate i Field Building
	 * @author Sergio
	 *
	 */
	public static class Builder implements IBuilder<Map<String,Object>>{
		
		private String name;
		private Object value;
		
		/*
		public Builder(String name) {
			this.name = name;
		}
		*/
		public Builder addParameterWithValue(String name, Object value) {
			
			this.name 	= name;
			this.value  = value;
			
			parameters.put(this.name, this.value);
			
			return this;
		}
		
		public Builder withValue(String value) {
			
			this.value = value;
			
			return this;
		}
	
		
		@Override
		public Map<String,Object> build() {
			
			return parameters;
		}
		
		
	}
	
	public String getName() {
		return name;
	}
	
	public Object getValue() {
		return value;
	}
	
}
