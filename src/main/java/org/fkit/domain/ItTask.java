package org.fkit.domain;

import java.io.Serializable;

public class ItTask implements Serializable {
	private String UNID;
	private String RDept;
	private String Rname_R;
	private String RDateTime;
	private String FDetail;
	private String DName_R;
	private String CDateTime;
	private String Result;
	private String MtGrade;
	private String GradeReason;
	private String ImSt;
	private String TakingTime;
	
//	UNID
	public String getUNID(){ return UNID; }
	public void setUNID( String UNID ){ this.UNID = UNID; }
	
//	RDept
	public String getRDept(){ return RDept; }
	public void setRDept( String RDept ){ this.RDept = RDept; }

//	Rname_R
	public String getRname_R(){ return Rname_R; }
	public void setRname_R( String Rname_R ){ this.Rname_R = Rname_R; }
	
//	RDateTime
	public String getRDateTime(){ return RDateTime; }
	public void setRDateTime( String RDateTime ){ this.RDateTime = RDateTime; }
	
//	FDetail
	public String getFDetail(){ return FDetail; }
	public void setFDetail( String FDetail ){ this.FDetail = FDetail; }
	
//	DName_R
	public String getDName_R(){ return DName_R; }
	public void setDName_R( String DName_R ){ this.DName_R = DName_R; }
	
//	CDateTime
	public String getCDateTime(){ return CDateTime; }
	public void setCDateTime( String CDateTime ){ this.CDateTime = CDateTime; }
	
//	Result
	public String getResult(){ return Result; }
	public void setResult( String Result ){ this.Result = Result; }
	
//	MtGrade
	public String getMtGrade(){ return MtGrade; }
	public void setMtGrade( String MtGrade ){ this.MtGrade = MtGrade; }
	
//	GradeReason
	public String getGradeReason(){ return GradeReason; }
	public void setGradeReason( String GradeReason ){ this.GradeReason = GradeReason; }
	
//	ImSt
	public String getImSt(){ return ImSt; }
	public void setImSt( String ImSt ){ this.ImSt = ImSt; }
	
//	TakingTime
	public String getTakingTime(){ return TakingTime; }
	public void setTakingTime( String TakingTime ){ this.TakingTime = TakingTime; }
	
}
