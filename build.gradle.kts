buildscript {
	extra.apply {
		set(
			"kotlin_version",
			"1.7.0"
		)
		set(
			"compose_version",
			"1.2.0"
		)
	}
	repositories {
		google()
		mavenCentral()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:7.3.0")
		classpath("org.jetbrains.dokka:dokka-gradle-plugin:${rootProject.extra["kotlin_version"]}")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${rootProject.extra["kotlin_version"]}")
	}
}
