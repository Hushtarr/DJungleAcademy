//package com.djungleacademy.security;
//
//import com.djungleacademy.entity.User;
//import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Getter
//@Setter
//@AllArgsConstructor
//
//
//public class CustomUserDetails implements UserDetails {
//    private final String username;
//    private final String password;
//    private final boolean isDeleted;
//    private final Collection<? extends GrantedAuthority> authorities;
//
//    public CustomUserDetails(User user) {
//        this.username = user.getEmail();
//        this.password = user.getPassword();
//        this.isDeleted = user.getIsDeleted(); // 直接在这里处理删除状态
//        this.authorities = List.of(new SimpleGrantedAuthority("ROLE_" + user.getUserType().name()));
//    }
//
//    private boolean isUserDeleted(User user) {
//        // 自定义逻辑来判断用户是否被删除
//        // 例如：通过某种标识来判断
//        return false; // 假设返回 false，表示用户未被删除
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    public boolean isDeleted() {
//        return isDeleted;
//    }
//}
