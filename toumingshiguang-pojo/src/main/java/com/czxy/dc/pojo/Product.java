package com.czxy.dc.pojo;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

/**
 *
 * @author NINA
 * @date 2019-3-6 8:45:56
 */

@Entity
@Table ( name ="product" )
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
   	@Column(name = "product_id" )
	private Long productId;

   	@Column(name = "product_name" )
	private String productName;

   	@Column(name = "product_newprice" )
	private Long productNewprice;

   	@Column(name = "product_oldprice" )
	private Long productOldprice;

   	@Column(name = "jifen" )
	private Long jifen;

   	@Column(name = "kucun" )
	private Long kucun;

   	@Column(name = "number" )
	private Long number;

   	@Column(name = "image" )
	private String image;
	@Column(name = "sid" )
   	private Integer sid;
	@Column(name = "xl" )
	private Integer xl;
	private Shop shop;


}
