package com.peterabyte.springgithub.core;

import org.kohsuke.github.GHContent;

public class GitHubContent {
    private final GitHubContentType type;
    private final String path;
    private final String name;
    private final String encoding;

    public GitHubContent(GitHubContentType type, String path, String name, String encoding) {
        this.type = type;
        this.path = path;
        this.name = name;
        this.encoding = encoding;
    }

    static GitHubContent build(GHContent content) {
        if (content == null) {
            throw new IllegalArgumentException("Failed to build content! content is null.");
        }
        GitHubContentType type = GitHubContentType.UNKNOWN;
        if (content.isDirectory()) {
            type = GitHubContentType.DIRECTORY;
        } else if (content.isFile()) {
            type = GitHubContentType.FILE;
        }
        return new GitHubContent(type, content.getPath(), content.getName(), content.getEncoding());
    }

    public GitHubContentType getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public String getEncoding() {
        return encoding;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GitHubContent{");
        sb.append("type=").append(type);
        sb.append(", path='").append(path).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", encoding='").append(encoding).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
