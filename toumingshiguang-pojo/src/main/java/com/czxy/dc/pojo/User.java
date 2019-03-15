package com.czxy.dc.pojo;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;

/**
 *
 * @author NINA
 * @date 2019-3-4 8:51:51
 */

@Entity
@Table ( name ="user" )
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {


   	@Column(name = "uid" )
	private Long uid;

   	@Column(name = "username" )
	private String username;

   	@Column(name = "password" )
	private String password;

   	@Column(name = "email" )
	private String email;

   	@Column(name = "phone" )
	private String phone;

}
