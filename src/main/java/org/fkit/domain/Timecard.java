package org.fkit.domain;

public class Timecard {
	private String Name;
	private String DateStr;
	private String PJCode;
	private String PJName;
	private int PlanHour;
	private int Hour;
	
//	Name
	public String getName(){ return Name; }
	public void setName( String Name ){ this.Name = Name; }
	
//	DateStr
	public String getDateStr(){ return DateStr; }
	public void setDateStr( String DateStr ){ this.DateStr = DateStr; }
	
//	PJCode
	public String getPJCode(){ return PJCode; }
	public void setPJCode( String PJCode ){ this.PJCode = PJCode; }
	
//	PJName
	public String getPJName(){ return PJName; }
	public void setPJName( String PJName ){ this.PJName = PJName; }
	
//	PlanHour
	public int getPlanHour(){ return PlanHour; }
	public void setPlanHour( int PlanHour ){ this.PlanHour = PlanHour; }
	
//	Hour
	public int getHour(){ return Hour; }
	public void setHour( int Hour ){ this.Hour = Hour; }
	
}
