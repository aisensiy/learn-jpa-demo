package com.example.learnjpa.first.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id;
  private String username;
  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "province", column = @Column(name = "address_province")),
      @AttributeOverride(name = "city", column = @Column(name = "address_city")),
      @AttributeOverride(name = "street", column = @Column(name = "address_street")),
      @AttributeOverride(name = "detail", column = @Column(name = "address_detail"))
  })
  private Address address;

  public User(String username, Address address) {
    this.username = username;
    this.address = address;
  }
}
