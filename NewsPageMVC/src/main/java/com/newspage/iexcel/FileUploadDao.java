package com.newspage.iexcel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.newspage.beans.Sinhvien;

public class FileUploadDao extends BaseDAO{
	
	public boolean saveFileDataInDB(List<Sinhvien> sinhvienList){
		String sql = "insert into sinhvien (MSV, HOTEN, NGAYSINH, LOP, CHUCVU) "
				+ " VALUES (:msv, :hoten, :ngaysinh, :lop, :chucvu)";
		try {
			List<Map<String, String>> batchUpdateParams = new ArrayList<>();

			for(Sinhvien vo : sinhvienList){
				Map<String, String> paramMap = new HashMap<>();
				paramMap.put("msv", vo.getMsv());
				paramMap.put("hoten", vo.getHoten());
				paramMap.put("ngaysinh", vo.getNgaysinh());
				paramMap.put("lop", vo.getLop());
				paramMap.put("chucvu", vo.getChucvu());
				batchUpdateParams.add(paramMap);
			}

			getNamedParamJdbcTemplate().batchUpdate(sql, batchUpdateParams.toArray(new Map[batchUpdateParams.size()] ));

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}