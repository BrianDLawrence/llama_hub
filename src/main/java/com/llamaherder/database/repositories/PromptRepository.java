package com.llamaherder.database.repositories;

import com.llamaherder.database.domain.Prompt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Brian@SperoAutem.com
 */
@Repository
public interface PromptRepository extends CrudRepository<Prompt, String>{
    
}
