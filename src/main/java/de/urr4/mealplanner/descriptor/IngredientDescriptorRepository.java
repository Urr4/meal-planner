package de.urr4.mealplanner.descriptor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDescriptorRepository extends JpaRepository<IngredientDescriptorEntity, Long> {
}
