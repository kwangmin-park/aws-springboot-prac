package com.prac.aws.springboot.awsspringbootprac.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


//@MappedSuperclass : BaseTimeEntity 를 상속할 경우 createdDate, modifiedDate도 컬럼으로 인식하게 한다.
//@EntityListeners(AuditingEntityListener.class) : Auditing 기능 포함 시킨다.
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
//    Entity가 생성되어 저장될 때 시간이 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
