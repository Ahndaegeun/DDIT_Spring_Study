package kr.or.ddit.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
	private final SqlSessionTemplate sqlSessionTemplate;
	
	public List<Map<String, Object>> findAll() {
		return sqlSessionTemplate.selectList("product.findAll");
	}

	public Map<String, Object> findOne(String id) {
		return sqlSessionTemplate.selectOne("product.findOne", id);
	}
	
	public boolean save(Map<String, Object> map) {
		return sqlSessionTemplate.insert("product.save", map) > 0;
	}

	public void update(Map<String, Object> map) {
		sqlSessionTemplate.update("product.update", map);
	}

	public void delete(String id) {
		sqlSessionTemplate.delete("product.delete", id);
	}
}
