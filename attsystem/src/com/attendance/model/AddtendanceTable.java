package com.attendance.model;

public class AddtendanceTable {
	private int sys_id;
	private int sys_departid;
	private String sys_starttime;
	private String sys_endtime;

	public int getSys_id() {
		return sys_id;
	}

	public void setSys_id(int sys_id) {
		this.sys_id = sys_id;
	}

	public int getSys_departid() {
		return sys_departid;
	}

	public void setSys_departid(int sys_departid) {
		this.sys_departid = sys_departid;
	}

	public String getSys_starttime() {
		return sys_starttime;
	}

	public void setSys_starttime(String sys_starttime) {
		this.sys_starttime = sys_starttime;
	}

	public String getSys_endtime() {
		return sys_endtime;
	}

	public void setSys_endtime(String sys_endtime) {
		this.sys_endtime = sys_endtime;
	}
}
