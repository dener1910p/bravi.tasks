package com.example.bravi.tasks.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tasks",uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
public class Tasks {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long id;

	@Column(name = "task")
	private String task;

	@Column(name = "comments")
	private String comments;
	
	@Column(name = "dtcreation")
	private Date dtcreation;
	
	@Column(name = "dtexecution")
	private Date dtexecution;
	
	@Column(name = "dtfinalization")
	private Date dtfinalization;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "spendedtime")
	private String spendedtime;

	public Tasks() {

	}

	public Tasks(String comments, Date dtexecution, Date dtfinalization, String status,
			String spendedtime) {
		super();

		this.comments = comments;
		this.dtexecution = dtexecution;
		this.dtfinalization = dtfinalization;
		this.status = status;
		this.spendedtime = spendedtime;
	}
	
	public Tasks(String taskTitle, String comments, Date dtcreation, Date dtexecution ,String status) {
		super();
		this.task = taskTitle;
		this.comments = comments;
		this.dtcreation = dtcreation;
		this.dtexecution = dtexecution;
		this.status = "open";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getDtcreation() {
		return dtcreation;
	}

	public void setDtcreation(Date dtcreation) {
		this.dtcreation = dtcreation;
	}

	public Date getDtexecution() {
		return dtexecution;
	}

	public void setDtexecution(Date dtexecution) {
		this.dtexecution = dtexecution;
	}

	public Date getDtfinalization() {
		return dtfinalization;
	}

	public void setDtfinalization(Date dtfinalization) {
		this.dtfinalization = dtfinalization;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSpendedtime() {
		return spendedtime;
	}

	public void setSpendedtime(String spendedtime) {
		this.spendedtime = spendedtime;
	}
	
}
