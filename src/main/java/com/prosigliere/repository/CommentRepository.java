package com.prosigliere.repository;

import com.prosigliere.domain.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
}
