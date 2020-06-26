package com.peterabyte.springgithub.core;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KohsukeGitHubService implements GitHubService {
    private final GitHub gitHub;

    @Value("${springgithub.oauth.token}")
    private String oauthToken;

    public KohsukeGitHubService() {
        try {
            this.gitHub = new GitHubBuilder().withOAuthToken(oauthToken).build();
        } catch (IOException e) {
            throw new GitHubServiceException("Failed to create GitHub client! " + e.getMessage(), e);
        }
    }

    @Override
    public List<GitHubRepository> getRepositories() {
        try {
            return gitHub.getMyself()
                    .listRepositories()
                    .toList()
                    .stream()
                    .map(GitHubRepository::build)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new GitHubServiceException("Failed to get repositories! " + e.getMessage(), e);
        }
    }

    @Override
    public GitHubDirectory getDirectory(String repoName, String path) {
        try {
            GHRepository repo = gitHub.getRepository(repoName);
            if (repo == null) {
                throw new GitHubServiceException(String.format("Failed to get repository '%s' when listing directory '%s'!", repoName, path));
            }
            return GitHubDirectory.build(repo.getDirectoryContent(path));
        } catch (IOException e) {
            throw new GitHubServiceException(String.format("Failed to get directory '%s' from repository '%s'! %s", path, repoName, e.getMessage()), e);
        }
    }

    @Override
    public GitHubFile getFile(String repoName, String path) {
        try {
            GHRepository repo = gitHub.getRepository(repoName);
            if (repo == null) {
                throw new GitHubServiceException(String.format("Failed to get repository '%s' when listing file '%s'!", repoName, path));
            }
            return GitHubFile.build(repo.getFileContent(path));
        } catch (IOException e) {
            throw new GitHubServiceException(String.format("Failed to get file '%s' from repository '%s'! %s", path, repoName, e.getMessage()), e);
        }
    }
}
