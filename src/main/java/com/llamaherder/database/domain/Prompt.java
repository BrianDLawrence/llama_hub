/*
 * MIT License
 * Prompt 
 */
package com.llamaherder.database.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="actions")
/**
/**
 *
 * @author Brian@SperoAutem.com
 */
public class Prompt {
    
    private String title;
    
    private String prompttext;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "action_id")
    private Action action;
    
}
