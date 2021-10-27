package kr.or.ddit.service.impl;

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
}