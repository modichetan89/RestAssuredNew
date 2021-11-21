package paralllelExecutionSolutionWithDataMap;

import java.util.LinkedHashMap;

public class ThreadLocalDataStoreAsMap {

	private ThreadLocalDataStoreAsMap() {};
	
	private static ThreadLocal<LinkedHashMap<String, Object>> dataMap 
		= ThreadLocal.withInitial(() -> new LinkedHashMap<>());
	//here instead of creating ThreadLocal with Object or String generics
	//we have created ThreadLocal object with LinkedHashMap type.
	//Also we initialized with empty constructor.
	
	public static void setValue(String key, Object value) {
		dataMap.get().put(key, value);
		//Since type of generics is LinkedHashMap
		//we have to use get method of ThreadClass first then add values to hashMap using put method.
		
	}
	
	public static Object getValue(String key) {
		return dataMap.get().get(key);
	}
}
