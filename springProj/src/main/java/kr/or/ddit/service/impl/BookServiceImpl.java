package kr.or.ddit.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import kr.or.ddit.dao.BookDao;
import kr.or.ddit.service.BookService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
	
	
	private final BookDao bookDao;
	
	@Override
	public String insert(Map<String, Object> map) {
		return this.bookDao.insert(map);
	}
	
	@Override
	public Map<String, Object> select(Map<String, Object> map) {
		return bookDao.select(map);
	}
	
	@Override
	public boolean update(Map<String, Object> map) {
		return bookDao.update(map);
	}
	
	@Override
	public List<Map<String, Object>> selectAll(Map<String, Object> map) {
		return bookDao.selectAll(map);
	}
	
	@Override
	public boolean delete(String bookId) {
		return bookDao.delete(bookId);
	}
}
