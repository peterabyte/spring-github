package com.peterabyte.springgithub.core;

import java.util.List;

public interface GitHubService {
    List<GitHubRepository> getRepositories();

    GitHubDirectory getDirectory(String repoName, String path);

    GitHubFile getFile(String repoName, String path);
}
