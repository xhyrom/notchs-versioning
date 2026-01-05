<div align="center">
  <img src=".github/assets/icon.png" width="192" height="192" alt="logo">
  <h1>Notch's Versioning</h1>
</div>

<div align="center">

[![modrinth](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg)](https://modrinth.com/mod/notchs-versioning)
[![curseforge](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg)](https://www.curseforge.com/minecraft/mc-mods/notchs-versioning)
[![github](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/github_vector.svg)](https://github.com/xhyrom/notchs-versioning)

[![ko-fi](https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/donate/kofi-singular-alt_vector.svg)](https://ko-fi.com/xhyrom)

</div>

**Notch's Versioning** is a mod that restores the classic version numbering system used in Minecraft releases.

## What does it do?

Minecraft recently changed its versioning scheme from `<major>.<minor>.<patch>` (e.g., `1.21.1`) to `<year>.<drop>.<hotfix>` (e.g., `26.1.1`).

**Notch's Versioning** calculates and displays the "legacy" version number by continuing the count from **1.21** (the last version before the switch).

### The Logic
The mod treats every new **"Drop"** as a new minor update (1.x).

| Official Version | Logic | Legacy Version |
| :--- | :--- | :--- |
| **26.1** | The 1st drop after 1.21 | **1.22** |
| **26.1.5** | Hotfix remains the same | **1.22.5** |
| **26.2** | The 2nd drop | **1.23** |
| **26.2 Snapshot 1** | Snapshots are mapped too | **1.23 Snapshot 1** |
| **27.1** | Carries over drops from '26 | **1.xx** (calculated dynamically) |

This allows you to play the latest updates while keeping the nostalgic version numbers you are used to.

<div align="center">
    <img src=".github/assets/screen.png" alt="screen">
</div>