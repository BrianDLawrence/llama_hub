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
public class PromptRepostitoryIntegrationTests {
    
    private PromptRepository underTest;

    @Autowired
    public PromptRepostitoryIntegrationTests(PromptRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatPromptCanBeCreatedAndRecalled() {
        Action action = TestDataUtil.createTestActionA();
        Prompt prompt = TestDataUtil.createTestPromptA(action);
        underTest.save(prompt);
        Optional<Prompt> result = underTest.findById(prompt.getTitle());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(prompt);
    }

    @Test
    public void testThatMultiplePromptsCanBeCreatedAndRecalled() {
        Action action = TestDataUtil.createTestActionA();

        Prompt promptA = TestDataUtil.createTestPromptA(action);
        underTest.save(promptA);
        
        Prompt promptB = TestDataUtil.createTestPromptB(action);
        underTest.save(promptB);
        
        Prompt promptC = TestDataUtil.createTestPromptC(action);
        underTest.save(promptC);

        Iterable<Prompt> result = underTest.findAll();
        assertThat(result)
                .hasSize(3)
                .containsExactly(promptA, promptB, promptC);
    }
    
    @Test
    public void testThatPromptCanBeUpdated() {
        Action action = TestDataUtil.createTestActionA();

        Prompt promptA = TestDataUtil.createTestPromptA(action);
        underTest.save(promptA);

        promptA.setTitle("UPDATED");
        underTest.save(promptA);

        Optional<Prompt> result = underTest.findById(promptA.getTitle());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(promptA);
        assertThat(result.get().getTitle()).isEqualTo("UPDATED");
    }

    @Test
    public void testThatPromptCanBeDeleted() {
        Action action = TestDataUtil.createTestActionA();
        Prompt promptA = TestDataUtil.createTestPromptA(action);
        underTest.save(promptA);
 
        underTest.deleteById(promptA.getTitle());
                
        Optional<Prompt> result = underTest.findById(promptA.getTitle());
        assertThat(result).isEmpty();
    }
}
