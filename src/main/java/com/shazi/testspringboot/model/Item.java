package com.shazi.testspringboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="items")

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	private int price;
	private String description;
	private String brand;


}
