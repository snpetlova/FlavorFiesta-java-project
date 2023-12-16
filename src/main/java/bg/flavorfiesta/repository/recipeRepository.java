package bg.flavorfiesta.repository;

import bg.flavorfiesta.model.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface recipeRepository extends JpaRepository<RecipeEntity, Long> {
}
