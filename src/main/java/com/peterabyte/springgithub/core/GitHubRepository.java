package com.peterabyte.springgithub.core;

import org.kohsuke.github.GHRepository;

public class GitHubRepository {
    private final String fullName;

    public GitHubRepository(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    static GitHubRepository build(GHRepository repository) {
        return new GitHubRepository(repository.getFullName());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GitHubRepository{");
        sb.append("fullName='").append(fullName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
