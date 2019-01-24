package pe.com.chaponan.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.chaponan.demo.bean.CelularBean;
import pe.com.chaponan.demo.dao.CelularDAO;

@Service
public class CelularServiceImpl implements CelularService{
	
	@Autowired
	CelularDAO celularDAO;
	
	@Override
	public List<CelularBean> listarCel(String marca, String descripcion) throws Exception {
		List<CelularBean> lista = celularDAO.listarCelular(marca, descripcion);
		return lista;
	}

	@Override
	public CelularBean guardarCel(CelularBean cel) throws Exception {
		int id = celularDAO.agregarCelular(cel);
		if(id>0) {
			cel.setId(id);
			return cel;
		}
		return null;
	}

}
