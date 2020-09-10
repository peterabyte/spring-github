package com.peterabyte.springgithub.core;

import org.kohsuke.github.GHContent;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GitHubDirectory {
    private final String path;
    private final List<GitHubContent> contents;

    private GitHubDirectory(String path, List<GitHubContent> contents) {
        this.path = path;
        this.contents = contents;
    }

    static GitHubDirectory build(String path, List<GHContent> contentList) {
        List<GitHubContent> resultContentList = contentList != null
                ? contentList.stream().map(GitHubContent::build).collect(Collectors.toList())
                : Collections.emptyList();
        return new GitHubDirectory(path, resultContentList);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GitHubDirectory{");
        sb.append("path='").append(path).append('\'');
        sb.append(", contents=").append(contents);
        sb.append('}');
        return sb.toString();
    }
}
