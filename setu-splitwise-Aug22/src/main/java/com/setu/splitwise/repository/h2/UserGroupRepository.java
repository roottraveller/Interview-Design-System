package com.setu.splitwise.repository.h2;

import com.setu.splitwise.model.entity.UserGroupEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupRepository extends CrudRepository<UserGroupEntity, String> {

    @Query(nativeQuery = true, name = "get_user_all_groups")
    List<String> getUserGroupList(String userId);

}
