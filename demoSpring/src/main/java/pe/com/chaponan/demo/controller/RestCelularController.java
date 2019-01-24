package pe.com.chaponan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.chaponan.demo.bean.CelularBean;
import pe.com.chaponan.demo.bean.DataTableBeanCel;
import pe.com.chaponan.demo.service.CelularService;

@Controller
@RequestMapping("/celular/api")
public class RestCelularController {

	@Autowired
	CelularService service;
	
	@RequestMapping(value="records",method=RequestMethod.GET)
	@ResponseBody
	public DataTableBeanCel searchRecords(@RequestParam(name="smarca", required=false) String marca,
			@RequestParam(name = "sdescripcion", required = false) String descripcion) throws Exception {
		
		DataTableBeanCel data = new DataTableBeanCel();
		data.setData(service.listarCel(marca, descripcion));
		return data;
	}
	
	@RequestMapping(value="records",method=RequestMethod.POST)
	@ResponseBody
	public CelularBean addRecords(@RequestBody CelularBean cel) throws Exception {
		System.out.println(cel);
		cel = service.guardarCel(cel);
		return cel;
	}
	
}
