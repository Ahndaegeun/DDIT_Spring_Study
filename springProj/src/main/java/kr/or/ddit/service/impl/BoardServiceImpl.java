package kr.or.ddit.service.impl;

import org.springframework.stereotype.Service;

import kr.or.ddit.service.BoardService;
import kr.or.ddit.vo.MemberVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	private final BoardDAO boardDao;
	
	@Override
	public int insertMemberHobby(MemberVO vo) {
		int result = 0;
		
		result = boardDao.insertMember(vo);
		
		if(result > 0) {
			boardDao.insertHobby(vo);
		}
		
		return 0;
	}
}
