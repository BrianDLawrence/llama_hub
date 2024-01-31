/*
 * MIT License
 */
package com.llamaherder.database;

import com.llamaherder.database.domain.Action;
import com.llamaherder.database.domain.Prompt;

/**
 *
 * @author Bobuk
 */
public class TestDataUtil {
        private TestDataUtil(){
    }

    public static Action createTestActionA() {
        return Action.builder()
                .id(1L)
                .name("Optimize Schedule")
                .description("Goal to optimize the user's TODOs and Meetings")
                .build();
    }

    public static Action createTestActionB() {
        return Action.builder()
                .id(2L)
                .name("Review Emails")
                .description("Goal to review emails")
                .build();
    }

    public static Action createTestActionC() {
        return Action.builder()
                .id(3L)
                .name("Check for Birthdays")
                .description("Check to make sure I don't miss important birthdays")
                .build();
    }

    public static Prompt createTestPromptA(final Action action) {
        return Prompt.builder()
                .title("Expert Scheduler Instructions")
                .prompttext("You are an expert scheduler, take the list of todos and meetings and organize")
                .action(action)
                .build();
    }

    public static Prompt createTestPromptB(final Action action) {
        return Prompt.builder()
                .title("Email Reviewer Instructions")
                .prompttext("You are an expert email reviewer, review these emails and mark ones that I should care about")
                .action(action)
                .build();
    }

    public static Prompt createTestPromptC(final Action action) {
        return Prompt.builder()
                .title("Birthday Checkler")
                .prompttext("Review my calendar and social media, and let me know if anyone close to me has a birthday today.")
                .action(action)
                .build();
    }
}
