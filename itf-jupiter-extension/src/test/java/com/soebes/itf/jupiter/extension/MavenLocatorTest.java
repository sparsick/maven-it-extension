package com.soebes.itf.jupiter.extension;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MavenLocatorTest {

    @Test
    void findMvn() {
        Properties properties = new Properties();
        properties.setProperty("maven.home", "./src/test/resources/maven-home");
        System.setProperties(properties);

        MavenLocator mavenLocatorUnderTest = new MavenLocator();
        Optional<File> mvnLocation = mavenLocatorUnderTest.findMvn();

        assertThat(mvnLocation)
                .isPresent()
                .get()
                .hasToString("./src/test/resources/maven-home/bin/mvn");

        System.clearProperty("maven.home");
    }
}