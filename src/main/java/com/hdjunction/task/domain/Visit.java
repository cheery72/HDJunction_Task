package com.hdjunction.task.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "patient_visit")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Visit extends BaseTime{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_visit_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @CreatedDate
    private LocalDateTime registrationDateTime;

    @Column(name = "visit_status_code", length = 10, nullable = false)
    private String statusCode;

    @Builder
    public Visit(Long id, Hospital hospital, Patient patient, LocalDateTime registrationDateTime, String statusCode) {
        this.id = id;
        this.hospital = hospital;
        this.patient = patient;
        this.registrationDateTime = registrationDateTime;
        this.statusCode = statusCode;
    }
}
