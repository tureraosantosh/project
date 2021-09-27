package in.career.entity;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Cities {
private Long id;
private String name;
private Long stateId;

}
