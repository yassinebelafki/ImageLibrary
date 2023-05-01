package com.first.entity;

import java.security.PublicKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "files")
@Table(name = "files")
public class Files {
	
	@Id
	@Column(name = "id")
	int id;
	
	@Column(name = "file_name")
	String fileName;
	
	@Column(name = "label")
	String label;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	@Column(name = "caption")
	String caption;

	public Files(String fileName, String label, String caption) {
		this.fileName = fileName;
		this.label = label;
		this.caption = caption;
	}
	
	public Files(String fileName) {
		this.fileName = fileName;
	}
	
	
	@Override
	public String toString() {
		return "Files [id=" + id + ", fileName=" + fileName + ", label=" + label + ", caption=" + caption + "]";
	}

	public Files() {
		
	}
	
	

}
