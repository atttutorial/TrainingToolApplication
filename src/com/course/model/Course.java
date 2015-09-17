package com.course.model;

public class Course {

	int cid,cmin,cmax;
	String cauthor,cfileName,cname,courseRoleId;
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCmin() {
		return cmin;
	}
	public void setCmin(int cmin) {
		this.cmin = cmin;
	}
	public int getCmax() {
		return cmax;
	}
	public void setCmax(int cmax) {
		this.cmax = cmax;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	public String getCfileName() {
		return cfileName;
	}
	public void setCfileName(String cfileName) {
		this.cfileName = cfileName;
	}
	public String getCourseRoleId() {
		return courseRoleId;
	}
	public void setCourseRoleId(String courseRoleId) {
		this.courseRoleId = courseRoleId;
	}
	

}
