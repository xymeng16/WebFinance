package entity;

import java.util.Map;

public class ToBorrow {
    private String username;
    private String title;
    private String rate;
    private String target;
    private String calculationway;
    private String waytoback;
    private String time;
    private String description;
    private String institution;
    private String date;
    private String enddate;
    private int id;
//    
	public ToBorrow() {
		super();
	}
	public ToBorrow(Map<String, Object> map){
		this.username = (String) map.get("USERNAME");
		this.title = (String) map.get("TITLE");
		this.rate = (String) map.get("RATE");
		this.target = (String) map.get("TARGET");
		this.calculationway = (String) map.get("CALCULATIONWAY");
		this.waytoback = (String) map.get("WAYTOBACK");
		this.time = (String) map.get("TIME");
		this.description = (String) map.get("DESCRIPTION");
		this.institution = (String) map.get("INSTITUTION");
		this.id  =  (Integer) map.get("ID");
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getCalculationway() {
		return calculationway;
	}
	public void setCalculationway(String calculationway) {
		this.calculationway = calculationway;
	}
	public String getWaytoback() {
		return waytoback;
	}
	public void setWaytoback(String waytoback) {
		this.waytoback = waytoback;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
    
	
}
