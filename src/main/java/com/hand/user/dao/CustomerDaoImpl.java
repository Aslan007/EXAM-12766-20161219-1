package com.hand.user.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Date;

import com.hand.dbutil.DbUtil;
import com.hand.user.bean.Customer;

public class CustomerDaoImpl implements CustomerDao{

	public void addCustomer(Customer customer) {
		
		int StoreId = customer.getStoreId();
		String first_name = customer.getFirstName();
		String last_name = customer.getLastName();
		String email =  customer.getEmail();
		int  addressId = customer.getAddressId();
		Boolean active =  customer.getActive();
		Date createDate = customer.getCreateDate();
		Date last_update = customer.getLastUpdate();
		//不能单独更加用户
		String sql = "insert into customer(customer_id,store_id,first_name,last_name,email,address_id,active,create_date,last_update) values( null,"+StoreId+","+first_name+","+last_name+","+email+","+addressId+","+active+","+createDate+","+last_update+","+")";
		
		Connection conn = null;
		conn = DbUtil.getConnection();
		 try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);//执行
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	public static void main(String[] args) throws ParseException
	{
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		Customer c = new Customer();
		c.setFirstName("MARY");
		System.out.println("chauxn chu de :"+cdi.queryCustomer(c));
	}

	public Customer queryCustomer(Customer customer) {
		String first_name = customer.getFirstName();
		String sql = "select * from customer where first_name = '"+first_name+"'";
		System.out.println("sql===="+sql);
		Connection conn = null;
		conn = DbUtil.getConnection();
		 Customer customer2 = new Customer();
		 try {
			Statement stmt = conn.createStatement();
			 ResultSet rs =stmt.executeQuery(sql);//执行
			 while(rs.next()){
				 customer2.setStoreId(rs.getInt("store_id"));
				 customer2.setFirstName(rs.getString("first_name"));
				 customer2.setLastName(rs.getString("last_name"));
				 customer2.setEmail(rs.getString("email"));
				 customer2.setActive(rs.getBoolean("active"));
				 customer2.setAddressId(rs.getInt("address_id"));
				 customer2.setCreateDate(rs.getDate("create_date"));
				 customer2.setLastUpdate(rs.getDate("last_update"));
				 customer2.setCustomerId(rs.getInt("customer_id"));
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	return customer2;	
	}

}
