package com.isaac;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;  

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao {
private JdbcTemplate jdbcTemplate;

public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}

// code for jdbc template
/*
 * public int saveEmployee(Employee e){ String
 * query="insert into employees values('"+e.getId()+"','"+e.getName()+"','"+e.
 * getSalary()+"')"; return jdbcTemplate.update(query); } public int
 * updateEmployee(Employee e){ String
 * query="update employees set name='"+e.getName()+"',salary='"+e.getSalary()
 * +"' where id='"+e.getId()+"' "; return jdbcTemplate.update(query); } public
 * int deleteEmployee(Employee e){ String
 * query="delete from employees where id='"+e.getId()+"' "; return
 * jdbcTemplate.update(query); }
 */
// code prepared statement

/*public Boolean saveEmployeeByPreparedStatement(final Employee e){  
    String query="insert into employees values(?,?,?)";  
    return jdbcTemplate.execute(query,new PreparedStatementCallback<Boolean>(){  
    @Override  
    public Boolean doInPreparedStatement(PreparedStatement ps)  
            throws SQLException, DataAccessException {  
              
        ps.setInt(1,e.getId());  
        ps.setString(2,e.getName());  
        ps.setFloat(3,e.getSalary());  
              
        return ps.execute();  
              
    }  
    });  
}  */
// code for ResultSetExtractor

public List<Employee> getAllEmployees(){  
	 return jdbcTemplate.query("select * from employees",new ResultSetExtractor<List<Employee>>(){  
	    @Override  
	     public List<Employee> extractData(ResultSet rs) throws SQLException,  
	            DataAccessException {  
	      
	        List<Employee> list=new ArrayList<Employee>();  
	        while(rs.next()){  
	        Employee e=new Employee();  
	        e.setId(rs.getInt(1));  
	        e.setName(rs.getString(2));  
	        e.setSalary(rs.getInt(3));  
	        list.add(e);  
	        }  
	        return list;  
	        }  
	    });  
	  }  
}
