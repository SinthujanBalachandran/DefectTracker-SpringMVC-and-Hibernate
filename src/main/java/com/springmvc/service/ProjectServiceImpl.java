package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.ProjectDAO;
import com.springmvc.model.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Override
	@Transactional
	public void addProject(Project project) {
		projectDAO.addProject(project);
	}

	@Override
	@Transactional
	public List<Project> getAllProjects() {
		return projectDAO.getAllProjects();
	}

	@Override
	@Transactional
	public void deleteProject(Integer projectId) {
		projectDAO.deleteProject(projectId);
	}

	public Project getProject(int empid) {
		return projectDAO.getProject(empid);
	}

	public Project updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectDAO.updateProject(project);
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	
}
