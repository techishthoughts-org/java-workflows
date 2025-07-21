# 📚 Usage Examples

This document shows how to use the reusable workflows in your own repositories.

## 🚀 Quick Start Examples

### 1. Basic Java CI with Security

Create `.github/workflows/ci.yml` in your repository:

```yaml
name: CI
on: [push, pull_request]

jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-secure.yml@v1.0.0
    with:
      java-version: '21'
      os-matrix: 'ubuntu-latest,windows-latest'
      notify-on-failure: true
    secrets:
      SLACK_WEBHOOK_URL: ${{ secrets.SLACK_WEBHOOK_URL }}
```

### 2. Enhanced Auto-Tagging with Docker

Create `.github/workflows/release.yml` in your repository:

```yaml
name: Release
on:
  push:
    branches: [main]

jobs:
  release:
    uses: your-username/java-workflows/.github/workflows/auto-tag-enhanced.yml@v1.0.0
    with:
      java-version: '17'
      artifact-name: 'my-app'
      build-docker: true
      platforms: 'linux/amd64,linux/arm64'
      notify-on-success: true
    secrets:
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      SLACK_WEBHOOK_URL: ${{ secrets.SLACK_WEBHOOK_URL }}
```

### 3. Smart Branch Cleanup

Create `.github/workflows/cleanup.yml` in your repository:

```yaml
name: Cleanup
on:
  pull_request:
    types: [closed]

jobs:
  cleanup:
    uses: your-username/java-workflows/.github/workflows/auto-delete-branch-enhanced.yml@v1.0.0
    with:
      protected-branches: 'main,develop,staging'
      notify-on-deletion: true
      delete-delay: 30
    secrets:
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      SLACK_WEBHOOK_URL: ${{ secrets.SLACK_WEBHOOK_URL }}
```

### 4. Intelligent Dependabot Auto-Merge

Create `.github/workflows/dependabot.yml` in your repository:

```yaml
name: Dependabot
on:
  pull_request:
    types: [opened, synchronize]

jobs:
  auto-merge:
    uses: your-username/java-workflows/.github/workflows/dependabot-auto-merge-enhanced.yml@v1.0.0
    with:
      auto-merge-patch: true
      auto-merge-minor: true
      auto-merge-major: false
      exclude-dependencies: 'spring-boot,junit'
      require-ci-success: true
    secrets:
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      SLACK_WEBHOOK_URL: ${{ secrets.SLACK_WEBHOOK_URL }}
```

## 🔧 Composite Actions Usage

### Java & Maven Setup

```yaml
steps:
  - uses: actions/checkout@v4
  - uses: your-username/java-workflows/.github/actions/setup-java-maven@v1.0.0
    with:
      java-version: '21'
      maven-version: '3.8.8'
```

### Docker Build & Push

```yaml
steps:
  - uses: actions/checkout@v4
  - uses: your-username/java-workflows/.github/actions/docker-build-push@v1.0.0
    with:
      image-name: 'my-app'
      image-tag: 'v1.0.0'
      registry: 'ghcr.io'
      push: 'true'
      platforms: 'linux/amd64,linux/arm64'
```

## 🔑 Required Secrets

### For All Workflows
- `GITHUB_TOKEN`: Automatically provided by GitHub

### For Notifications
- `SLACK_WEBHOOK_URL`: Your Slack webhook URL for notifications

## 📋 Configuration Options

### Java CI Workflow
- `java-version`: Java version (8, 11, 17, 21, 22)
- `os-matrix`: Operating systems to test on
- `maven-opts`: Maven JVM options
- `test-pattern`: Test pattern for Maven
- `notify-on-failure`: Send notifications on failure

### Auto-Tag Workflow
- `java-version`: Java version
- `artifact-name`: Name of the built artifact
- `build-docker`: Whether to build Docker image
- `run-tests`: Whether to run tests before tagging
- `registry`: Container registry URL
- `platforms`: Docker platforms to build

### Dependabot Workflow
- `auto-merge-patch`: Enable auto-merge for patch updates
- `auto-merge-minor`: Enable auto-merge for minor updates
- `auto-merge-major`: Enable auto-merge for major updates
- `merge-method`: Merge method (merge, squash, rebase)
- `exclude-dependencies`: Dependencies to exclude from auto-merge

### Branch Cleanup Workflow
- `protected-branches`: Branches never to delete
- `add-comment`: Whether to comment on PR after deletion
- `notify-on-deletion`: Send notifications when branches are deleted
- `dry-run`: Only simulate deletion
- `delete-delay`: Delay in seconds before deletion

## 🎯 Best Practices

1. **Always reference by tag**: Use `@v1.0.0` instead of `@main`
2. **Use semantic versioning**: Major.Minor.Patch
3. **Test workflows**: Use the test-workflows.yml pipeline
4. **Monitor notifications**: Set up Slack webhooks
5. **Regular updates**: Keep dependencies current

## 🚨 Troubleshooting

### Common Issues

1. **Workflow not found**: Make sure you're using the correct repository name and tag
2. **Permission denied**: Ensure the workflow has the required permissions
3. **Secrets not found**: Make sure all required secrets are configured
4. **YAML syntax errors**: Validate your workflow files

### Debug Steps

1. Check the workflow run logs for detailed error messages
2. Verify all required inputs are provided
3. Ensure all required secrets are configured
4. Test with a simple workflow first

## 📞 Support

If you encounter issues:

1. Check the workflow documentation in the README
2. Review the workflow source code
3. Open an issue in this repository
4. Check the GitHub Actions documentation
