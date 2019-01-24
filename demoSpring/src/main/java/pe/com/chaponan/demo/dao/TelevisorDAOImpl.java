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
import pe.com.chaponan.demo.bean.TelevisorBean;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;


@Repository
public class TelevisorDAOImpl implements TelevisorDAO{
	
	@Autowired
	DataSource dataSource;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<TelevisorBean> listarTelevisor(String marca, String descripcion) throws Exception {
		List<TelevisorBean> Televisor = new ArrayList<>();
		StringBuffer query = new StringBuffer();
		query.append("select id, marca, descripcion, precio from televisor ");
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
		Televisor = jt.query(query.toString(), params, 
				new BeanPropertyRowMapper(TelevisorBean.class));
		return Televisor;
	}

	@Override
	public int agregarTelevisor(TelevisorBean tv) throws Exception {
		String query = "insert into televisor (marca,descripcion,precio) values(?,?,?)";
		KeyHolder kh = new GeneratedKeyHolder();
		JdbcTemplate jt = new JdbcTemplate(dataSource);
		int done = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement ps = conn.prepareStatement(query, new String[] {"id"});
				ps.setString(1, tv.getMarca());
				ps.setString(2, tv.getDescripcion());
				ps.setDouble(3, tv.getPrecio());
				return ps;
			}
		}, kh);
		
		if (done > 0) {
			return kh.getKey().intValue();
		}
		return 0;
	}

}
