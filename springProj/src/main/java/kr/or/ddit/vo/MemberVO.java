package kr.or.ddit.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private String memId;
	private String memName;
	private String[] hobbyList;
	private AddressVO addressVO;
	private List<CardVO> cardList;
}
