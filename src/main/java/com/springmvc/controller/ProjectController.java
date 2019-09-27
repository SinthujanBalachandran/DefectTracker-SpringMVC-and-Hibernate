package com.springmvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.Project;
import com.springmvc.service.ProjectService;

@Controller
public class ProjectController {

	public ProjectController() {
		System.out.println("ProjectController()");
	}

	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/")
	public ModelAndView listProject(ModelAndView model) throws IOException {
		List<Project> listProject = projectService.getAllProjects();
		model.addObject("listProject", listProject);
		model.setViewName("home");
		return model;
	}

	@RequestMapping(value = "/newProject", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Project project = new Project();
		model.addObject("project", project);
		model.setViewName("ProjectForm");
		return model;
	}

	@RequestMapping(value = "/saveProject", method = RequestMethod.POST)
	public ModelAndView saveProject(@ModelAttribute Project project) {
		if (project.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			projectService.addProject(project);
		} else {
			projectService.updateProject(project);
		}
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/deleteProject", method = RequestMethod.GET)
	public ModelAndView deleteProject(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		projectService.deleteProject(projectId);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editProject", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int projectId = Integer.parseInt(request.getParameter("id"));
		Project project = projectService.getProject(projectId);
		ModelAndView model = new ModelAndView("ProjectForm");
		model.addObject("project", project);

		return model;
	}

}