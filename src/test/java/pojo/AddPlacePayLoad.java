package pojo;

import java.util.List;

public class AddPlacePayLoad {

	private int accuracy;
	private String String;
	private String phone_numberString;
	private String addressString;
	private String websiteString;
	private String languageString;
	private Location location;
	private List<String> type;
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public String getString() {
		return String;
	}

	public void setString(String string) {
		String = string;
	}

	public String getPhone_numberString() {
		return phone_numberString;
	}

	public void setPhone_numberString(String phone_numberString) {
		this.phone_numberString = phone_numberString;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getWebsiteString() {
		return websiteString;
	}

	public void setWebsiteString(String websiteString) {
		this.websiteString = websiteString;
	}

	public String getLanguageString() {
		return languageString;
	}

	public void setLanguageString(String languageString) {
		this.languageString = languageString;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

}
