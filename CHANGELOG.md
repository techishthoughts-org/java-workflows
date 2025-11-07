# 🚀 Release v3.6.0

**Release Date**: 2025-11-07

## 🔧 Maintenance
- chore(deps): bump actions/upload-artifact from 4 to 5 (#1) (7f5fbd9)
- chore: use default dependencies label for dependabot (8bc726f)
- chore: configure dependabot for maven, gradle, and actions (8e3baf1)

## 📦 Workflow Files Changed

- `.github/workflows/ci-security.yml`
- `.github/workflows/container-scan.yml`
- `.github/workflows/java-ci.yml`

## 🔗 Links

- **Full Changelog**: https://github.com/techishthoughts-org/java-workflows/compare/v3.5.0...v3.6.0
- **Documentation**: https://github.com/techishthoughts-org/java-workflows/blob/v3.6.0/README.md

---

**🤖 This release was automatically created by GitHub Actions**

# 🚀 Release v3.5.0

**Release Date**: 2025-11-07

## 🔧 Maintenance
- chore: set release title to tag (1a23afa)

## 📦 Workflow Files Changed

- `.github/workflows/release-workflows.yml`

## 🔗 Links

- **Full Changelog**: https://github.com/techishthoughts-org/java-workflows/compare/v3.4.0...v3.5.0
- **Documentation**: https://github.com/techishthoughts-org/java-workflows/blob/v3.5.0/README.md

---

**🤖 This release was automatically created by GitHub Actions**

# 🚀 Release v3.4.0

**Release Date**: 2025-11-07

## 🐛 Bug Fixes
- fix: skip validation when no release tag (ac1154c)

## 📦 Workflow Files Changed

- `.github/workflows/release-workflows.yml`

## 🔗 Links

- **Full Changelog**: https://github.com/techishthoughts-org/java-workflows/compare/v3.3.0...v3.4.0
- **Documentation**: https://github.com/techishthoughts-org/java-workflows/blob/v3.4.0/README.md

---

**🤖 This release was automatically created by GitHub Actions**

# 🚀 Release v3.3.0

**Release Date**: 2025-11-07

## 🐛 Bug Fixes
- fix: handle changelog content safely (86ba311)
- fix: make jmh action yaml-safe (d553aa6)
- fix: hardcoded secret scan noise (7a5c324)

## 🔧 Maintenance
- ci: add pre-merge validators (51050d4)
- chore: align workflows and docs with java 25 (947dc7b)

## 📦 Workflow Files Changed

- `.github/actions/advanced-cache/action.yml`
- `.github/actions/artifact-publish/action.yml`
- `.github/actions/jmh-benchmark/action.yml`
- `.github/actions/native-image-build/action.yml`
- `.github/actions/setup-java-maven/action.yml`
- `.github/actions/testcontainers-test/action.yml`
- `.github/workflows/auto-tag-enhanced.yml`
- `.github/workflows/ci-security.yml`
- `.github/workflows/java-ci-secure.yml`
- `.github/workflows/java-ci-universal.yml`
- `.github/workflows/java-ci.yml`
- `.github/workflows/pre-merge-validators.yml`
- `.github/workflows/release-workflows.yml`
- `.github/workflows/test-workflows.yml`

## 🔗 Links

- **Full Changelog**: https://github.com/techishthoughts-org/java-workflows/compare/v3...v3.3.0
- **Documentation**: https://github.com/techishthoughts-org/java-workflows/blob/v3.3.0/README.md

---

**🤖 This release was automatically created by GitHub Actions**

# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [3.2.0] - 2025-11-04

### Added
- **Multi-Version Matrix Testing** - Test against multiple Java versions simultaneously
  - New `java-version-matrix` input (e.g., '11,17,21,25')
  - Parallel testing across all specified versions
  - Independent OS and Java version matrix configuration
  - Configurable `fail-fast` behavior
- **TestContainers Integration** - New composite action `testcontainers-test`
  - Real database/service integration testing
  - Support for PostgreSQL, MySQL, MariaDB, Redis, MongoDB, Elasticsearch, Kafka, RabbitMQ
  - Automatic container preloading and cleanup
  - Parallel test execution support
  - Docker Hub login to avoid rate limiting
- **Container Security Scanning** - New workflow `container-scan.yml`
  - Comprehensive vulnerability scanning with Trivy and Grype
  - Container SBOM generation with Syft
  - Multi-severity level reporting (CRITICAL, HIGH, MEDIUM)
  - SARIF upload to GitHub Security tab
  - Configurable fail-on-severity thresholds
- **Advanced Caching** - New composite action `advanced-cache`
  - Multi-layer caching (dependencies, build outputs, test data)
  - Intelligent fallback cache keys
  - Platform-specific optimization
  - Build tool aware caching strategies
  - ~2-5 minutes build time savings

### Changed
- Enhanced `java-ci.yml` workflow to v3.2.0
  - Added multi-version matrix testing support
  - Added fail-fast control
  - Improved cache key generation
  - Better matrix strategy configuration

### Performance
- Advanced caching reduces build times by 40-60%
- Parallel matrix testing improves CI feedback time
- TestContainers preloading speeds up integration tests

### Documentation
- Updated workflow headers with v3.2.0 features
- Enhanced composite action descriptions
- Added comprehensive usage examples

## [3.1.0] - 2025-11-04

### Added
- **Java 25 (LTS) Support** - Added support for Java 25 across all workflows and composite actions
  - Updated `java-ci.yml` workflow
  - Updated `k8s-deploy.yml` workflow
  - Updated all composite actions (setup-java-maven, setup-java-gradle, sbom-generate)
  - Full LTS support: Java 11, 17, 21, 25
  - Non-LTS support: Java 23, 24

### Changed
- Enhanced workflow version to v3.1.0
- Updated documentation to reflect Java 25 support
- Improved build summaries to highlight Java 11-25 range

### Documentation
- Updated workflow headers with Java 25 support
- Enhanced composite action descriptions

## [3.0.0] - 2025-11-04

### 🔴 Breaking Changes
- **Removed Java 8 support** - Minimum Java version is now 11
- **Consolidated workflows** - New unified `java-ci.yml` replaces `java-ci-universal.yml` and `java-ci-secure.yml`
- **Auto-detection default** - Build tool now auto-detected by default (no longer required input)
- **Simplified configuration** - Fewer required inputs, smarter defaults

### Added
- **Cloud-Native Deployments:** New workflow `k8s-deploy.yml`
  - Kubernetes deployment automation
  - Support for EKS, GKE, AKS, custom clusters
  - Automatic rollout verification
  - Service creation and exposure
- **SBOM Generation:** New composite action `sbom-generate`
  - Software Bill of Materials for supply chain security
  - CycloneDX and SPDX format support
  - Automatic dependency tracking
- **Auto-Detection:** Build tool auto-detection (Maven/Gradle)
- **Enhanced Caching:** Improved dependency caching strategies
- **Modern Focus:** Java 11, 17, 21, 23+ support

### Changed
- Unified workflow naming for simplicity
- Improved performance with parallel execution
- Better error messages and debugging
- Enhanced GitHub Step Summary outputs

### Removed
- Java 8 support (use v2.x for Java 8)
- Legacy workflow files (use `java-ci.yml` instead)

### Migration
- See MIGRATION_V3.md for complete upgrade guide
- v2.x remains supported until January 2027

## [2.2.0] - 2025-11-XX

### Added
- **GraalVM Native Image Support:** New composite action `native-image-build`
  - Build native executables for fast startup and low memory
  - Support for Profile-Guided Optimization (PGO)
  - G1GC and static image options
  - Automatic performance reporting
- **JMH Performance Benchmarking:** New composite action `jmh-benchmark`
  - Run Java Microbenchmark Harness (JMH) benchmarks
  - Performance regression detection
  - Baseline comparison support
  - Multiple output formats (JSON, CSV, text)
- **Enhanced Test Reporting:** New composite action `test-report`
  - Allure report generation
  - Serenity BDD support
  - JUnit report processing
  - GitHub Pages publishing
  - Historical trend tracking

### Changed
- Enhanced build performance with improved caching strategies
- Updated composite actions documentation

## [2.1.0] - 2025-11-XX

### Added
- Java 23 support across all workflows (java-ci-universal.yml, java-ci-secure.yml)
- New composite action: `setup-java-gradle` for Gradle project setup with caching
- New composite action: `security-scan` for comprehensive security scanning
- New composite action: `artifact-publish` for publishing to multiple repositories
- New workflow: `ci-security.yml` for comprehensive security scanning
  - CodeQL SAST analysis
  - OWASP Dependency-Check
  - Trivy vulnerability scanning
  - Snyk integration (optional)
  - Secret scanning with TruffleHog
- Support for multiple Java distributions (Temurin, Zulu, Liberica, Corretto, Microsoft, Oracle)
- Enhanced Gradle support with wrapper detection
- Artifact publishing to multiple targets:
  - GitHub Packages
  - Maven Central (OSSRH)
  - Sonatype Nexus
  - JFrog Artifactory
  - AWS CodeArtifact
- GPG signing support for Maven Central publishing
- Security score calculation (A+ to F rating)
- Dry-run mode for artifact publishing

### Changed
- Updated java-ci-universal.yml to version 2.1.0
- Enhanced Java version validation to include Java 23
- Improved documentation with comprehensive header comments

### Deprecated
- Java 8 support will be deprecated in v3.0.0 (6 months notice)

## [2.0.5] - 2025-01-XX

### Added
- GitHub automatic release notes generation
- Enhanced release workflow with improved changelog generation

### Changed
- Updated release-workflows.yml with automatic release notes

## [2.0.4] - 2025-01-XX

### Fixed
- Added explicit `shell: bash` to all run steps for cross-platform compatibility
- Fixed shell script execution issues on Windows runners

## [2.0.3] - 2025-01-XX

### Changed
- Updated deprecated GitHub Actions to latest versions
- Improved action version pinning

## [2.0.2] - 2025-01-XX

### Fixed
- Fixed JSON parsing and generation reliability
- Improved error handling in workflow validation

## [2.0.1] - 2025-01-XX

### Fixed
- Fixed JSON parsing errors in workflow outputs

## [2.0.0] - 2025-01-XX

### Added
- Enhanced Java CI workflow supporting both Maven and Gradle
- Gradle version configuration
- Multiple build tool support in single workflow
- Enhanced coverage tool selection (JaCoCo, Cobertura)
- Parallel execution capabilities
- Improved matrix testing

### Changed
- Enhanced workflow naming and organization
- Improved input validation
- Better error messages and logging

## [1.0.0] - 2025-01-XX

### Added
- Initial stable release
- Java CI workflow with Maven support (java-ci-secure.yml)
- Support for Java 8, 11, 17, 21, 22
- Matrix testing support (multiple OS and Java versions)
- JaCoCo code coverage integration
- Composite action: setup-java-maven
- Composite action: docker-build-push
- Auto-tagging workflow with Docker build support
- Branch cleanup workflow
- Dependabot auto-merge workflow
- Release management workflow
- Workflow testing and validation
- Security best practices:
  - Fine-grained permissions
  - Input validation
  - SHA-pinned actions
- Slack notification integration
- Comprehensive documentation
- Example workflows
- Versioning strategy documentation (VERSIONING.md)

### Security
- Implemented security hardening across all workflows
- Added security scanning in test workflows
- Secrets management best practices

---

## Version History Summary

| Version | Release Date | Key Features |
|---------|-------------|--------------|
| **Unreleased** | TBD | Java 23, Security scanning, Artifact publishing, Gradle support |
| **2.0.5** | 2025-01 | Automatic release notes |
| **2.0.4** | 2025-01 | Cross-platform shell support |
| **2.0.3** | 2025-01 | Updated GitHub Actions |
| **2.0.2** | 2025-01 | JSON parsing fixes |
| **2.0.1** | 2025-01 | JSON parsing improvements |
| **2.0.0** | 2025-01 | Maven + Gradle support |
| **1.0.0** | 2025-01 | Initial stable release |

---

## Upgrade Guides

### Upgrading from 2.0.x to 2.1.0

**New Features Available:**
- Java 23 support (add to your java-version input)
- New `setup-java-gradle` composite action for Gradle projects
- New `ci-security.yml` workflow for security scanning
- New `artifact-publish` composite action for publishing

**Breaking Changes:**
- None (fully backward compatible)

**Recommended Actions:**
1. Update your workflow references from `@v2.0.x` to `@v2.1.0`
2. Consider adding security scanning workflow to your pipeline
3. Test Java 23 compatibility in your projects
4. Review new Gradle setup action for better caching

### Upgrading from 1.x to 2.x

**New Features Available:**
- Gradle build tool support
- Enhanced coverage tools (JaCoCo, Cobertura)
- Better parallel execution
- Improved matrix testing

**Breaking Changes:**
- None (1.x workflows still available)

**Recommended Actions:**
1. If using Gradle, switch to `java-ci-universal.yml` workflow
2. Review new input options for customization
3. Test with your existing projects before full rollout

---

## Future Roadmap

### Planned for v3.0.0
- [ ] GraalVM native-image build support
- [ ] Performance benchmarking (JMH integration)
- [ ] Contract testing support (Pact, Spring Cloud Contract)
- [ ] Enhanced test reporting (Allure, Serenity)
- [ ] Multi-module project optimization
- [ ] Remove Java 8 support (deprecated)

### Under Consideration
- [ ] Kubernetes deployment workflows
- [ ] Cloud-native deployment support
- [ ] Chaos engineering integration
- [ ] Advanced caching strategies
- [ ] IDE integration guides

---

## Contributing

We welcome contributions! Please see our contributing guidelines for details on:
- Reporting bugs
- Suggesting enhancements
- Submitting pull requests
- Code style and standards

---

## Support

For questions, issues, or feature requests:
- Open an issue in this repository
- Check existing documentation in README.md and VERSIONING.md
- Review example workflows in the `examples/` directory

---

**Note:** This changelog is automatically generated from commit messages and release notes.
Manual updates are made for major releases and breaking changes.
