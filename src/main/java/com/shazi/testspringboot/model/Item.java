package com.shazi.testspringboot.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="items")

public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="itemId")
	private int itemId;
	private int price;
	private String description;
	private String brand;


}
