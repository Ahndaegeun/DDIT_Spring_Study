package kr.or.ddit.service;

import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public interface BookService {

	String insert(Map<String, Object> map);
	
	Map<String, Object> select(Map<String, Object> map);
}
