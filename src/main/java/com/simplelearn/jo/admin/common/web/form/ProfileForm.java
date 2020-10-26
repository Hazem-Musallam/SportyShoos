package com.simplelearn.jo.admin.common.web.form;

import com.simplelearn.jo.admin.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfileForm {
	private String username;
	private String oldPassword;
	private String newPassword;

	public ProfileForm(User user) {
		this(user.getUsername(), user.getPassword(), null);
	}
}