# Java Workflow Suite

[![Test harness](https://github.com/techishthoughts-org/java-workflows/actions/workflows/test-workflows.yml/badge.svg)](https://github.com/techishthoughts-org/java-workflows/actions/workflows/test-workflows.yml)
[![Latest release](https://img.shields.io/github/v/release/techishthoughts-org/java-workflows?label=latest%20tag)](https://github.com/techishthoughts-org/java-workflows/releases)
[![GitHub stars](https://img.shields.io/github/stars/techishthoughts-org/java-workflows?style=social)](https://github.com/techishthoughts-org/java-workflows/stargazers)

> Enterprise-grade CI/CD and security automation for Java teams, delivered as reusable GitHub Actions workflows.

## Why Platform Teams Choose This Suite

- **Accelerate delivery** – drop-in pipelines with opinionated guardrails make onboarding a new service a same-day task.
- **Raise engineering marketing value** – share a compelling DevOps story with prospects and investors using polished release notes, SBOMs, and compliance-ready checks.
- **Standardize governance** – every workflow ships with least-privilege permissions, SHA-pinned actions, and auditable outputs.
- **Scale confidently** – Java 11→25 support, Gradle + Maven parity, multi-OS matrices, and optional Kubernetes deploy flows.

## What’s Inside

- **Continuous Integration**: Unified Java CI 3.2.0 with matrix testing, caching, coverage, and TestContainers hooks.
- **Security & Compliance**: Container scanning, dependency auditing, SBOM generation, and secret detection.
- **Product Releases**: Automated tagging, changelog generation, release-note composition, and validation gates.
- **Composite Actions**: Reusable building blocks for Java toolchains, Docker publishing, artifact distribution, and more.

Explore the full catalog in `docs/workflow-catalog.md`.

## 5-Minute Launch Plan

1. **Pick your track** – choose the workflow tag that matches your support window (`java-ci.yml@v3.2.0` for the current LTS, `java-ci-universal.yml@v2.2.0` if Java 8 is still required).
2. **Reference by tag** – never pin to `@main` outside of experimentation.
3. **Configure secrets** – set `GITHUB_TOKEN` (default), optional Slack, registry, or OSSRH credentials depending on the workflow.
4. **Enable governance** – copy the security and release pipelines into your org-level templates.
5. **Tell the story** – reuse the release notes, changelog, and SBOM outputs in your marketing, sales, and compliance materials.

> **Default JVM:** All reusable workflows now target Java 25 (LTS) when `java-version` is omitted. Explicitly set an older runtime if your service has a different support window.

### Quick Start: Java CI (v3.2.0)

```yaml
name: Service CI
on: [push, pull_request]
jobs:
  test:
    uses: techishthoughts-org/java-workflows/.github/workflows/java-ci.yml@v3.2.0
    with:
      java-version-matrix: '11,17,21,25'
      os-matrix: 'ubuntu-latest,windows-latest'
      generate-coverage: true
      upload-artifacts: true
```

- **Auto-detects** Maven vs Gradle (no extra inputs).
- **Expands** to Windows + macOS simply by extending `os-matrix`.
- **Surfaces** coverage %, test summaries, and artifacts directly in workflow outputs.

### Quick Start: Automated Release + Docker Publish

```yaml
name: Release
on:
  workflow_dispatch:
  push:
    branches: [main]
jobs:
  release:
    uses: techishthoughts-org/java-workflows/.github/workflows/auto-tag-enhanced.yml@v1.0.0
    with:
      artifact-name: 'my-service'
      run-tests: true
      build-docker: true
      notify-on-success: true
    secrets:
      GITHUB_TOKEN: ${{ secrets.GITHUB_TOKEN }}
      SLACK_WEBHOOK_URL: ${{ secrets.SLACK_WEBHOOK_URL }}
```

This job reads the version from `pom.xml`, runs the full Maven verification (with Gradle fallback support), generates a customer-ready changelog, pushes a signed tag, builds/publishes multi-arch Docker images, and posts a Slack summary.

## Workflow & Action Catalog

- `docs/workflow-catalog.md` – at-a-glance tables for CI, security, release, deployment, and utility workflows.
- `examples/` – turnkey YAML examples for pipelines, security scans, publishing, and TestContainers integration.

## Release & Support Policy

- **Tags** – semantic versioning (`vMAJOR.MINOR.PATCH`) with release notes and validated artifacts.
- **Channels** – `v3.x` (current LTS), `v2.x` (extended support until January 2027), `@main` (experimental).
- **Changelog** – auto-generated via `release-workflows.yml`; see `CHANGELOG.md` for history.
- **Versioning playbook** – consult `VERSIONING_STRATEGY.md` for migration expectations and support windows.

## Documentation Hub

- `MIGRATION_V3.md` – move from the v2 universe in under an hour.
- `MIGRATION_GUIDE.md` – detailed upgrade paths from legacy adopters.
- `VERSIONING.md` & `VERSIONING_STRATEGY.md` – how we cut, label, and deprecate releases.
- `docs/workflow-catalog.md` – product-style catalog with highlights and file paths.

## Operating Model & Best Practices

- Reference workflows by tag and treat them like third-party dependencies.
- Keep `inputs` minimal; the defaults cover 90% of use cases, but every workflow supports overrides for advanced teams.
- Pair CI pipelines with the security and release workflows for end-to-end coverage and a single marketing message.
- Validate your fork with `test-workflows.yml` whenever contributing upstream or customizing.

## Roadmap & Feedback

- Review `V3_ROADMAP.md` for upcoming enhancements (GraalVM, JMH, TestContainers expansions).
- Open GitHub Issues for feature requests or reach out via discussions for architecture questions.
- Share success stories—marketing-ready case studies boost prioritization for the next wave of features.

---

**Ready to modernize your Java delivery story?** Fork the repo, reference the workflows by tag, and showcase faster releases with fewer compliance gaps.
