/*
 * MIT License
 */
package com.llamaherder.database.repositories;

import com.llamaherder.database.TestDataUtil;
import com.llamaherder.database.domain.Action;
import com.llamaherder.database.domain.Prompt;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author Brian@SperoAutem.com
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ActionRepositoryIntegrationTests {
    
    private ActionRepository underTest;

    @Autowired
    public ActionRepositoryIntegrationTests(ActionRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatActionCanBeCreatedAndRecalled() {
        Action action = TestDataUtil.createTestActionA();
        underTest.save(action);
        Optional<Action> result = underTest.findById(action.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(action);
    }   
    
        @Test
    public void testThatActionsCanBeCreatedAndRecalled() {
        Action actionA = TestDataUtil.createTestActionA();
        underTest.save(actionA);
        
        Action actionB = TestDataUtil.createTestActionB();
        underTest.save(actionB);

        Action actionC = TestDataUtil.createTestActionC();
        underTest.save(actionC);

        Iterable<Action> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(actionA, actionB, actionC);
    }
    
     @Test
    public void testThatActionCanBeUpdated() {
        Action actionA = TestDataUtil.createTestActionA();
        underTest.save(actionA);
        actionA.setName("UPDATED");
        underTest.save(actionA);
        Optional<Action> result = underTest.findById(actionA.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(actionA);
        assertThat(result.get().getName()).isEqualTo("UPDATED");
    }
}
