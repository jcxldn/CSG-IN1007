
plugins {
    id("application")
}


// only configure projects with ex[0-9+] or lecture in the name
var projectRegex = Regex("ex\\d+|lecture")
configure(subprojects.filter { projectRegex.containsMatchIn(it.name) }) {
    apply(plugin = "application")
    apply(plugin = "java")

    group = "net.jcxldn.csg.in1007"

    fun getParents(): String {
        var res = ""
        
        var proj: Project? = this
        do {
            if (res == "") {
                res = proj!!.name
            } else {
                res = proj!!.name + "_" + res
            }

            proj = proj.getParent()
        } while (proj != null)

        return res.lowercase().replace("_weeks", "")
    }

    val parentProj = getParents()

    println("Discovered project '${getParents()}'")

    repositories {
        mavenCentral()
    }
    

    // Apply a specific Java toolchain to ease working on different environments.
    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }
    }

    // Set main class in MANIFEST.MF so we can do java -jar bleh.jar
    tasks.withType<Jar> {
        manifest {
            attributes["Main-Class"] = application.mainClass
        }
        archiveBaseName.set(parentProj)
    }

    // Enable stdin when using the "run" task.
    // https://blog.thecodewhisperer.com/permalink/stdin-gradle-kotlin-dsl
    tasks.withType<JavaExec>() {
        standardInput = System.`in`
    }
}