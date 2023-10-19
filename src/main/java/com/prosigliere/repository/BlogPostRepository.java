package com.prosigliere.repository;

import com.prosigliere.domain.entity.BlogPostEntity;
import org.springframework.data.repository.CrudRepository;

public interface BlogPostRepository extends CrudRepository<BlogPostEntity, Long> {
}
