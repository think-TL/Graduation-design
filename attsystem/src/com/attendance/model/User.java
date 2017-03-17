package com.attendance.model;

public class User {
	private int u_id;
	private int u_userid;
	private String u_name;
	private String u_password;
	private String u_sex;
	private int u_phone;
	private String u_address;
	private int u_quanxian;
	private String u_job;
	private String u_email;
	private int u_QQ;
	private int d_id;

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public int getU_userid() {
		return u_userid;
	}
	public void setU_userid(int u_userid) {
		this.u_userid = u_userid;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}


	public String getU_sex() {
		return u_sex;
	}

	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}

	public int getU_phone() {
		return u_phone;
	}

	public void setU_phone(int u_phone) {
		this.u_phone = u_phone;
	}

	public int getU_QQ() {
		return u_QQ;
	}

	public void setU_QQ(int u_QQ) {
		this.u_QQ = u_QQ;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}

	public int getU_quanxian() {
		return u_quanxian;
	}

	public void setU_quanxian(int u_quanxian) {
		this.u_quanxian = u_quanxian;
	}

	public String getU_job() {
		return u_job;
	}

	public void setU_job(String u_job) {
		this.u_job = u_job;
	}

	public String getU_email() {
		return u_email;
	}

	public void setU_email(String u_email) {
		this.u_email = u_email;
	}

	public int getD_id() {
		return d_id;
	}

	public void setD_id(int d_id) {
		this.d_id = d_id;
	}

}
