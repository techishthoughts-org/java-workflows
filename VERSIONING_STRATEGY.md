# Versioning Strategy for Java Workflows

## 🎯 Purpose

This document defines the versioning strategy for reusable GitHub Actions workflows to ensure:
- **Backward compatibility** for existing users
- **Clear upgrade paths** without breaking changes
- **Predictable behavior** across versions
- **Safe adoption** of new features

---

## 📋 Semantic Versioning (SemVer)

We follow [Semantic Versioning 2.0.0](https://semver.org/):

```
MAJOR.MINOR.PATCH

Example: 2.1.3
```

### Version Number Meanings

| Type | Increment | When to Use | Breaking Changes |
|------|-----------|-------------|------------------|
| **MAJOR** | X.0.0 | Breaking changes, removed features, major rewrites | ✅ YES |
| **MINOR** | 0.X.0 | New features, enhancements (backward compatible) | ❌ NO |
| **PATCH** | 0.0.X | Bug fixes, security patches (backward compatible) | ❌ NO |

---

## 🏷️ Version Reference Methods

Users can reference workflows in multiple ways:

### 1. **Specific Version (Recommended for Production)**
```yaml
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.1.0
```
✅ **Pros:** Stable, predictable, no surprises
❌ **Cons:** Must manually update to get new features

### 2. **Major Version Range (Recommended for Auto-Updates)**
```yaml
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2
```
✅ **Pros:** Auto-receives minor/patch updates (no breaking changes)
❌ **Cons:** Behavior may change slightly with new features

### 3. **Branch Reference (For Testing Only)**
```yaml
uses: org/workflows/.github/workflows/java-ci-universal.yml@main
```
⚠️ **Use Case:** Testing unreleased features
❌ **Cons:** Unstable, can break at any time

### 4. **Commit SHA (Maximum Stability)**
```yaml
uses: org/workflows/.github/workflows/java-ci-universal.yml@a1b2c3d4
```
✅ **Pros:** Immutable, maximum security
❌ **Cons:** No updates, must manually track changes

---

## 🔄 Version Lifecycle

### Version States

| State | Description | Support Level | Example |
|-------|-------------|---------------|---------|
| **Active** | Latest stable version | Full support, bug fixes | v2.1.0 |
| **Maintenance** | Previous major version | Security fixes only | v1.x.x |
| **Deprecated** | End-of-life announced | No support, 6 months notice | v0.x.x |
| **End-of-Life** | No longer supported | Use at own risk | - |

### Support Timeline

```
v1.0.0 (Jan 2025)    v2.0.0 (Jan 2025)    v2.1.0 (Nov 2025)    v3.0.0 (Planned)
    |                     |                     |                     |
    |---- Active -------->|---- Maintenance --->|---- Active -------->|
                          |---- Active -------->|---- Active -------->|---- Active ----->
                                                |                     |
                                                6 months notice       Drop Java 8
```

---

## 🚀 Release Process

### 1. Pre-Release (Development)

**Branch:** `main`
**Testing:** All changes go to main first
**Users:** Not recommended for production

```bash
# Development work happens here
git checkout main
git commit -m "feat: add new feature"
git push origin main
```

### 2. Release Candidates (Optional)

**Tag Format:** `v2.1.0-rc.1`, `v2.1.0-rc.2`
**Testing:** Beta testers can validate
**Duration:** 1-2 weeks before stable release

```bash
git tag -a v2.1.0-rc.1 -m "Release candidate 1 for v2.1.0"
git push origin v2.1.0-rc.1
```

### 3. Stable Release

**Tag Format:** `v2.1.0`
**Branch:** Create release branch for patches
**Announcement:** CHANGELOG, GitHub Release, Slack/Email

```bash
# Create release tag
git tag -a v2.1.0 -m "Release v2.1.0"
git push origin v2.1.0

# Create release branch for future patches
git checkout -b release/v2.1
git push origin release/v2.1

# Update major version tag (for @v2 references)
git tag -fa v2 -m "Update v2 to v2.1.0"
git push origin v2 --force
```

### 4. Patch Releases

**Branch:** `release/v2.1`
**Changes:** Bug fixes only, no new features
**Tag Format:** `v2.1.1`, `v2.1.2`

```bash
# Work on release branch
git checkout release/v2.1
git commit -m "fix: correct validation logic"
git tag -a v2.1.1 -m "Patch release v2.1.1"
git push origin v2.1.1

# Update major version tag
git tag -fa v2 -m "Update v2 to v2.1.1"
git push origin v2 --force

# Merge fix back to main
git checkout main
git merge release/v2.1
git push origin main
```

---

## 📦 Version Organization

### Git Tags Structure

```
v1.0.0              # Specific version
v1.0.1              # Patch
v1.0.2              # Patch
v1                  # Points to latest v1.x.x (auto-updated)

v2.0.0              # Major version bump
v2.0.1              # Patch
v2.1.0              # Minor version (new features)
v2.1.1              # Patch
v2                  # Points to latest v2.x.x (auto-updated)

v3.0.0              # Future major version
v3                  # Points to latest v3.x.x
```

### Branch Strategy

```
main                           # Latest development
├── release/v1.0              # v1.0.x maintenance
├── release/v2.0              # v2.0.x maintenance
├── release/v2.1              # v2.1.x maintenance
└── feature/*                 # Feature branches (merged to main)
```

---

## 🔒 Breaking Changes Policy

### What Constitutes a Breaking Change?

✅ **Breaking (Requires Major Version):**
- Removing workflow inputs
- Changing input types (string → number)
- Removing outputs
- Changing output formats
- Removing workflow files
- Changing required secrets
- Dropping Java version support
- Removing composite actions

❌ **Not Breaking (Minor/Patch Version):**
- Adding new optional inputs
- Adding new outputs
- Adding new workflows
- Adding new composite actions
- Enhancing existing features (backward compatible)
- Bug fixes
- Documentation updates
- Adding Java version support

### Deprecation Process

1. **Announcement (Major.Minor.0)**
   - Document in CHANGELOG
   - Add deprecation warnings in workflow outputs
   - Provide migration guide

2. **Grace Period (6 months minimum)**
   - Feature still works but logs warnings
   - Users have time to migrate

3. **Removal (Next Major Version)**
   - Feature removed in next major version
   - Clear migration path documented

**Example Timeline:**
```
v2.0.0 (Jan 2025):  Announce Java 8 deprecation
v2.1.0-v2.9.0:      Java 8 works with warnings
v3.0.0 (Jul 2025+): Java 8 support removed
```

---

## 📊 Version Matrix

### Current Support Matrix

| Version | Status | Java Versions | Build Tools | Security Scan | Artifact Publish | Support Until |
|---------|--------|---------------|-------------|---------------|------------------|---------------|
| **v2.1.0** | ✅ Active | 8,11,17,21,22,23 | Maven, Gradle | ✅ Full | ✅ Full | TBD |
| **v2.0.5** | ✅ Active | 8,11,17,21,22 | Maven, Gradle | ❌ None | ❌ None | Jun 2026 |
| **v1.0.0** | 🔶 Maintenance | 8,11,17,21,22 | Maven only | ❌ None | ❌ None | Jan 2026 |

### Future Versions

| Version | Planned Date | Key Changes | Breaking Changes |
|---------|-------------|-------------|------------------|
| **v2.2.0** | Q1 2026 | GraalVM native-image, JMH benchmarks | None |
| **v2.3.0** | Q2 2026 | Contract testing, enhanced reporting | None |
| **v3.0.0** | Q3 2026 | Remove Java 8, modern workflows only | Drop Java 8 |

---

## 📖 User Migration Guides

### Migrating from v1.0.0 to v2.x.x

**Breaking Changes:** None
**New Features:** Gradle support, more Java versions, enhanced features

```yaml
# Before (v1.0.0)
uses: org/workflows/.github/workflows/java-ci-secure.yml@v1.0.0
with:
  java-version: '17'
  maven-opts: '-Xmx4g'

# After (v2.1.0)
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.1.0
with:
  java-version: '21'          # Can now use Java 23!
  build-tool: 'maven'         # or 'gradle'
  maven-opts: '-Xmx4g'
```

**Migration Steps:**
1. Update workflow reference from `@v1.0.0` to `@v2.1.0`
2. Change workflow file from `java-ci-secure.yml` to `java-ci-universal.yml`
3. Add `build-tool: 'maven'` input (required in v2.x)
4. Test in a feature branch first
5. Deploy to production

### Migrating from v2.0.5 to v2.1.0

**Breaking Changes:** None
**New Features:** Java 23, Security scanning, Artifact publishing

```yaml
# Before (v2.0.5)
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.0.5

# After (v2.1.0) - No changes required!
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.1.0

# Optional: Add new features
jobs:
  security:
    uses: org/workflows/.github/workflows/ci-security.yml@v2.1.0
```

**Migration Steps:**
1. Simply update version tag from `@v2.0.5` to `@v2.1.0`
2. No code changes required (100% backward compatible)
3. Optionally add new security scanning workflow
4. Optionally use new composite actions

---

## 🎯 Best Practices for Users

### Production Environments

```yaml
# ✅ RECOMMENDED: Pin to specific version
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.1.0

# ✅ ALTERNATIVE: Use major version (auto-updates)
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2
```

### Development/Testing Environments

```yaml
# ✅ ACCEPTABLE: Use latest for testing
uses: org/workflows/.github/workflows/java-ci-universal.yml@main

# 🔶 WITH CAUTION: Use release candidate
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2.2.0-rc.1
```

### Update Strategy

1. **Conservative (Manual Updates)**
   - Pin to specific versions (`@v2.1.0`)
   - Review CHANGELOG before updating
   - Test in staging before production

2. **Progressive (Auto Minor Updates)**
   - Use major version tags (`@v2`)
   - Review CHANGELOG regularly
   - Set up automated testing

3. **Aggressive (Early Adopter)**
   - Use release candidates (`@v2.2.0-rc.1`)
   - Test on non-critical projects
   - Provide feedback to maintainers

---

## 🔔 Release Communication

### Channels

1. **GitHub Releases** (Primary)
   - Full release notes
   - Migration guides
   - Breaking change warnings

2. **CHANGELOG.md** (Reference)
   - Detailed change log
   - Version history
   - Upgrade guides

3. **Git Tags** (Automation)
   - Semantic versioning
   - Automated tooling support

4. **Notifications** (Optional)
   - Slack announcements
   - Email notifications
   - GitHub Discussions

### Release Notes Template

```markdown
# Release v2.1.0

## 🎉 New Features
- Java 23 support
- Security scanning workflow
- Artifact publishing action

## 🔧 Improvements
- Enhanced Gradle support
- Better error messages

## 🐛 Bug Fixes
- Fixed caching issue on Windows

## ⚠️ Deprecations
- Java 8 will be removed in v3.0.0 (6 months notice)

## 🚀 Migration Guide
[Link to migration guide]

## 📝 Breaking Changes
None (100% backward compatible)
```

---

## 🛡️ Security Updates

### Security Patch Process

1. **Critical Security Issue Identified**
2. **Patch All Active Versions**
   - v2.1.1 (latest)
   - v2.0.6 (maintenance)
   - v1.0.3 (maintenance)
3. **Notify Users Immediately**
4. **Document CVE and Fix**

### Version Support for Security

| Version Line | Security Patches | Duration |
|--------------|------------------|----------|
| Latest (v2.1.x) | ✅ Immediate | Ongoing |
| Previous Minor (v2.0.x) | ✅ Within 48h | 6 months |
| Previous Major (v1.x.x) | 🔶 Critical only | 1 year |

---

## 📚 Version History Summary

| Version | Release Date | Status | Key Features |
|---------|--------------|--------|--------------|
| v2.1.0 | Nov 2025 | ✅ Active | Java 23, Security, Publishing |
| v2.0.5 | Jan 2025 | ✅ Active | Release notes automation |
| v2.0.0 | Jan 2025 | ✅ Active | Gradle support |
| v1.0.0 | Jan 2025 | 🔶 Maintenance | Initial stable release |

---

## 🎓 FAQ

### Q: Should I use `@v2` or `@v2.1.0`?

**A:**
- **Production:** Use `@v2.1.0` for predictability
- **Development:** Use `@v2` for automatic updates

### Q: What happens when v3.0.0 is released?

**A:**
- `@v2` stays on v2.x.x (no automatic major version updates)
- `@v3` will be created for v3.x.x
- You choose when to migrate

### Q: How long is v1.0.0 supported?

**A:**
- Security patches: Until Jan 2026 (1 year after v2.0.0)
- Bug fixes: Already ended (maintenance mode)

### Q: Can I use features from v2.1.0 while staying on v1.0.0?

**A:**
- No, new features are only in newer versions
- Recommendation: Plan migration to v2.1.0

### Q: What if a breaking change is absolutely necessary?

**A:**
1. Announce in current minor version (v2.X.0)
2. Provide 6-month migration window
3. Release breaking change in next major (v3.0.0)
4. Maintain previous major (v2.x) for 6 months

---

**Last Updated:** November 2025
**Version:** 1.0.0 (This document)
**Maintainer:** Java Workflows Team
