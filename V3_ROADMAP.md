# v3.0.0 Roadmap - Breaking Changes & Modern Workflows

**Target Release:** Q3 2026 (July-September 2026)
**Status:** Planning Phase
**Breaking Changes:** Yes (Java 8 removal, workflow modernization)

---

## 🎯 **Primary Goals**

1. **Remove Legacy Support** - Drop Java 8, streamline codebase
2. **Modern Workflow Patterns** - Adopt latest GitHub Actions features
3. **Cloud-Native Focus** - Kubernetes, containers, cloud deployments
4. **Performance** - Faster builds, better caching, parallel execution
5. **Developer Experience** - Simpler configuration, better defaults

---

## 🔴 **Breaking Changes** (6 Months Notice Period)

### 1. **Java 8 Removal** ❌ BREAKING
**Announcement Date:** v2.1.0 (Nov 2025)
**Removal Date:** v3.0.0 (Jul 2026+)
**Grace Period:** 8 months minimum

**Rationale:**
- Java 8 EOL extended support ends Dec 2030
- Industry has largely moved to Java 11+
- Modern frameworks require Java 11+ (Spring Boot 3.x, Jakarta EE 9+)
- Maintaining Java 8 compatibility limits innovation

**Impact:**
- Users still on Java 8 must upgrade to Java 11+ before v3.0.0
- v2.x will continue to support Java 8 (security patches until Jan 2027)

**Migration Path:**
```yaml
# Before v3.0.0: Upgrade to Java 11 or later
java-version: '11'  # Minimum
java-version: '17'  # Recommended
java-version: '25'  # Latest LTS
```

---

### 2. **Workflow File Consolidation** ❌ BREAKING
**Current:** Multiple workflow files (`java-ci-universal.yml`, `java-ci-secure.yml`)
**v3.0.0:** Single unified workflow (`java-ci.yml`)

**Rationale:**
- Reduce confusion between v1 and v2 workflows
- Simpler naming, easier to discover
- All features in one place

**Changes:**
```yaml
# OLD (v2.x):
uses: org/workflows/.github/workflows/java-ci-universal.yml@v2

# NEW (v3.0.0):
uses: org/workflows/.github/workflows/java-ci.yml@v3
```

**Migration Path:**
- Automated migration script provided
- v2.x workflows remain available at `@v2` tag
- Side-by-side testing period (6 months)

---

### 3. **Default Java Version Change** ⚠️ BREAKING
**Current Default:** Java 25 (LTS)
**v3.0.0 Default:** Java 21 (LTS)
**v3.2.0+ Default:** Java 25 (LTS)
**Future:** Continues to track the newest LTS after evaluation

**Rationale:**
- Users should explicitly specify Java version
- Avoid unexpected upgrades

**Impact:**
- Users not specifying `java-version` will now get Java 25
- Recommendation: Always specify `java-version`

---

### 4. **Required Input Changes** ⚠️ BREAKING
**v2.x:** `build-tool` is required
**v3.0.0:** `build-tool` is optional (auto-detected)

**Rationale:**
- Auto-detect from `pom.xml` or `build.gradle`
- Simpler configuration

**New Behavior:**
```yaml
# v3.0.0: build-tool auto-detected
with:
  java-version: '25'
  # build-tool not needed (auto-detected)
```

---

## ✨ **New Features in v3.0.0**

### 1. **Cloud-Native Deployment Workflows**
- Kubernetes deployment automation
- Helm chart testing and deployment
- AWS ECS/EKS deployment
- Google Cloud Run deployment
- Azure Container Apps deployment

### 2. **Advanced Caching Strategies**
- Build cache sharing across repositories
- Remote cache support (S3, GCS, Azure Blob)
- Incremental build detection
- Cache warming for faster CI

### 3. **Modern Testing Frameworks**
- TestContainers integration
- Chaos engineering (Chaos Toolkit)
- Load testing (Gatling, K6)
- Contract testing (Pact, Spring Cloud Contract)

### 4. **Enhanced Security**
- Supply chain security (SLSA, Sigstore)
- SBOM (Software Bill of Materials) generation
- Vulnerability database updates
- Security policy enforcement

### 5. **Developer Experience**
- Interactive workflow configuration
- Real-time build feedback
- IDE integration (VS Code, IntelliJ)
- Local workflow testing (act)

---

## 📋 **v3.0.0 Feature Breakdown**

### **Phase 1: Foundation** (Jan-Mar 2026)
- [ ] Remove Java 8 support
- [ ] Consolidate workflows to `java-ci.yml`
- [ ] Auto-detection of build tools
- [ ] Update all documentation
- [ ] Create migration scripts

### **Phase 2: Cloud-Native** (Apr-May 2026)
- [ ] Kubernetes deployment workflows
- [ ] Helm chart testing
- [ ] Cloud provider integrations (AWS, GCP, Azure)
- [ ] Container registry support

### **Phase 3: Advanced Features** (Jun-Jul 2026)
- [ ] Advanced caching (remote, incremental)
- [ ] TestContainers integration
- [ ] Load testing workflows
- [ ] SBOM generation

### **Phase 4: Polish & Release** (Aug-Sep 2026)
- [ ] Complete documentation
- [ ] Migration guides
- [ ] Example workflows
- [ ] Beta testing period
- [ ] v3.0.0 release

---

## 🔄 **Migration Timeline**

| Date | Event | Action |
|------|-------|--------|
| **Nov 2025** | v2.1.0 Release | Java 8 deprecation announced |
| **Jan 2026** | v2.3.0 Release | Migration tools released |
| **Mar 2026** | v3.0.0-rc.1 | Release candidate available |
| **May 2026** | Final Notice | 60-day final warning |
| **Jul 2026** | v3.0.0 Release | Breaking changes live |
| **Jan 2027** | v2.x EOL | End of v2.x security patches |

---

## 📚 **v3.0.0 Documentation Plan**

### **New Documentation**
- [ ] v3.0.0 Migration Guide
- [ ] Cloud-Native Deployment Guide
- [ ] Caching Strategy Guide
- [ ] Security Best Practices v3
- [ ] Kubernetes Integration Guide

### **Updated Documentation**
- [ ] README.md (v3 focus)
- [ ] CHANGELOG.md (v3 section)
- [ ] VERSIONING_STRATEGY.md (v3 lifecycle)
- [ ] All example workflows

---

## 🎓 **Support Matrix (Post v3.0.0)**

| Version | Java Versions | Support Until | Status |
|---------|---------------|---------------|--------|
| **v3.0.0+** | 11, 17, 21, 23+ | Active | ✅ Full Support |
| **v2.2.0** | 8, 11, 17, 21, 23 | Jan 2027 | 🔶 Security Only |
| **v1.0.0** | 8, 11, 17, 21 | Jan 2026 | ⚠️ EOL Soon |

---

## 💡 **Design Principles for v3.0.0**

1. **Convention over Configuration**
   - Smart defaults
   - Auto-detection where possible
   - Less boilerplate

2. **Cloud-Native First**
   - Kubernetes as primary target
   - Container-optimized workflows
   - Cloud provider integrations

3. **Security by Default**
   - SBOM generation enabled
   - Security scanning always on
   - Supply chain verification

4. **Performance Focus**
   - Parallel execution by default
   - Advanced caching strategies
   - Incremental builds

5. **Developer Experience**
   - Clear error messages
   - Interactive configuration
   - IDE integration

---

## 🚀 **v3.0.0 Vision**

**Before (v2.x):**
```yaml
jobs:
  test:
    uses: org/workflows/.github/workflows/java-ci-universal.yml@v2
    with:
      java-version: '25'
      build-tool: 'maven'
      os-matrix: 'ubuntu-latest'
```

**After (v3.0.0):**
```yaml
jobs:
  # Simplified: Auto-detects everything
  test:
    uses: org/workflows/.github/workflows/java-ci.yml@v3
    with:
      java-version: '25'  # Only thing you need to specify!

  # Optional: Deploy to Kubernetes
  deploy:
    uses: org/workflows/.github/workflows/k8s-deploy.yml@v3
    with:
      cluster: 'production'
      namespace: 'myapp'
```

**Result:** 50% less configuration, 2x faster builds, cloud-native by default.

---

## 📊 **Success Metrics for v3.0.0**

- [ ] 90%+ of v2.x users migrate within 6 months
- [ ] Average CI time reduced by 30%
- [ ] Zero critical migration issues
- [ ] 95%+ user satisfaction
- [ ] Complete documentation coverage
- [ ] Active community contributions

---

## 🔗 **Related Documents**

- [CHANGELOG.md](CHANGELOG.md) - Version history
- [VERSIONING_STRATEGY.md](VERSIONING_STRATEGY.md) - Versioning policy
- [MIGRATION_GUIDE.md](MIGRATION_GUIDE.md) - v1→v2 migration (template for v2→v3)

---

## 💬 **Feedback & Discussion**

We want your input on v3.0.0!

**Where to provide feedback:**
- GitHub Discussions: Feature requests and ideas
- GitHub Issues: Bug reports and concerns
- Email: java-workflows@techishthoughts.org

**Key Questions:**
1. What features are most important to you?
2. Which breaking changes concern you most?
3. What would make migration easier?
4. What's missing from this roadmap?

---

**Last Updated:** November 2025
**Status:** Planning & Community Feedback
**Target Release:** Q3 2026

---

**🤖 Generated with [Claude Code](https://claude.com/claude-code)**
