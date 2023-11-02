package com.example.ExampleAPI.security.utils;

import com.example.ExampleAPI.security.model.UserAuth;

public interface JWTAuthImpl {
	UserAuth getCurrentUser();
}
