package pe.com.chaponan.demo.service;

import java.util.List;

import pe.com.chaponan.demo.bean.CelularBean;

public interface CelularService {
	
	public List<CelularBean> listarCel(String marca, String descripcion) throws Exception;
	public CelularBean guardarCel(CelularBean cel) throws Exception;
}
