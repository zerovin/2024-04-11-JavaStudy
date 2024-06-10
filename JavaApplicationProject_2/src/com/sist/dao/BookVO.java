package com.sist.dao;
import java.util.*;
import lombok.Data;
@Data
public class BookVO {
	private int num;
	private String bookname, writer, translator;
	private int price;
	private Date publdate;
	private String series;
}

