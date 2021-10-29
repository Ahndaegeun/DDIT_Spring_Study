package kr.or.ddit.vo;

import java.sql.Date;

import lombok.*;

@Getter
@Setter
@ToString
public class BookVO {
	private int BOOK_ID;
	private String TITLE;
	private String CATEGORY;
	private int PRICE;
	private Date INSERT_DATE;
}
