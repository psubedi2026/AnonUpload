package com.theironyard.novauc.entities;

import javax.persistence.*;

/**
 * Created by psubedi2020 on 3/20/17.
 */
@Entity
@Table(name = "files")
public class AnonFile {

  @Id
  @GeneratedValue
  int id;

  @Column(nullable = false)
  String filename;

  @Column(nullable = false)
  String originalFilename;

  public AnonFile() {
  }

  public  AnonFile(String filename, String originalFilename) {
     this.filename = filename;
     this.originalFilename = originalFilename;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }
}
