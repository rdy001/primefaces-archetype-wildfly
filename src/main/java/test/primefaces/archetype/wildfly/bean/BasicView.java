package test.primefaces.archetype.wildfly.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named("basicView")
@ViewScoped
public class BasicView implements Serializable {
// private static final long serialVersionUID = 1L;   
 
    private String text1;

    private String text2;

    private String text3;

    private String text4;

    private String text5;

    private int number;

    private Map<String,Map<String,String>> data = new HashMap<String, Map<String,String>>();

    private String country;  
    
    private String city;

    private Map<String,String> countries;

	private Map<String,String> cities;
    
    @PostConstruct
    public void init() {
        countries  = new HashMap<String, String>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");
        
        Map<String,String> map = new HashMap<String, String>();
		map.put("New York", "New York");
		map.put("San Francisco", "San Francisco");
		map.put("Denver", "Denver");
        data.put("USA", map);
        
        map = new HashMap<String, String>();
		map.put("Berlin", "Berlin");
		map.put("Munich", "Munich");
		map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);
        
        map = new HashMap<String, String>();
        map.put("Sao Paulo", "Sao Paulo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);
    }

    public void increment() {
        number++;
    }
    
    public void handleKeyEvent() {
        text5 = text5.toUpperCase();
    }

    public String getText1() {
        return text1;
    }
    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }
    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }

    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }

    public int getNumber() {
        return number;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void onCountryChange() {
		if(country !=null && !country.equals(""))
			cities = data.get(country);
		else
			cities = new HashMap<String, String>();
	}
    
    public void displayLocation() {
        FacesMessage msg;
        if(city != null && country != null)
            msg = new FacesMessage("Selected", city + " of " + country);
        else
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is not selected."); 
            
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
