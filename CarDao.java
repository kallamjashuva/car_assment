package com.test.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CarDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			con=DBConnectionHandler.getConnection();
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	public static int save(Car c){
		int status=0;
		try{
			Connection con=CarDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into carDetails(Company  ,Model  ,Color  ,Dateofpurchase   ,Price  ,EngineCapacity   ,LicencePlateNumber  ,SeatingCapacity ) values (?,?,?,?,?,?,?,?)");
			ps.setString(1,c.getCompany());
			ps.setString(2,c.getModel());
			ps.setString(3,c.getColor());
			ps.setString(4,c.getDateofpurchase());
			ps.setString(5,c.getPrice());
			ps.setString(6,c.getEngineCapacity());
			ps.setString(7,c.getLicencePlateNumber());
			ps.setString(8,c.getSeatingCapacity());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int update(Car c){
		int status=0;
		try{
			Connection con=CarDao.getConnection();
			PreparedStatement ps=con.prepareStatement("update carDetails set Company=?    ,Color=?  ,Dateofpurchase =?  ,Price=?  ,EngineCapacity=?   ,LicencePlateNumber=?  ,SeatingCapacity=? where Model=?=?");
			ps.setString(1,c.getCompany());
			ps.setString(2,c.getColor());
			ps.setString(3,c.getDateofpurchase());
			ps.setString(4,c.getPrice());
			ps.setString(5,c.getEngineCapacity());
			ps.setString(6,c.getLicencePlateNumber());
			ps.setString(7,c.getSeatingCapacity());
			ps.setString(8,c.getModel());
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	public static int delete(String Model){
		int status=0;
		try{
			Connection con=CarDao.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from carDetails where Model=?");
			ps.setString(1,Model);
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return status;
	}
	public static Car getCarByModel(String Model){
		Car e=new Car();
		
		try{
			Connection con=CarDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from carDetails where Model=?");
			ps.setString(1,Model);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				
				e.setCompany(rs.getString(1));
				e.setModel(rs.getString(2));
				e.setColor(rs.getString(3));
				e.setDateofpurchase(rs.getString(4));
				e.setPrice(rs.getString(5));
				e.setEngineCapacity(rs.getString(6));
				e.setLicencePlateNumber(rs.getString(7));
				e.setSeatingCapacity(rs.getString(8));
				
			}
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return e;
	}
	public static List<Car> getAllCars(){
		List<Car> list=new ArrayList<Car>();
		
		try{
			Connection con=CarDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from carDetails");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Car e=new Car();
				e.setCompany(rs.getString(1));
				e.setModel(rs.getString(2));
				e.setColor(rs.getString(3));
				e.setDateofpurchase(rs.getString(4));
				e.setPrice(rs.getString(5));
				e.setEngineCapacity(rs.getString(6));
				e.setLicencePlateNumber(rs.getString(7));
				e.setSeatingCapacity(rs.getString(8));
				list.add(e);
			}
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}
}