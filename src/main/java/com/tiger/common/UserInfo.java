package com.tiger.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.IOException;
import java.io.Serializable;

@Setter
@Getter
public class UserInfo implements Serializable {

    @JsonProperty(value = "id_user")
    private Long userId;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "mobile")
    private String mobile;

    @JsonProperty(value = "team")
    private String team;

    @JsonProperty(value = "avatar")
    private String avatar;

}
