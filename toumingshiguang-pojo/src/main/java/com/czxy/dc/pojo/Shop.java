package com.czxy.dc.pojo;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

/**
 *
 * @author NINA
 * @date 2019-3-6 8:45:26
 */

@Entity
@Table ( name ="shop" )
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Shop {

	@Id
   	@Column(name = "sid" )
	private Long sid;

   	@Column(name = "shop_name" )
	private String shopName;

   	@Column(name = "shop_address" )
	private String shopAddress;

   	@Column(name = "shop_phone" )
	private String shopPhone;

   	@Column(name = "shop_price" )
	private Long shopPrice;

   	@Column(name = "shop_image" )
	private String shopImage;
   	private List<Product> products;

}
