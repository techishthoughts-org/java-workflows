# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

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
