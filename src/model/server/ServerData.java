package model.server;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class ServerData {
	Map<String, String> map = new HashMap<String, String>();
	
	public void setDictionary(String userName, String hostID, String port, String connectionStatus, String level) {
		map.put("userName", userName);
		map.put("hostId",hostID);
		map.put("port",port);
		map.put("connectionStatus",connectionStatus);
		map.put("userLevel", level);
		
	}
	
	public Map<String, String> getDictionary(){
		
		return map;
	}
}
