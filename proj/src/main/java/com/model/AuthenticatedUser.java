package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthenticatedUser extends User implements UserDetails {
    private String token;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthenticatedUser(int id, String username, String password, String email, String token, Collection<? extends GrantedAuthority> authorities){
        super(username, password, email,"");
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.authorities = authorities;
        this.email = email;
    }
    @JsonIgnore
    public int getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return true;
    }

    public String getToken() {
        return token;
    }
}
