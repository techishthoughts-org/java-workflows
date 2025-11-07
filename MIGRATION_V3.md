# Migration Guide: v2.x → v3.0.0

**⚠️ BREAKING CHANGES - Please read carefully**

---

## 🔴 **Breaking Changes Summary**

| Change | v2.x | v3.0.0 | Impact |
|--------|------|--------|--------|
| **Java 8** | ✅ Supported | ❌ Removed | Must upgrade to Java 11+ |
| **Workflow File** | `java-ci-universal.yml` | `java-ci.yml` | Update workflow reference |
| **build-tool Input** | Required | Optional (auto-detect) | Can remove input |
| **Default Java** | 21 | 25 (explicit) | Recommend explicit version |

---

## 🚀 **Quick Migration (5 Minutes)**

### Before (v2.x):
```yaml
jobs:
  ci:
    uses: org/workflows/.github/workflows/java-ci-universal.yml@v2
    with:
      java-version: '25'
      build-tool: 'maven'
```

### After (v3.0.0):
```yaml
jobs:
  ci:
    uses: org/workflows/.github/workflows/java-ci.yml@v3
    with:
      java-version: '25'
      # build-tool auto-detected!
```

### Changes:
1. ✏️ Update workflow file: `java-ci-universal.yml` → `java-ci.yml`
2. ✏️ Update version: `@v2` → `@v3`
3. ➖ Remove `build-tool` input (now auto-detected)
4. ✅ Verify Java version is 11+ (no Java 8)

---

## ⚠️ **Java 8 Removal**

If you're using Java 8:

**Option 1: Stay on v2.x** (Recommended for now)
- v2.x supported until January 2027
- Continue using `@v2` tag
- Plan upgrade to Java 11+

**Option 2: Upgrade to Java 11+**
```yaml
# Upgrade Java version
java-version: '11'  # or 17, 21, 25
```

---

## ✨ **New Features You Can Use**

### 1. **Simplified Configuration**
```yaml
# v3.0.0: Minimal configuration
jobs:
  ci:
    uses: org/workflows/.github/workflows/java-ci.yml@v3
    with:
      java-version: '25'
      # That's it! Everything else is auto-detected
```

### 2. **Kubernetes Deployment**
```yaml
jobs:
  deploy:
    uses: org/workflows/.github/workflows/k8s-deploy.yml@v3
    with:
      cluster-provider: 'eks'
      cluster-name: 'production'
      namespace: 'myapp'
      deployment-name: 'myapp'
      image-name: 'myapp:v1.0.0'
```

### 3. **SBOM Generation**
```yaml
steps:
  - uses: org/workflows/.github/actions/sbom-generate@v3
    with:
      build-tool: 'maven'
```

---

## 📊 **Migration Checklist**

- [ ] Check Java version (must be 11+)
- [ ] Update workflow file name to `java-ci.yml`
- [ ] Update version tag to `@v3`
- [ ] Remove `build-tool` input (optional)
- [ ] Test in feature branch
- [ ] Merge to production

---

## 🔗 **Support**

- **v2.x Support:** Until January 2027 (security patches)
- **Documentation:** See README.md
- **Issues:** Open GitHub issue

---

**Estimated Migration Time:** 5-15 minutes
**Risk Level:** Low (breaking changes well-documented)
