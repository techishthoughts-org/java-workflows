## Workflow Catalog

Our reusable workflows and composite actions are organized by the outcomes they deliver. Reference them by tag (for example `@v3.2.0`) for production use.

### Continuous Integration

| Workflow | File | Designed For | Highlights |
| --- | --- | --- | --- |
| Java CI (v3.2.0) | `.github/workflows/java-ci.yml` | Modern Java services that need multi-JDK coverage | Defaults to Java 25 (LTS), auto-detects Maven vs Gradle, matrix-ready for Java 11-25 and Linux/Windows/macOS, optional coverage + artifact uploads |
| Java CI Secure (v1.0.0) | `.github/workflows/java-ci-secure.yml` | Compliance-focused Maven services | Strict permissions, signed dependencies, security reporting |
| Java CI Universal (v2.2.0) | `.github/workflows/java-ci-universal.yml` | Legacy apps requiring Java 8 support | Gradle + Maven parity, caching, parallelisation |

### Security & Compliance

| Workflow | File | Purpose | Highlights |
| --- | --- | --- | --- |
| Secure CI Scanner | `.github/workflows/ci-security.yml` | Automated SAST + SCA pipelines | OWASP Dependency-Check, Trivy, CodeQL, secret detection |
| Container Scan | `.github/workflows/container-scan.yml` | Container image hardening | Trivy + Grype with SBOM export, severity thresholds |

### Delivery & Operations

| Workflow | File | Purpose | Highlights |
| --- | --- | --- | --- |
| Release Automation | `.github/workflows/release-workflows.yml` | Versioning, changelog and release notes | Semantic version bumping, auto-tagging, release validation |
| Auto Tag Enhanced | `.github/workflows/auto-tag-enhanced.yml` | App releases with optional Docker pushes | Version detection from `pom.xml`, changelog and GH release packaging |
| Branch Lifecycle | `.github/workflows/auto-delete-branch-enhanced.yml` | Safe branch clean-up | Protects `main/production` branches, optional notifications |
| Dependabot Auto-Merge | `.github/workflows/dependabot-auto-merge-enhanced.yml` | Autonomous dependency updates | Policy-aware merging with CI gating |
| Kubernetes Deploy | `.github/workflows/k8s-deploy.yml` | Cluster rollouts | Works with EKS/GKE/AKS/custom clusters, rollout verification |

### Test & Validation Utilities

| Workflow | File | Purpose | Highlights |
| --- | --- | --- | --- |
| Workflow Test Harness | `.github/workflows/test-workflows.yml` | Validates this repository | YAML linting, security scanning, composite action smoke tests |
| Test Workflow Matrix | `.github/workflows/test-workflows.yml` | Reusable for consumer repos | Use as template for validating imported workflows |

### Composite Actions

| Action | File | Use Case | Highlights |
| --- | --- | --- | --- |
| Setup Java + Maven | `.github/actions/setup-java-maven/action.yml` | Consistent Java toolchains | Maven caching, exports `MAVEN_OPTS`, Temurin LTS support |
| Setup Java + Gradle | `.github/actions/setup-java-gradle/action.yml` | Gradle-first projects | Wrapper detection, caching controls |
| Advanced Cache | `.github/actions/advanced-cache/action.yml` | Layered caching strategies | Dependency + build artifact caches |
| Security Scan | `.github/actions/security-scan/action.yml` | Lightweight security checks | Trivy, secret scanning, SARIF upload |
| Docker Build & Push | `.github/actions/docker-build-push/action.yml` | Multi-arch image builds | OCI metadata, registry login integration |
| SBOM Generate | `.github/actions/sbom-generate/action.yml` | Supply-chain transparency | SPDX / CycloneDX output |
| Artifact Publish | `.github/actions/artifact-publish/action.yml` | Multi-registry artifact shipping | Maven Central, GitHub Packages, Nexus and more |

### Additional References

- `examples/usage-examples.md` contains end-to-end pipeline samples.
- `MIGRATION_V3.md` covers the upgrade path from v2.x to v3.x.
- `VERSIONING_STRATEGY.md` explains supported release channels and support windows.

