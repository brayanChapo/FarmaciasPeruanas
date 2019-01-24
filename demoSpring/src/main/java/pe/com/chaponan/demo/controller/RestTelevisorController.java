package pe.com.chaponan.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.chaponan.demo.bean.DataTableBeanTv;
import pe.com.chaponan.demo.bean.TelevisorBean;
import pe.com.chaponan.demo.service.TelevisorService;

@Controller
@RequestMapping("/televisor/api")
public class RestTelevisorController {

	@Autowired
	TelevisorService service;
	
	@RequestMapping(value="records",method=RequestMethod.GET)
	@ResponseBody
	public DataTableBeanTv searchRecords(@RequestParam(name="smarca", required=false) String marca,
			@RequestParam(name = "sdescripcion", required = false) String descripcion) throws Exception {
		
		DataTableBeanTv data = new DataTableBeanTv();
		data.setData(service.listarTv(marca, descripcion));
		return data;
	}
	
	@RequestMapping(value="records",method=RequestMethod.POST)
	@ResponseBody
	public TelevisorBean addRecords(@RequestBody TelevisorBean tv) throws Exception {
		System.out.println(tv);
		tv = service.guardarTv(tv);
		return tv;
	}
	
	
}
