export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_144.jdk/Contents/Home

# cp -f .github/workflows/release/TVBoxOSC.jks app/TVBoxOSC.jks
# cp -f .github/workflows/release/build.gradle app/build.gradle
# cp -f .github/workflows/release/gradle.properties gradle.properties

./gradlew assemblerelease --build-cache --parallel --daemon --warning-mode all