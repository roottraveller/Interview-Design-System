package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.GroupEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, String> {
}
