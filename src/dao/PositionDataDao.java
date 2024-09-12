package dao;

import java.util.List;

import model.PositionData;

public interface PositionDataDao {
	//新增職位
	void insertPosition(PositionData position);
	
	//查職位ID
	List<PositionData> findPositionCode(String positionName);
	
	//刪除職位
	void deletePosition(Integer id);
	
	//列出全部部門
	List<PositionData> selectPosition();
	
	
	
}
