# Installation

Currently, FluidFX is not yet available on Maven or Gradle repos. You can, however, install via `mvn install`:

```shell
git clone https://github.com/mgcvale/FluidFX
cd FluidFX
mvn install
```

In your project, add:

```xml
<!-- pom.xml -->
<dependency>
    <groupId>dev.mgcvale</groupId>
    <artifactId>fluidfx</artifactId>
    <version>0.0.1</version>
</dependency>
```

Or, with gradle:
```groovy

repositories {
    mavenLocal()
    // other repos
}

dependencies {
    implementation 'dev.mgcvale:fluidfx:0.0.1'
}


```