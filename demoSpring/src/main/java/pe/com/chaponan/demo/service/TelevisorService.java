package pe.com.chaponan.demo.service;

import java.util.List;

import pe.com.chaponan.demo.bean.TelevisorBean;

public interface TelevisorService {
	
	public List<TelevisorBean> listarTv(String marca, String descripcion) throws Exception;
	public TelevisorBean guardarTv(TelevisorBean tv) throws Exception;
}
