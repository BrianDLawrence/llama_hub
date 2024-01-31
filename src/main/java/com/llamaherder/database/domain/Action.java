/*
 * MIT License
 * Action
 */
package com.llamaherder.database.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
 *
 * @author Brian@SperoAutem.com
 */
public class Action {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "action_id_seq")
    private Long id;
    
    private String name;
    
    private String description;
    
}
