package com.peterabyte.springgithub.core;

import org.kohsuke.github.GHContent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class GitHubFile {
    private final String path;
    private final String name;
    private final String content;

    private GitHubFile(String path, String name, String content) {
        this.path = path;
        this.name = name;
        this.content = content;
    }

    static GitHubFile build(GHContent content) {
        if (content == null) {
            throw new IllegalArgumentException("Failed to build file! content is null.");
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(content.read(), content.getEncoding()))) {
            String fileContent = reader.lines().collect(Collectors.joining("\n"));
            return new GitHubFile(content.getPath(), content.getName(), fileContent);
        } catch (IOException e) {
            throw new GitHubServiceException("Failed to get file content! " + e.getMessage(), e);
        }
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GitHubFile{");
        sb.append("path='").append(path).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
