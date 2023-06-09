package com.capstone.smutaxi.entity;


import com.capstone.smutaxi.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity // 이 클래스는 데이터베이스의 테이블과 1:1매핑되는 객체다라고 명시 ORM (Object Relation Mapping)
@Getter @Setter
@Table(name="users") //table 이름이 user가 될 수 없음 그래서 네임 따로 지정해준다
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User implements UserDetails {

    //email ID primary key
    @Id
    @Column(name = "email")
    private String email;

    @Column(length = 300, nullable = false)
    private String password;

    //닉네임
    @Column(name = "name")
    private String name;

    //프로필 사진 경로
    @Column(name = "img_path")
    private String imgPath;

    //성별
    @Column(name = "gender")
    private Gender gender;

    //역할기반제어를 위한 roles필드 (Spring Security)
    @ElementCollection(fetch = FetchType.EAGER) //roles 컬렉션
    @Builder.Default
    private List<String> roles = new ArrayList<>();



    @Override   //사용자의 권한 목록 리턴
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }




}
