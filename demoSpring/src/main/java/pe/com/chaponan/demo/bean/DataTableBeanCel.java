package pe.com.chaponan.demo.bean;

import java.io.Serializable;
import java.util.List;

public class DataTableBeanCel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<CelularBean> data;

	public List<CelularBean> getData() {
		return data;
	}

	public void setData(List<CelularBean> data) {
		this.data = data;
	}
	
	
}
