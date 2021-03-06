package kr.or.ddit.service;

import java.util.List;
import java.util.Map;

public interface BookService {

	String insert(Map<String, Object> map);
	
	Map<String, Object> select(Map<String, Object> map);
	
	boolean update(Map<String, Object> map);

	List<Map<String, Object>> selectAll(Map<String, Object> map);

	boolean delete(String bookId);
}
