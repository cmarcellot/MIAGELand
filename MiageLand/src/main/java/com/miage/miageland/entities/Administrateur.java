package com.miage.miageland.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("administrateur")
@Data
@NoArgsConstructor
public class Administrateur extends Employe {

}


