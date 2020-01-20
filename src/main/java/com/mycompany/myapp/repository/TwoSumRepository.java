package com.mycompany.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mycompany.myapp.domain.TwoSum;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TwoSumRepository extends JpaRepository<TwoSum, Long> {
    @Query("SELECT new com.mycompany.myapp.domain.TwoSum(c.id, c.val) from TwoSum c")
    List<TwoSum> nums();
}
