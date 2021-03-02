package ru.spb.devpractices.masterbest.serverside.repo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class OrderUserStatusId implements Serializable {

   private String order;
   private Long user;

}
