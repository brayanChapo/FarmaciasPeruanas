package pe.com.chaponan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.chaponan.demo.bean.TelevisorBean;
import pe.com.chaponan.demo.dao.TelevisorDAO;

@Service
public class TelevisorServiceImpl implements TelevisorService{
	
	@Autowired
	TelevisorDAO televisorDAO;
	
	@Override
	public List<TelevisorBean> listarTv(String marca, String descripcion) throws Exception {
		List<TelevisorBean> lista = televisorDAO.listarTelevisor(marca, descripcion);
		return lista;
	}

	@Override
	public TelevisorBean guardarTv(TelevisorBean tv) throws Exception {
		int id = televisorDAO.agregarTelevisor(tv);
		if(id>0) {
			tv.setId(id);
			return tv;
		}
		return null;
	}

}
