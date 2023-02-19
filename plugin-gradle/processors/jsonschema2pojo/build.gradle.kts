plugins {
    `kotlin-dsl`
    id("org.jsonschema2dataclass.internal.kotlin-target")
}

dependencies {
    compileOnly("org.jsonschema2pojo:jsonschema2pojo-core:1.2.1")
    implementation(project(":plugin-gradle:commons:kotlin-compat"))
    implementation(project(":plugin-gradle:processors:common"))

    testImplementation(platform("org.junit:junit-bom:5.9.2"))
    testImplementation(project(":plugin-gradle:commons:test-common"))
    testImplementation(project(":plugin-gradle:processors:common"))
    testImplementation(gradleTestKit())

    testImplementation("org.jsonschema2pojo:jsonschema2pojo-core:1.2.1")
}

tasks.test {
    useJUnitPlatform()
    systemProperty("junit.jupiter.testinstance.lifecycle.default", "per_method")
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
}
