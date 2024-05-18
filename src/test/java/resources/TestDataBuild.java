package resources;

import java.util.ArrayList;
import java.util.List;


import pojo.AddPlacePayLoad;

public class TestDataBuild {
	
	
	public AddPlacePayLoad addPlacePAyload(String name, String address) {
		
		
	AddPlacePayLoad	 addPlacePayLoad=new AddPlacePayLoad();
	
	addPlacePayLoad.setAccuracy(60);
	addPlacePayLoad.setAddressString(address);
	addPlacePayLoad.setLanguageString("Bangla");
	addPlacePayLoad.setPhone_numberString("1234567890");
	addPlacePayLoad.setName(name);
	addPlacePayLoad.setWebsiteString("https://google.com");
	List <String> list=new ArrayList<String>();
	list.add("shoe park");
	list.add("Shop");
	addPlacePayLoad.setType(list);
	
	pojo.Location location=new pojo.Location();
	location.setLat(-38.383494);
	location.setLng(33.42762);
	
	addPlacePayLoad.setLocation(location);
	
	return addPlacePayLoad;
		
	}
	
	
	public String deletePayload(String place_id) {
		
		return "{\n"
				+ "    \"place_id\":\""+place_id+"\"\n"
				+ "}";
	}

}
