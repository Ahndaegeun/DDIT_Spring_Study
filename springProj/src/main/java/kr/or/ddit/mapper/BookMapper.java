package kr.or.ddit.mapper;

import java.util.Map;


public interface BookMapper {
	Map<String, Object> select(Map<String, Object> map);
}