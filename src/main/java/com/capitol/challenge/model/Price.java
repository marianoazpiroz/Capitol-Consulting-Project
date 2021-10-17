package com.capitol.challenge.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PRICES")
public class Price implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	private Long brand_id;
	private String start_date;
	private String end_date;
    private Integer price_list; 
    private Long product_id;
    private Integer priority;
    private Double price;
    private String curr;

    public Price() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Integer getPrice_list() {
		return price_list;
	}

	public void setPrice_list(Integer price_list) {
		this.price_list = price_list;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCurr() {
		return curr;
	}

	public void setCurr(String curr) {
		this.curr = curr;
	}

	@Override
	public String toString() {
		return "Price [id=" + id + ", brand_id=" + brand_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", price_list=" + price_list + ", product_id=" + product_id + ", priority=" + priority + ", price="
				+ price + ", curr=" + curr + "]";
	}
    
	
}
