plugins {
    id("java")
}

group = "com.zyixh.code"
version = "0.0.1-SNAPSHOT"

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

println("BUILD SCRIPT: This is executed during the configuration phase")

tasks.register("task1"){
    println("REGISTER TASK1: This is executed during the configuration phase")
}

tasks.register("task2"){
    println("REGISTER TASK2: This is executed during the configuration phase")
}

tasks.named("task1"){
    println("NAMED TASK1: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK1 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK1 - doLast: This is executed during the execution phase")
    }
}

tasks.named("task2"){
    println("NAMED TASK2: This is executed during the configuration phase")
    doFirst {
        println("NAMED TASK2 - doFirst: This is executed during the execution phase")
    }
    doLast {
        println("NAMED TASK2 - doLast: This is executed during the execution phase")
    }
}