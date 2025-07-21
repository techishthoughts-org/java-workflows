# 📋 Versioning Strategy

This document explains the versioning strategy for the reusable GitHub Actions workflows.

## 🎯 Versioning Philosophy

### **Semantic Versioning (SemVer)**
We follow [Semantic Versioning 2.0.0](https://semver.org/) for all workflow versions:

- **MAJOR.MINOR.PATCH**
  - **MAJOR**: Breaking changes (incompatible API changes)
  - **MINOR**: New features (backward compatible)
  - **PATCH**: Bug fixes (backward compatible)

### **Version Categories**

| Version Range | Purpose | Stability | Usage |
|---------------|---------|-----------|-------|
| `v1.x.x` | Stable, production-ready | ✅ High | Production projects |
| `v2.x.x` | Enhanced features | ✅ High | Advanced projects |
| `v3.x.x` | Experimental features | ⚠️ Medium | Testing new features |
| `@main` | Latest development | ❌ Low | Development only |

## 📁 Workflow Versions

### **v1.0.0 - Stable Foundation**
- **File**: `java-ci-secure.yml`
- **Features**:
  - Basic Java CI with security
  - Maven support
  - Matrix testing
  - Coverage reporting
  - Input validation

**Usage:**
```yaml
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-secure.yml@v1.0.0
    with:
      java-version: '21'
      os-matrix: 'ubuntu-latest,windows-latest'
```

### **v2.0.0 - Enhanced Features**
- **File**: `java-ci-universal.yml`
- **Features**:
  - All v1.0.0 features
  - **NEW**: Gradle support
  - **NEW**: Parallel test execution
  - **NEW**: Execution time tracking
  - **NEW**: Configurable caching
  - **NEW**: Advanced validation

**Usage:**
```yaml
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-universal.yml@v2.0.0
    with:
      java-version: '17'
      build-tool: 'gradle'
      gradle-version: '8.5'
      parallel-jobs: 8
      cache-dependencies: true
```

### **Latest Development**
- **File**: `java-ci-universal.yml`
- **Features**:
  - All v2.0.0 features
  - **NEW**: Universal build tool detection
  - **NEW**: Enhanced error handling
  - **NEW**: Better logging

**Usage:**
```yaml
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-universal.yml@main
    with:
      java-version: '21'
      build-tool: 'maven'
      os-matrix: 'ubuntu-latest,windows-latest,macos-latest'
```

## 🔄 Migration Guide

### **From v1.0.0 to v2.0.0**

**Breaking Changes:**
- None (backward compatible)

**New Features:**
```yaml
# v1.0.0
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-secure.yml@v1.0.0
    with:
      java-version: '21'
      os-matrix: 'ubuntu-latest'

# v2.0.0 (enhanced)
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-v2.yml@v2.0.0
    with:
      java-version: '21'
      build-tool: 'maven'  # NEW
      os-matrix: 'ubuntu-latest'
      parallel-jobs: 4     # NEW
      cache-dependencies: true  # NEW
```

### **From v2.0.0 to Latest Development**

**Breaking Changes:**
- None (backward compatible)

**New Features:**
```yaml
# v2.0.0
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-universal.yml@v2.0.0
    with:
      java-version: '17'
      build-tool: 'gradle'
      gradle-version: '8.5'

# Latest Development
jobs:
  test:
    uses: your-username/java-workflows/.github/workflows/java-ci-universal.yml@main
    with:
      java-version: '17'
      build-tool: 'gradle'
      gradle-version: '8.5'
      # Same inputs, better performance
```

## 🏷️ Release Strategy

### **Release Process**

1. **Development**: Work on `@main` branch
2. **Testing**: Test with real projects
3. **Release**: Create tagged release
4. **Documentation**: Update this guide

### **Release Schedule**

| Version | Release Date | Status | Support Until |
|---------|-------------|--------|---------------|
| v1.0.0 | Current | ✅ Active | 2025-12-31 |
| v2.0.0 | Current | ✅ Active | 2026-12-31 |
| Latest | Development | ⚠️ Testing | TBD |

### **Deprecation Policy**

- **6 months notice** before deprecating a version
- **12 months support** after deprecation
- **Migration guides** provided for all changes

## 🔧 Build Tool Support

### **Maven Support**
- **Versions**: All versions
- **Features**: Full support
- **Configuration**: `pom.xml`

### **Gradle Support**
- **Versions**: v2.0.0+
- **Features**: Full support
- **Configuration**: `build.gradle` or `build.gradle.kts`

### **Auto-Detection**
- **Versions**: Latest development only
- **Logic**: Detects build tool automatically
- **Fallback**: Maven if no build file found

## ☕ Java Version Support

### **Supported Versions**
- **Java 8**: LTS (Long Term Support)
- **Java 11**: LTS
- **Java 17**: LTS (Recommended)
- **Java 21**: LTS (Latest)
- **Java 22**: Latest

### **Version Matrix**

| Workflow Version | Java 8 | Java 11 | Java 17 | Java 21 | Java 22 |
|------------------|--------|---------|---------|---------|---------|
| v1.0.0 | ✅ | ✅ | ✅ | ✅ | ✅ |
| v2.0.0 | ✅ | ✅ | ✅ | ✅ | ✅ |
| Latest | ✅ | ✅ | ✅ | ✅ | ✅ |

## 🎯 Best Practices

### **Version Selection**

1. **Production Projects**: Use `v1.0.0` or `v2.0.0` (stable)
2. **New Projects**: Use `v2.0.0` (latest stable)
3. **Experimental**: Use `@main` (latest development)
4. **Legacy Projects**: Stay on current version

### **Migration Strategy**

1. **Test First**: Always test in development
2. **Gradual Rollout**: Migrate one project at a time
3. **Monitor**: Watch for any issues
4. **Rollback Plan**: Keep old version as backup

### **Version Pinning**

```yaml
# ✅ Good - Pinned version
uses: your-username/java-workflows/.github/workflows/java-ci-v2.yml@v2.0.0

# ❌ Bad - Unpinned version
uses: your-username/java-workflows/.github/workflows/java-ci-v2.yml@main
```

## 🚨 Breaking Changes

### **v1.0.0 to v2.0.0**
- **None** - Fully backward compatible

### **v2.0.0 to Universal**
- **None** - Fully backward compatible

### **Future Breaking Changes**
- Will be clearly documented
- Migration guides provided
- 6-month deprecation notice

## 📊 Version Comparison

| Feature | v1.0.0 | v2.0.0 | Latest |
|---------|--------|--------|--------|
| Maven Support | ✅ | ✅ | ✅ |
| Gradle Support | ❌ | ✅ | ✅ |
| Matrix Testing | ✅ | ✅ | ✅ |
| Parallel Execution | ❌ | ✅ | ✅ |
| Execution Time | ❌ | ✅ | ✅ |
| Auto-Detection | ❌ | ❌ | ✅ |
| Enhanced Logging | ❌ | ❌ | ✅ |

## 🔗 Quick Reference

### **Latest Stable**
```yaml
uses: your-username/java-workflows/.github/workflows/java-ci-v2.yml@v2.0.0
```

### **Latest Development**
```yaml
uses: your-username/java-workflows/.github/workflows/java-ci-universal.yml@main
```

### **Legacy Support**
```yaml
uses: your-username/java-workflows/.github/workflows/java-ci-secure.yml@v1.0.0
```

---

**📝 Note**: Always check the [releases page](https://github.com/your-username/java-workflows/releases) for the latest versions and changelog.
