package in.vijai.onlinebookstore.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * 
 * @author vijai
 * 
 * Entity Class => Maps the data from the table.
 * 
 * getter,setter,toString annotations are from lambock library, used to skip getters,setters.
 *
 */
@Entity
@Table(name="tbl_book")
@Getter
@Setter
@ToString
public class Book {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;   //Primary key,generated automatically
	
	private String sku;    //column name and variable name are same, so no need to map
	
	private String name;
	
	private String description;
	
	@Column(name="unit_price")
	private BigDecimal unitPrice;
	
	@Column(name="image_url")
	private String imageUrl;
	
	private boolean active;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	
	@Column(name="date_created")
	private Date createdAt;
	
	@Column(name="last_updated")
	private Date updatedAt;
	
	@ManyToOne
	@JoinColumn(name="category_id",nullable=false)
	private BookCategory category;
	
}
