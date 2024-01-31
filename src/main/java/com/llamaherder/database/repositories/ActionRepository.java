package com.llamaherder.database.repositories;

import com.llamaherder.database.domain.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Brian@SperoAutem.com
 */
@Repository
public interface ActionRepository extends CrudRepository<Action, Long>{
    
}
