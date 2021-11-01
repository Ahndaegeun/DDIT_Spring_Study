package kr.or.ddit.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.dao.ProductDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductDAO productDAO;
	
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> list = productDAO.findAll();
		
		for (Map<String, Object> map : list) {
			map.put("P_DESCRIPTION", clobToString(map));
		}
		
		return list;
	}

	public Map<String, Object> findOne(String id) throws SQLException, IOException {
		Map<String, Object> map = productDAO.findOne(id);
		map.put("P_DESCRIPTION", clobToString(map));
		
		return map;
	}
	
	private String clobToString(Map<String, Object> map) {
		StringBuffer strOut = new StringBuffer();
		String description = "";
		Clob object = (Clob)map.get("P_DESCRIPTION");
		BufferedReader br;
		try {
			br = new BufferedReader(object.getCharacterStream());
			while((description = br.readLine()) != null) {
				strOut.append(description);
			}
		} catch (SQLException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return strOut.toString();
	}

	public void update(Map<String, Object> map) {
		productDAO.update(map);
	}

	public void delete(String id) {
		productDAO.delete(id);
	}
}
