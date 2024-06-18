package com.sist.dao;
import java.util.*;
import lombok.Data;
@Data
public class BookVO {
	private int num;
	private long isbn;
	private String bookname, writer, translator;
	private int price;
	private Date pubdate;
	private String image;
	private String series;
	private int hit;
}

