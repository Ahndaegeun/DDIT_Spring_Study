package kr.or.ddit.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductVO {
	
	private String P_ID;
	private String p_NAME;
	private int P_UNITPRICE;
	private String P_DESCRIPTION;
	private String P_CATEGORY;
	private String P_MANUFACTURER;
	private int P_UNITSINSTOCK;
	private String P_CONDITION;
	private String P_FILENAME;
}
