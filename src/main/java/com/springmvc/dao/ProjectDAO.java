package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Project;

public interface ProjectDAO {

	public void addProject(Project project);

	public List<Project> getAllProjects();

	public void deleteProject(Integer projectId);

	public Project updateProject(Project project);

	public Project getProject(int projectid);
}
