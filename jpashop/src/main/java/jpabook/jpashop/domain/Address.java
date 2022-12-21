package jpabook.jpashop.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(name = "MEMBER_CITY")
    private String city;
    @Column(name = "MEMBER_STREET")
    private String street;
    @Column(name = "MEMBER_ZIPCODE")
    private String zipcode;
}
