package com.abnamro.recipe.repositories;

import com.abnamro.recipe.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>, JpaSpecificationExecutor<Recipe> {
    @Modifying
    @Query("DELETE FROM Recipe r WHERE r.id = :id")
    int deleteByIdReturning(@Param("id") Integer id);
}