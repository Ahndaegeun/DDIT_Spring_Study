package kr.or.ddit.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BookDao {

	private final SqlSessionTemplate sqlSessionTemplate;
	
	public String insert(Map<String, Object> map) {
		int result = this.sqlSessionTemplate.insert("book.insert", map);
		
		if(result > 0) {
			return map.get("bookId") + "";			
		}
		return null;
	}
	
	public Map<String, Object> select(Map<String, Object> map) {
		 return this.sqlSessionTemplate.selectOne("book.select", map);
	}
}
