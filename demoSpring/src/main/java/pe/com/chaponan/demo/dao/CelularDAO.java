package pe.com.chaponan.demo.dao;

import java.util.List;

import pe.com.chaponan.demo.bean.CelularBean;

public interface CelularDAO {
	
	public List<CelularBean> listarCelular(String marca, String descripcion) throws Exception;
	public int agregarCelular(CelularBean cel) throws Exception;
	
}
