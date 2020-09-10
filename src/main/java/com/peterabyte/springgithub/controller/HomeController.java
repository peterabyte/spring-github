package com.peterabyte.springgithub.controller;

import com.peterabyte.springgithub.core.GitHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private static final String VIEW_PATH_HOME = "pages/home";

    private final GitHubService gitHubService;

    @Value("${springgithub.repository}")
    private String repoName;

    @Autowired
    public HomeController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView(VIEW_PATH_HOME);
        modelAndView.addObject("repoName", repoName);
        modelAndView.addObject("repository", gitHubService.getDirectory(repoName));
        return modelAndView;
    }
}
