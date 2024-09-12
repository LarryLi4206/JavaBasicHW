package service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.impl.PositionDataDaoImpl;
import model.PositionData;
import service.PositionService;
import util.ProductLocalDateTime;

public class PositionServiceImpl implements PositionService{

	public static void main(String[] args) {
		/*
		String[] s1=new PositionDaoImpl().choicePosition();
		System.out.println(s1[0]);
		System.out.println(s1[1]);
		System.out.println(s1[2]);
		System.out.println(s1[3]);
		*/
		//new PositionServiceImpl().addPosition("","行銷部");
		
		//System.out.println(new PositionDaoImpl().memberCode("資訊部"));
		
	}
	
	PositionDataDaoImpl positionDataDaoImpl=new PositionDataDaoImpl();
	//建立下拉式選單
	@Override
	public String[] choicePosition() {
		
		List<PositionData> list=new ArrayList();
		list=positionDataDaoImpl.selectPosition();
		//System.out.println(list.get(0).getPosition_name());
		
		String[] list_p=new String[list.size()];
		for(int i=0;i<list.size();i++) {
			list_p[i]=list.get(i).getPosition_name();
		}
		
		return list_p;
	}
	
	//新增職位
	@Override
	public void addPosition(String positionName,String positioncode) {
		/*
		LocalDateTime ldt=LocalDateTime.now();
		String DateTime_login=ldt.
				format(DateTimeFormatter.ofPattern("YYY/MM/dd-HH:mm:ss"))
				.toString();
		*/
		String DateTime_login=ProductLocalDateTime.findLocalDateTime();
		PositionData position=new PositionData();
		position.setPosition_Code(positioncode);
		position.setPosition_name(positionName);
		position.setCreatePositionTime(DateTime_login);
		positionDataDaoImpl.insertPosition(position);
		

	}
	//生成兩碼
	@Override
	public String memberCode(String position) {
		List<PositionData> list_PositionData=positionDataDaoImpl.findPositionCode(position);
		String Id=list_PositionData.get(0).getPosition_Code();
		/*
		System.out.println(Id);
		Integer Id1=list_PositionData.get(0).getId();
		System.out.println(Id1);
		*/
		return Id;
	}

}
