package ru.spb.devpractices.masterbest.serverside.repo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class OrderUserStatusId implements Serializable {

   private String numberIkea;
   private Long userId;

}
