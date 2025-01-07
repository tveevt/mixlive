package com.example.mixlive.jpa;

import com.example.mixlive.model.PlatformType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "platform_category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlatformCategory {
    @Id
    @Enumerated(EnumType.STRING)
    @Column(name = "platform_type")
    private PlatformType platformType;
    @Column(name = "json_content", columnDefinition = "longtext")
    private String jsonContent;


}
