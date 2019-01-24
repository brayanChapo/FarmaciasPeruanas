package pe.com.chaponan.demo.dao;

import java.util.List;

import pe.com.chaponan.demo.bean.TelevisorBean;

public interface TelevisorDAO {
	
	public List<TelevisorBean> listarTelevisor(String marca, String descripcion) throws Exception;
	public int agregarTelevisor(TelevisorBean tv) throws Exception;
	
}
