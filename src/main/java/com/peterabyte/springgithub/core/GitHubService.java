package com.peterabyte.springgithub.core;

public interface GitHubService {
    GitHubDirectory getDirectory(String repoName);

    GitHubDirectory getDirectory(String repoName, String path);

    GitHubFile getFile(String repoName, String path);
}
