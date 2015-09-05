package com.gavin.sanyuandb.model;

import java.sql.Timestamp;

public class Products {
	
	private int id;
	private int mid;
	private String pdesc;
	private String icon;
	private String pic;
	private String video;
	private Timestamp createtime;

	public Products() {
	}

	public Products(int mid, String pdesc, String icon, String pic, String video, Timestamp createtime) {
		this.mid = mid;
		this.pdesc = pdesc;
		this.icon = icon;
		this.pic = pic;
		this.video = video;
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "Products{" +
				"id=" + id +
				", mid=" + mid +
				", pdesc='" + pdesc + '\'' +
				", icon='" + icon + '\'' +
				", pic='" + pic + '\'' +
				", video='" + video + '\'' +
				", createtime=" + createtime +
				'}';
	}
}
