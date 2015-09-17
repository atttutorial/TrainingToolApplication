package com.course;

import java.util.Date;

public class Course {

	private int cid,courseRoleId;
	private String cname;
	private int cminDuration;
	private int cmaxDuration;
	private String cauthor;
	private String fileName;
	private Date COURSEDATE;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCminDuration() {
		return cminDuration;
	}
	public void setCminDuration(int cminDuration) {
		this.cminDuration = cminDuration;
	}
	public int getCmaxDuration() {
		return cmaxDuration;
	}
	public void setCmaxDuration(int cmaxDuration) {
		this.cmaxDuration = cmaxDuration;
	}
	public String getCauthor() {
		return cauthor;
	}
	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Date getCOURSEDATE() {
		return COURSEDATE;
	}
	public void setCOURSEDATE(Date cOURSEDATE) {
		COURSEDATE = cOURSEDATE;
	}
	public int getCourseRoleId() {
		return courseRoleId;
	}
	public void setCourseRoleId(int courseRoleId) {
		this.courseRoleId = courseRoleId;
	}

}
