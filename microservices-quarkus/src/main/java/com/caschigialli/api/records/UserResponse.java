package com.caschigialli.api.records;

import java.util.Set;

public record UserResponse(String username, Set<String> roles) { }

