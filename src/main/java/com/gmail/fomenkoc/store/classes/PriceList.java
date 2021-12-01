package com.gmail.fomenkoc.store.classes;

public class PriceList {
	private int plid;
	private String plName;

	public PriceList(int plid, String plName) {
		super();
		this.plid = plid;
		this.plName = plName;
	}

	public int getPlid() {
		return plid;
	}

	public void setPlid(int plid) {
		this.plid = plid;
	}

	public String getPlName() {
		return plName;
	}

	public void setPlName(String plName) {
		this.plName = plName;
	}

	@Override
	public String toString() {
		return "PriceList [plid=" + plid + ", plName=" + plName + "]";
	}

}
