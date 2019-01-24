package pe.com.chaponan.demo.bean;

import java.io.Serializable;
import java.util.List;

public class DataTableBeanTv implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<TelevisorBean> data;

	public List<TelevisorBean> getData() {
		return data;
	}

	public void setData(List<TelevisorBean> data) {
		this.data = data;
	}
	
}
