# LFC Pulse v0.1 — Android starter project

Native Android Java starter app with a Liverpool-inspired home screen and Home, Fixtures, News and Live sections.

## Build in GitHub Actions

1. Create a GitHub repository and set its default branch to `main`.
2. Extract this ZIP on your phone or computer.
3. Upload the **contents** of the `LFC-Pulse` project folder into the repository, preserving the folders. The repository root must contain `settings.gradle`, `build.gradle`, `app/`, and `.github/workflows/`.
4. Commit the upload to `main`. The workflow runs automatically, or open **Actions** and manually run **Build LFC Pulse APK**.
5. Open the completed run, scroll to **Artifacts**, and download `LFC-Pulse-v0.1-debug`. Extract that artifact ZIP to get `app-debug.apk`.
6. On your Samsung, open the APK and approve installation from that source if Android prompts you.

The workflow installs Android SDK platform 35, uses Java 17 and Gradle 8.9, verifies the APK file exists, generates a SHA-256 checksum, and uploads both as an artifact.

## Important v0.1 limitations

The screens are real, navigable app screens, but fixtures, scores and news are not connected yet. No football API credentials or data provider were supplied, so the app does not fabricate live information. This is a debug starter, not a signed Play Store release.
