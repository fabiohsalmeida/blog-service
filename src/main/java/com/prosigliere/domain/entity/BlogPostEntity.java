package com.prosigliere.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blog_posts")
public class BlogPostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "blogPost")
    private List<CommentEntity> comments;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;
}
