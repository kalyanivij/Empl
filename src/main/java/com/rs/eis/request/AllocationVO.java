package com.rs.eis.request;

<<<<<<< HEAD
import javax.validation.constraints.NotEmpty;

public class AllocationVO {

	private int id;
	@NotEmpty(message="please enter name")
	private String name;
	@NotEmpty(message="please enter projectId")
	private int projectid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
=======
public class AllocationVO {

	private String name;
	private int projectid;
>>>>>>> branch 'master' of git@github.com:kalyanivij/Empl.git

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

}
