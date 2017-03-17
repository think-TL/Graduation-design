package com.attendance.model;

public class Attendance {
	private int att_id;
	private int att_uid;
	private String att_beizhu;
	private String att_time;

	public int getAtt_id() {
		return att_id;
	}

	public void setAtt_id(int att_id) {
		this.att_id = att_id;
	}

	public int getAtt_uid() {
		return att_uid;
	}

	public void setAtt_uid(int att_uid) {
		this.att_uid = att_uid;
	}

	public String getAtt_beizhu() {
		return att_beizhu;
	}

	public void setAtt_beizhu(String att_beizhu) {
		this.att_beizhu = att_beizhu;
	}

	public String getAtt_time() {
		return att_time;
	}

	public void setAtt_time(String att_time) {
		this.att_time = att_time;
	}

}
