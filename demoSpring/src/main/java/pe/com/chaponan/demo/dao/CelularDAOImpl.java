package pe.com.chaponan.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pe.com.chaponan.demo.bean.CelularBean;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;


@Repository
public class CelularDAOImpl implements CelularDAO{
	
	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<CelularBean> listarCelular(String marca, String descripcion) throws Exception {
		List<CelularBean> celular = new ArrayList<>();
		StringBuffer query = new StringBuffer();
		query.append("select id, marca, descripcion, precio from celular ");
		Object[] params = new Object[0];
		
		marca = (marca == null)? "" : marca;
		descripcion = (descripcion == null)? "" : descripcion;
		
		if (!marca.isEmpty() && !descripcion.isEmpty()) {
			query.append("where UPPER(marca) like UPPER(?) and UPPER(descripcion) like UPPER(?)");
			params = new Object[]{ "%" + marca + "%" , "%" + descripcion  + "%" };
		} else if(!marca.isEmpty() && descripcion.isEmpty()) {
			query.append("where UPPER(marca) like UPPER(?)");
			params = new Object[]{ "%" + marca + "%"};
		} else if(marca.isEmpty() && !descripcion.isEmpty()) {
			query.append("where UPPER(descripcion) like UPPER(?)");
			params = new Object[]{ "%" + descripcion + "%"};
		}
		
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		celular = jt.query(query.toString(), params, 
				new BeanPropertyRowMapper(CelularBean.class));
		return celular;
	}

	@Override
	public int agregarCelular(CelularBean cel) throws Exception {
		String query = "insert into celular (marca,descripcion,precio) values(?,?,?)";
		KeyHolder kh = new GeneratedKeyHolder();
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		int done = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(query, new String[] {"id"});
				ps.setString(1, cel.getMarca());
				ps.setString(2, cel.getDescripcion());
				ps.setDouble(3, cel.getPrecio());
				return ps;
			}
		}, kh);
		
		if (done > 0) {
			return kh.getKey().intValue();
		}
		return 0;
	}

}
