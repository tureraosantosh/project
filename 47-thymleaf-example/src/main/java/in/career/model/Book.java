package in.career.model;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Book {

	private Integer bookId;
	private String bookName;
	private Integer bookPrice;
	private String author;

}
