package com.soebes.itf.jupiter.extension;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
@Disabled("not running with other tests during a mvn build. Maybe because of maven.home")
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

    }
}