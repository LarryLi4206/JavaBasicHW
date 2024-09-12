package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.PositionDataDao;
import model.PositionData;

public class PositionDataDaoImpl implements PositionDataDao{

	public static void main(String[] args) {
		
		/*
		LocalDate ld=LocalDate.now();
		LocalDateTime ldt=LocalDateTime.now();
		System.out.println(ld);
		System.out.println(ldt.format(DateTimeFormatter.ofPattern("YYY/MM/dd-HH:mm:ss")));
		String DateTime_login=ldt.format(DateTimeFormatter.ofPattern("YYY/MM/dd-HH:mm:ss")).toString();
		PositionData position=new PositionData();
		position.setPosition_Code("OW");
		position.setPosition_name("外勤人員");
		position.setCreatePositionTime(DateTime_login);
		new PositionDataDaoImpl().insertPosition(position);
		*/
		
		/*
		//Position_name下拉式選單OK
		List<PositionData> list=new ArrayList();
		list=new PositionDataDaoImpl().selectPosition();
		System.out.println(list.get(0).getPosition_name());
		
		String[] list_p=new String[list.size()];
		for(int i=0;i<list.size();i++) {
			list_p[i]=list.get(i).getPosition_name();
		}
		
		System.out.println(list_p[1]);
		System.out.println(list_p.length);
		*/
		
		/*有更新
		List<PositionData> list_PositionData=new PositionDataDaoImpl().findPositionId("人事部");
		Integer Id=list_PositionData.get(0).getId();
		System.out.println(Id);
		*/
		
		List<PositionData> list_PositionData=new PositionDataDaoImpl().findPositionCode("外勤人員");
		String Id=list_PositionData.get(0).getPosition_Code();
		System.out.println(Id);
		Integer Id1=list_PositionData.get(0).getId();
		System.out.println(Id1);
		
	}
	
	//新增
	@Override
	public void insertPosition(PositionData position) {
		Connection conn=DbConnection.getDb();
		String sql="insert into positionData "
				+ "(position_Code,position_name,createPositionTime )values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, position.getPosition_Code());
			ps.setString(2, position.getPosition_name());
			ps.setString(3, position.getCreatePositionTime());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//列出全部部門---當做下拉式選單(list)
	@Override
	public List<PositionData> selectPosition() {
		Connection conn=DbConnection.getDb();
		String sql="select position_name from positiondata";
		List<PositionData> list_positionData=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				PositionData positionData=new PositionData();
				positionData.setPosition_name(rs.getString("Position_name"));
				list_positionData.add(positionData);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_positionData;
	}
	
	//查Position_Code(輸入職位名稱)
	@Override
	public List<PositionData> findPositionCode(String positionName) {
		Connection conn = DbConnection.getDb();
		String sql="select * from PositionData where position_name=?";
		List<PositionData> list_positionData=new ArrayList();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, positionName);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				
				PositionData positionData=new PositionData();
				positionData.setId(rs.getInt("id"));
				positionData.setPosition_Code(rs.getString("Position_Code"));
				positionData.setPosition_name(rs.getString("Position_name"));
				positionData.setCreatePositionTime(rs.getString("Position_name"));
				list_positionData.add(positionData);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list_positionData;
	}
	//刪除
	@Override
	public void deletePosition(Integer id) {
		Connection conn = DbConnection.getDb();
		String sql="delete from PositionData where id=?";
		
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	

}
